package com.hnu.bbs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnu.bbs.common.api.ApiResult;
import com.hnu.bbs.entity.Tip;
import com.hnu.bbs.service.TipService;

import jakarta.annotation.Resource;

/**
 * <p>
 * 每日赠言 前端控制器
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/tip")
public class TipController {
    @Resource
    private TipService tipService;

    @GetMapping("/today")
    public ApiResult<Tip> getRandomTip() {
        Tip tip = tipService.getRandomTip();
        return ApiResult.success(tip);
    }
}
