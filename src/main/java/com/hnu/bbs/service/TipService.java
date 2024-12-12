package com.hnu.bbs.service;

import com.hnu.bbs.entity.Tip;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 每日赠言 服务类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
public interface TipService extends IService<Tip> {

    Tip getRandomTip();

}
