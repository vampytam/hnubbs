package com.hnu.bbs.entity.vo;

import lombok.Data;

@Data
public class ProfileVO {

    /**
     * 用户ID
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 关注数
     */
    private Integer followCount;

    /**
     * 关注者数
     */
    private Integer followerCount;

    /**
     * 帖子数
     */
    private Integer postCount;

    /**
     * 专栏数
     */
    private Integer columns;

    /**
     * 评论数
     */
    private Integer commentCount;

}
