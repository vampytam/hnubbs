package com.hnu.bbs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnu.bbs.common.api.ApiResult;
import com.hnu.bbs.entity.Promotion;
import com.hnu.bbs.service.PromotionService;

import jakarta.annotation.Resource;

/**
 * <p>
 * 广告推广表 前端控制器
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/promotion")
public class PromotionController {
    @Resource
    private PromotionService promotionService;

    @GetMapping("/all")
    public ApiResult<List<Promotion>> list() {
        List<Promotion> list = promotionService.list();
        return ApiResult.success(list);
    }
}
