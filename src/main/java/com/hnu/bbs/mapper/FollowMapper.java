package com.hnu.bbs.mapper;

import com.hnu.bbs.entity.Follow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户关注 Mapper 接口
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Mapper
public interface FollowMapper extends BaseMapper<Follow> {

}
