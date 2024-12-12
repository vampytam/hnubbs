package com.hnu.bbs.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hnu.bbs.entity.Tag;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVO implements Serializable {
    private static final long serialVersionUID = -261082150965211545L;

    /**
     * 文章ID
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 账号
     */
    private String username;
    /**
     * 标题
     */
    private String title;
    /**
     * 评论统计
     */
    private Integer comments;
    /**
     * 置顶
     */
    private Boolean top;
    /**
     * 加精
     */
    private Boolean quality;
    /**
     * 收藏次數
     */
    private Integer collects;
    /**
     * 帖子的关联标签
     */
    private List<Tag> tags;
    /**
     * 浏览量
     */
    private Integer views;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
}
