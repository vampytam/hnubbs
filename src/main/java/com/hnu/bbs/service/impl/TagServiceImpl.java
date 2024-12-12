package com.hnu.bbs.service.impl;

import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.Tag;
import com.hnu.bbs.mapper.TagMapper;
import com.hnu.bbs.service.PostService;
import com.hnu.bbs.service.PostTagService;
import com.hnu.bbs.service.TagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private PostTagService postTagService;

    @Autowired
    private PostService postService;
    
    @Override
    public List<Tag> insertTags(List<String> tags) {
        List<Tag> tagList = new ArrayList<>();
        for (String tagName : tags) {
            Tag tag = this.baseMapper.selectOne(new LambdaQueryWrapper<Tag>().eq(Tag::getName, tagName));
            if (tag == null) {
                tag = Tag.builder().name(tagName).build();
                this.baseMapper.insert(tag);
            } else {
                tag.setPostCount(tag.getPostCount() + 1);
                this.baseMapper.updateById(tag);
            }
            tagList.add(tag);
        }
        return tagList;
    }

    @Override
    public Page<Post> selectPostsByTagId(Page<Post> postPage, String id) {
        // 获取关联的帖子ID
        Set<String> ids = postTagService.selectPostIdsByTagId(id);
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Post::getId, ids);

        return postService.page(postPage, wrapper);
    }
}
