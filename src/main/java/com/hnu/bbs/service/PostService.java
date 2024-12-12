package com.hnu.bbs.service;

import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.CreatePostDTO;
import com.hnu.bbs.entity.vo.PostVO;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 帖子表 服务类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
public interface PostService extends IService<Post> {
    /**
     * 获取首页帖子列表
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> getList(Page<PostVO> page, String tab);
    /**
     * 发布
     *
     * @param dto
     * @param principal
     * @return
     */
    Post create(CreatePostDTO dto, User principal);

    /**
     * 查看帖子详情
     *
     * @param id
     * @return
     */
    Map<String, Object> viewPost(String id);
    /**
     * 获取随机推荐10篇
     *
     * @param id
     * @return
     */
    List<Post> getRecommend(String id);
    /**
     * 关键字检索
     *
     * @param keyword
     * @param page
     * @return
     */
    Page<PostVO> searchByKey(String keyword, Page<PostVO> page);
}
