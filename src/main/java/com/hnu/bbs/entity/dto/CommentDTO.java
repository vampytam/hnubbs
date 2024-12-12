package com.hnu.bbs.entity.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class CommentDTO implements Serializable {
    private static final long serialVersionUID = -5957433707110390852L;


    private String postId;

    /**
     * 内容
     */
    private String content;
}
