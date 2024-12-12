package com.hnu.bbs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 帖子-标签 关联表
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Data
@Accessors(chain = true)
@TableName("bbs_post_tag")
public class PostTag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签ID
     */
    @TableField("tag_id")
    private String tagId;

    /**
     * 帖子ID
     */
    @TableField("post_id")
    private String postId;
}
