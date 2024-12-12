package com.hnu.bbs.service.impl;

import com.hnu.bbs.entity.PostTag;
import com.hnu.bbs.entity.Tag;
import com.hnu.bbs.mapper.PostTagMapper;
import com.hnu.bbs.service.PostTagService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子-标签 关联表 服务实现类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Service
public class PostTagServiceImpl extends ServiceImpl<PostTagMapper, PostTag> implements PostTagService {

    @Override
    public List<PostTag> selectByPostId(String postId) {
        QueryWrapper<PostTag> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(PostTag::getPostId, postId);
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public void createPostTag(String id, List<Tag> tags) {
        // 先删除postId对应的所有记录
        this.baseMapper.delete(new LambdaQueryWrapper<PostTag>().eq(PostTag::getPostId, id));

        // 循环保存对应关联
        tags.forEach(tag -> {
            PostTag postTag = new PostTag();
            postTag.setPostId(id);
            postTag.setTagId(tag.getId());
            this.baseMapper.insert(postTag);
        });
    }

    @Override
    public Set<String> selectPostIdsByTagId(String id) {
        return this.baseMapper.getPostIdsByTagId(id);
    }

}
