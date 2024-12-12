package com.hnu.bbs.mapper;

import com.hnu.bbs.entity.PostTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 帖子-标签 关联表 Mapper 接口
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Mapper
public interface PostTagMapper extends BaseMapper<PostTag> {

    /**
     * 根据标签获取帖子ID集合
     *
     * @param id
     * @return
     */
    Set<String> getPostIdsByTagId(@Param("id") String id);
}
