package com.hnu.bbs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnu.bbs.common.api.ApiResult;
import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.Tag;
import com.hnu.bbs.service.TagService;

import jakarta.annotation.Resource;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/{name}")
    public ApiResult<Map<String, Object>> getPostsByTag(
            @PathVariable("name") String tagName,
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        Map<String, Object> map = new HashMap<>(16);

        LambdaQueryWrapper<Tag> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Tag::getName, tagName);
        Tag one = tagService.getOne(wrapper);
        Assert.notNull(one, "标签不存在，或已被管理员删除");
        Page<Post> posts = tagService.selectPostsByTagId(new Page<>(pageNo, pageSize), one.getId());
        // 其他热门标签
        Page<Tag> hotTags = tagService.page(new Page<>(1, 10),
                new LambdaQueryWrapper<Tag>()
                        .notIn(Tag::getName, tagName)
                        .orderByDesc(Tag::getPostCount));

        map.put("posts", posts);
        map.put("hotTags", hotTags);

        return ApiResult.success(map);
    }
}
