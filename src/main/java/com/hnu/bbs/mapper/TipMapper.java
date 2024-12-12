package com.hnu.bbs.mapper;

import com.hnu.bbs.entity.Tip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 每日赠言 Mapper 接口
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Mapper
public interface TipMapper extends BaseMapper<Tip> {

    /**
     * 获取随机小贴士
     * @return
     */
    Tip getRandomTip();

}
