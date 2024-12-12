package com.hnu.bbs.service;

import com.hnu.bbs.entity.Comment;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.CommentDTO;
import com.hnu.bbs.entity.vo.CommentVO;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
public interface CommentService extends IService<Comment> {
/**
     *
     *
     * @param postId
     * @return {@link CommentVO}
     */
    List<CommentVO> getCommentsByPostID(String postId);

    Comment create(CommentDTO dto, User principal);
}
