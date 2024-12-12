package com.hnu.bbs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnu.bbs.common.api.ApiResult;
import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.LoginDTO;
import com.hnu.bbs.entity.dto.RegisterDTO;
import com.hnu.bbs.service.PostService;
import com.hnu.bbs.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import static com.hnu.bbs.common.constants.RequestConstants.REQUEST_HEADER_USERNAME;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    
    @Resource
    private PostService postService;

    /**
     * 用户注册
     * @param dto
     * @return
     */
    @PostMapping("/register")
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto) {
        User user = userService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("账号注册失败");
        }
        Map<String, Object> map = new HashMap<>(1);
        map.put("user", user);
        return ApiResult.success(map);
    }

    /**
     * 用户登录
     * @param dto
     * @return
     */
    @PostMapping("/login")
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = userService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登录成功");
    }

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    @GetMapping("/info")
    public ApiResult<User> getUser(@RequestHeader(value = REQUEST_HEADER_USERNAME) String username) {
        User user = userService.getUserByUsername(username);
        return ApiResult.success(user);
    }

    /**
     * 注销
     * @return
     */
    @GetMapping("/logout")
    public ApiResult<Object> logOut() {
        return ApiResult.success(null, "注销成功");
    }

    /**
     * 获取用户及其帖子
     * @param username
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/{username}")
    public ApiResult<Map<String, Object>> getUserByName(@PathVariable("username") String username,
                                                        @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Map<String, Object> map = new HashMap<>(16);
        User curUser = userService.getUserByUsername(username);
        Assert.notNull(curUser, "用户不存在");
        Page<Post> page = postService.page(new Page<>(pageNo, pageSize),
                new LambdaQueryWrapper<Post>().eq(Post::getUserId, curUser.getId()));
        map.put("user", curUser);
        map.put("posts", page);
        return ApiResult.success(map);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public ApiResult<User> updateUser(@RequestBody User user) {
        Assert.notNull(user.getId(), "用户ID不能为空");
        userService.updateById(user);
        
        return ApiResult.success(user);
    }
}
