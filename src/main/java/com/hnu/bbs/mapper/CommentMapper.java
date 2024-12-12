package com.hnu.bbs.mapper;

import com.hnu.bbs.entity.Comment;
import com.hnu.bbs.entity.vo.CommentVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * getCommentsByPostID
     *
     * @param postId
     * @return
     */
    List<CommentVO> getCommentsByPostID(@Param("postId") String postId);
}
