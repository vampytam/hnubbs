package com.hnu.bbs.service.impl;

import com.hnu.bbs.entity.Comment;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.CommentDTO;
import com.hnu.bbs.entity.vo.CommentVO;
import com.hnu.bbs.mapper.CommentMapper;
import com.hnu.bbs.service.CommentService;

import lombok.extern.slf4j.Slf4j;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Slf4j
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public List<CommentVO> getCommentsByPostID(String postId) {
        List<CommentVO> comments = new ArrayList<CommentVO>();
        try {
            comments = this.baseMapper.getCommentsByPostID(postId);
        } catch (Exception e) {
            log.info("comments失败");
        }
        return comments;
    }

    @Override
    public Comment create(CommentDTO dto, User user) {
        Comment comment = Comment.builder()
                .userId(user.getId())
                .content(dto.getContent())
                .postId(dto.getPostId())
                .createTime(new Date())
                .build();
        this.baseMapper.insert(comment);
        return comment;
    }
}
