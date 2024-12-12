package com.hnu.bbs.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hnu.bbs.common.api.ApiResult;
import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.CreatePostDTO;
import com.hnu.bbs.entity.vo.PostVO;
import com.hnu.bbs.service.PostService;
import com.hnu.bbs.service.UserService;
import com.vdurmont.emoji.EmojiParser;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;


import static com.hnu.bbs.common.constants.RequestConstants.REQUEST_HEADER_USERNAME;

/**
 * <p>
 * 帖子表 前端控制器
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/post")
public class PostController {
    
    @Resource
    private PostService postService;

    @Resource
    private UserService userService;

    /**
     * 获取帖子列表
     * @param tab 分栏，可选值 hot(热门)、latest(最新)、good(精华)
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<PostVO> list = postService.getList(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }

    /**
     * 搜索帖子
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/search")
    public ApiResult<Page<PostVO>> searchList(@RequestParam("keyword") String keyword,
                                              @RequestParam("pageNo") Integer pageNo,
                                              @RequestParam("pageSize") Integer pageSize) {
        Page<PostVO> results = postService.searchByKey(keyword, new Page<>(pageNo, pageSize));
        return ApiResult.success(results);
    }

    /**
     * 创建帖子
     * @param username
     * @param dto
     * @return
     */
    @PostMapping("/create")
    public ApiResult<Post> create(@RequestHeader(value = REQUEST_HEADER_USERNAME) String username
            , @RequestBody CreatePostDTO dto) {
        User user = userService.getUserByUsername(username);
        Post post = postService.create(dto, user);

        return ApiResult.success(post);
    }

    /**
     * 查看帖子详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public ApiResult<Map<String, Object>> view(@RequestParam("id") String id) {
        Map<String, Object> map = postService.viewPost(id);
        return ApiResult.success(map);
    }

    /**
     * 获取推荐帖子
     * @param id
     * @return
     */
    @GetMapping("/recommend")
    public ApiResult<List<Post>> getRecommend(@RequestParam("id") String id) {
        List<Post> posts = postService.getRecommend(id);

        return ApiResult.success(posts);
    }

    /**
     * 更新帖子
     * @param username
     * @param post
     * @return
     */
    @PostMapping("/update")
    public ApiResult<Post> update(@RequestHeader(value = REQUEST_HEADER_USERNAME) String username, 
        @Valid @RequestBody Post post) {
        User curUser = userService.getUserByUsername(username);
        Assert.isTrue(curUser.getId().equals(post.getUserId()), "非本人无权修改");
        post.setModifyTime(new Date());
        post.setContent(EmojiParser.parseToAliases(post.getContent()));
        postService.updateById(post);
        return ApiResult.success(post);
    }

    /**
     * 删除帖子
     * @param username
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ApiResult<String> delete(@RequestHeader(value = REQUEST_HEADER_USERNAME) String username, 
        @PathVariable("id") String id) {
        User curUser = userService.getUserByUsername(username);
        Post post = postService.getById(id);
        Assert.notNull(post, "来晚一步，帖子已不存在");
        Assert.isTrue(post.getUserId().equals(curUser.getId()), "你为什么想删除别人的帖子？？？");
        
        postService.removeById(id);
        return ApiResult.success(null,"删除成功");
    }
}
