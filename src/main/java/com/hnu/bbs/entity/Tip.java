package com.hnu.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 每日赠言
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("bbs_tip")
public class Tip implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 内容
     */
    @TableField("`content`")
    private String content;

    /**
     * 作者
     */
    @TableField("`author`")
    private String author;

    /**
     * 1：使用，0：过期
     */
    @TableField("`using`")
    @Builder.Default
    private boolean using = true;
}
