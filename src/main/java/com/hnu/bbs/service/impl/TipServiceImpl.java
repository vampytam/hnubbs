package com.hnu.bbs.service.impl;

import com.hnu.bbs.entity.Tip;
import com.hnu.bbs.mapper.TipMapper;
import com.hnu.bbs.service.TipService;

import lombok.extern.slf4j.Slf4j;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每日赠言 服务实现类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Slf4j
@Service
public class TipServiceImpl extends ServiceImpl<TipMapper, Tip> implements TipService {

    @Override
    public Tip getRandomTip() {
        Tip todayTip = null;
        try {
            todayTip = this.baseMapper.getRandomTip();
        } catch (Exception e) {
            log.info("tip获取失败");
        }
        return todayTip;
    }

}
