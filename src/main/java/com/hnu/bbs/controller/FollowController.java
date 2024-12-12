package com.hnu.bbs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hnu.bbs.common.api.ApiResult;
import com.hnu.bbs.common.exception.ApiAsserts;
import com.hnu.bbs.entity.Follow;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.service.FollowService;
import com.hnu.bbs.service.UserService;
import static com.hnu.bbs.common.constants.RequestConstants.REQUEST_HEADER_USERNAME;

import jakarta.annotation.Resource;

/**
 * <p>
 * 用户关注 前端控制器
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/follow")
public class FollowController {

    @Resource
    private FollowService followService;

    @Resource
    private UserService userService;

    @GetMapping("/subscribe/{followeeId}")
    public ApiResult<Object> handleFollow(@RequestHeader(value = REQUEST_HEADER_USERNAME) String userName, 
        @PathVariable("followeeId") String followeeId) {
        User curUser = userService.getUserByUsername(userName);
        if (followeeId.equals(curUser.getId())) {
            ApiAsserts.fail("您脸皮太厚了，怎么可以关注自己呢 😮");
        }
        Follow one = followService.getOne(
                new LambdaQueryWrapper<Follow>()
                        .eq(Follow::getFolloweeId, followeeId)
                        .eq(Follow::getFollowerId, curUser.getId()));
        if (!ObjectUtils.isEmpty(one)) {
            ApiAsserts.fail("已关注");
        }

        Follow follow = new Follow();
        follow.setFolloweeId(followeeId);
        follow.setFollowerId(curUser.getId());
        followService.save(follow);
        return ApiResult.success(null, "关注成功");
    }

    @GetMapping("/unsubscribe/{followeeId}")
    public ApiResult<Object> handleUnFollow(@RequestHeader(value = REQUEST_HEADER_USERNAME) String username
            , @PathVariable("followeeId") String followeeId) {
        User curUser = userService.getUserByUsername(username);
        Follow one = followService.getOne(
                new LambdaQueryWrapper<Follow>()
                        .eq(Follow::getFolloweeId, followeeId)
                        .eq(Follow::getFollowerId, curUser.getId()));
        if (ObjectUtils.isEmpty(one)) {
            ApiAsserts.fail("未关注！");
        }

        followService.remove(new LambdaQueryWrapper<Follow>().eq(Follow::getFolloweeId, followeeId)
                .eq(Follow::getFollowerId, curUser.getId()));

        return ApiResult.success(null, "取关成功");
    }

    /**
     * 判断是否关注
     * @param username
     * @param postUserId
     * @return
     */
    @GetMapping("/validate/{postUserId}")
    public ApiResult<Map<String, Object>> isFollow(@RequestHeader(value = REQUEST_HEADER_USERNAME) String username
            , @PathVariable("postUserId") String postUserId) {
        User curUser = userService.getUserByUsername(username);
        Map<String, Object> map = new HashMap<>(1);
        map.put("hasFollow", false);
        if (!ObjectUtils.isEmpty(curUser)) {
            Follow one = followService.getOne(new LambdaQueryWrapper<Follow>()
                    .eq(Follow::getFolloweeId, postUserId)
                    .eq(Follow::getFollowerId, curUser.getId()));
            if (!ObjectUtils.isEmpty(one)) {
                map.put("hasFollow", true);
            }
        }
        return ApiResult.success(map);
    }
}
