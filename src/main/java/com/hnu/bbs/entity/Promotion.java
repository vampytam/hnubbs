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
 * 广告推广表
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Data
@NoArgsConstructor
@TableName("bbs_promotion")
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 广告标题
     */
    @TableField("title")
    private String title;

    /**
     * 广告链接
     */
    @TableField("link")
    private String link;

    /**
     * 说明
     */
    @TableField("`description`")
    private String description;
}
