package com.hnu.bbs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hnu.bbs.common.api.ApiResult;
import com.hnu.bbs.entity.Comment;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.CommentDTO;
import com.hnu.bbs.entity.vo.CommentVO;
import com.hnu.bbs.service.CommentService;
import com.hnu.bbs.service.UserService;

import jakarta.annotation.Resource;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;

    @GetMapping("/get-comments")
    public ApiResult<List<CommentVO>> getCommentsByPostID(@RequestParam(value = "postId", defaultValue = "1") String postId) {
        List<CommentVO> commnents = commentService.getCommentsByPostID(postId);
        return ApiResult.success(commnents);
    }


    @PostMapping("/add-comment")
    public ApiResult<Comment> add_comment(@RequestHeader(value = "username") String username,
                                             @RequestBody CommentDTO dto) {
        User user = userService.getUserByUsername(username);
        Comment comment = commentService.create(dto, user);
        return ApiResult.success(comment);
    }
}
