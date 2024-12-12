package com.hnu.bbs.service.impl;

import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.PostTag;
import com.hnu.bbs.entity.Tag;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.CreatePostDTO;
import com.hnu.bbs.entity.vo.PostVO;
import com.hnu.bbs.entity.vo.ProfileVO;
import com.hnu.bbs.mapper.PostMapper;
import com.hnu.bbs.mapper.TagMapper;
import com.hnu.bbs.mapper.UserMapper;
import com.hnu.bbs.service.PostService;
import com.hnu.bbs.service.PostTagService;
import com.hnu.bbs.service.TagService;
import com.hnu.bbs.service.UserService;
import com.vdurmont.emoji.EmojiParser;

import jakarta.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Resource
    private TagMapper tagMapper;

    @Resource
    private UserMapper userMapper;

    @Autowired
    @Lazy
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostTagService postTagService;

    @Override
    public Page<PostVO> getList(Page<PostVO> page, String tab) {
        // 查询帖子
        Page<PostVO> iPage = this.baseMapper.selectListAndPage(page, tab);
        // 查询帖子的标签
        setPostTags(iPage);
        return iPage;
    }

    private void setPostTags(Page<PostVO> iPage) {
        iPage.getRecords().forEach(post -> {
            List<PostTag> postTags = postTagService.selectByPostId(post.getId());
            if (!postTags.isEmpty()) {
                List<String> tagIds = postTags.stream().map(PostTag::getTagId).collect(Collectors.toList());
                List<Tag> tags = tagMapper.selectByIds(tagIds);
                post.setTags(tags);
            }
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Post create(CreatePostDTO dto, User user) {
        Post post = this.baseMapper.selectOne(new LambdaQueryWrapper<Post>().eq(Post::getTitle, dto.getTitle()));
        Assert.isNull(post, "帖子已存在，请修改");

        // 封装
        post = Post.builder()
                .userId(user.getId())
                .title(dto.getTitle())
                .content(EmojiParser.parseToAliases(dto.getContent()))
                .createTime(new Date())
                .build();
        this.baseMapper.insert(post);

        // 用户积分增加
        int newScore = user.getScore() + 1;
        userMapper.updateById(user.setScore(newScore));

        // 标签
        if (!ObjectUtils.isEmpty(dto.getTags())) {
            // 保存标签
            List<Tag> tags = tagService.insertTags(dto.getTags());
            // 处理标签与帖子的关联
            postTagService.createPostTag(post.getId(), tags);
        }

        return post;
    }

    @Override
    public Map<String, Object> viewPost(String id) {
        Map<String, Object> map = new HashMap<>(16);
        Post post = this.baseMapper.selectById(id);
        Assert.notNull(post, "当前帖子不存在,或已被作者删除");
        // 查询帖子详情
        post.setViews(post.getViews() + 1);
        this.baseMapper.updateById(post);
        // emoji转码
        post.setContent(EmojiParser.parseToUnicode(post.getContent()));
        map.put("post", post);
        // 标签
        QueryWrapper<PostTag> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(PostTag::getPostId, post.getId());
        Set<String> set = new HashSet<>();
        for (PostTag posttag : postTagService.list(wrapper)) {
            set.add(posttag.getTagId());
        }
        List<Tag> tags = tagService.listByIds(set);
        map.put("tags", tags);

        // 作者
        ProfileVO user = userService.getUserProfile(post.getUserId());
        map.put("user", user);

        return map;
    }

    @Override
    public List<Post> getRecommend(String id) {
        return this.baseMapper.selectRecommend(id);
    }
    @Override
    public Page<PostVO> searchByKey(String keyword, Page<PostVO> page) {
        // 查询帖子
        Page<PostVO> iPage = this.baseMapper.searchByKey(page, keyword);
        // 查询帖子的标签
        setPostTags(iPage);
        return iPage;
    }
}
