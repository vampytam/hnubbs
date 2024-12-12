package com.hnu.bbs.service.impl;

import com.hnu.bbs.config.jwt.JwtUtil;
import com.hnu.bbs.entity.Follow;
import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.LoginDTO;
import com.hnu.bbs.entity.dto.RegisterDTO;
import com.hnu.bbs.entity.vo.ProfileVO;
import com.hnu.bbs.mapper.FollowMapper;
import com.hnu.bbs.mapper.PostMapper;
import com.hnu.bbs.mapper.UserMapper;
import com.hnu.bbs.service.UserService;
import com.hnu.bbs.utils.MD5Utils;
import com.hnu.bbs.common.exception.ApiAsserts;

import lombok.extern.slf4j.Slf4j;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private FollowMapper followMapper;

    @Override
    public User executeRegister(RegisterDTO dto) {
        //查询是否有相同用户名的用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, dto.getUsername()).or().eq(User::getEmail, dto.getEmail());
        User user = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(user)) {
            ApiAsserts.fail("账号或邮箱已存在！");
        }
        User addUser = User.builder()
                .username(dto.getUsername())
                .nickname(dto.getUsername())
                .password(MD5Utils.getPwd(dto.getPassword()))
                .email(dto.getEmail())
                .createTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }

    @Override
    public User getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;
        try {
            User user = getUserByUsername(dto.getUsername());
            String encodePwd = MD5Utils.getPwd(dto.getPassword());
            if(!encodePwd.equals(user.getPassword()))
            {
                throw new Exception("密码错误");
            }
            token = JwtUtil.generateToken(String.valueOf(user.getUsername()));
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("用户不存在or密码验证失败=======>{}", dto.getUsername());
        }
        return token;
    }

    @Override
    public ProfileVO getUserProfile(String id) {
        ProfileVO profile = new ProfileVO();
        User user = baseMapper.selectById(id);
        BeanUtils.copyProperties(user, profile);
        // 用户文章数
        int count = postMapper.selectCount(new LambdaQueryWrapper<Post>().eq(Post::getUserId, id)).intValue();
        profile.setPostCount(count);

        // 粉丝数
        int followers = followMapper.selectCount((new LambdaQueryWrapper<Follow>().eq(Follow::getFolloweeId, id))).intValue();
        profile.setFollowerCount(followers);

        // 关注数
        int followees = followMapper.selectCount((new LambdaQueryWrapper<Follow>().eq(Follow::getFollowerId, id))).intValue();
        profile.setFollowCount(followees);

        return profile;
    }

}
