package com.hnu.bbs.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("bbs_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID：使用雪花算法（Snowflake）来生成全局唯一的ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 密码
     */
    @JsonIgnore()
    @TableField("password")
    private String password;

    /**
     * 头像
     */
    @Builder.Default
    @TableField("avatar")
    private String avatar = "https://s3.ax1x.com/2020/12/01/DfHNo4.jpg";;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 积分
     */
    @Builder.Default
    @TableField("score")
    private Integer score = 0;

    /**
     * 口令
     */
    @JsonIgnore()
    @TableField("token")
    private String token;

    /**
     * 个人简介
     */
    @Builder.Default
    @TableField("bio")
    private String bio = "这个人很懒，什么都没有留下";

    /**
     * 是否激活，1：是，0：否
     */
    @Builder.Default
    @TableField("active")
    private Boolean active = true;

    /**
     * 状态，1：使用，0：停用
     */
    @Builder.Default
    @TableField("status")
    private Boolean status = false;

    /**
     * 用户角色
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 加入时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;
}
