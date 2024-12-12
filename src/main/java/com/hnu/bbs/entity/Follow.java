package com.hnu.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 用户关注
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Data
@NoArgsConstructor
@TableName("bbs_follow")
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 被关注人ID
     */
    @TableField("followee_id")
    private String followeeId;

    /**
     * 关注人ID
     */
    @TableField("follower_id")
    private String followerId;
}
