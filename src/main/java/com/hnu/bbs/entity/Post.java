package com.hnu.bbs.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("bbs_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 标题
     */
    @NotBlank(message = "标题不可以为空")
    @TableField(value = "title")
    private String title;

    /**
     * markdown内容
     */
    @NotBlank(message = "内容不可以为空")
    @TableField("`content`")
    private String content;

    /**
     * 作者ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 评论统计
     */
    @TableField("comments")
    private Integer comments;

    /**
     * 收藏统计
     */
    @TableField("collects")
    @Builder.Default
    private Integer collects = 0;

    /**
     * 浏览统计
     */
    @TableField("views")
    @Builder.Default
    private Integer views = 0;

    /**
     * 是否置顶，1-是，0-否
     */
    @TableField("top")
    @Builder.Default
    private Boolean top = false;

    /**
     * 是否加精，1-是，0-否
     */
    @TableField("quality")
    @Builder.Default
    private Boolean quality = false;

    /**
     * 专栏ID，默认不分栏
     */
    @TableField("section_id")
    @Builder.Default
    private Integer sectionId = 0;

    /**
     * 发布时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
    private Date modifyTime;
}
