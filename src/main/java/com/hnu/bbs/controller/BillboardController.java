package com.hnu.bbs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hnu.bbs.common.api.ApiResult;
import com.hnu.bbs.entity.Billboard;
import com.hnu.bbs.service.BillboardService;

import jakarta.annotation.Resource;

/**
 * <p>
 * 全站公告 前端控制器
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/billboard")
public class BillboardController {

    @Resource
    private BillboardService billboardService;

    /**
     * 获取最新公告：
     * @return
     */
    @GetMapping("/show")
    public ApiResult<Billboard> getNotices(){
        List<Billboard> list = billboardService.list(new
                LambdaQueryWrapper<Billboard>().eq(Billboard::isOnline,true));
        return ApiResult.success(list.get(list.size()- 1));
    }

}
