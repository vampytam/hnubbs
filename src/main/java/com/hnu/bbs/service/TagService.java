package com.hnu.bbs.service;

import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.Tag;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
public interface TagService extends IService<Tag> {

    /**
     * 插入标签
     *
     * @param tags
     * @return
     */
    List<Tag> insertTags(List<String> tags);
    
    /**
     * 获取标签关联帖子
     *
     * @param postPage
     * @param id
     * @return
     */
    Page<Post> selectPostsByTagId(Page<Post> postPage, String id);

}
