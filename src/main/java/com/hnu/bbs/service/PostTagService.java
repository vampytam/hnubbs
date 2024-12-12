package com.hnu.bbs.service;

import com.hnu.bbs.entity.PostTag;
import com.hnu.bbs.entity.Tag;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 帖子-标签 关联表 服务类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
public interface PostTagService extends IService<PostTag> {

    /**
     * 获取postId Tag 关联记录
     *
     * @param postId postId
     * @return
     */
    List<PostTag> selectByPostId(String postId);
    
    /**
     * 创建中间关系
     *
     * @param id
     * @param tags
     * @return
     */
    void createPostTag(String id, List<Tag> tags);

    /**
     * 获取标签关联的帖子ID集合
     *
     * @param id
     * @return
     */
    Set<String> selectPostIdsByTagId(String id);

}
