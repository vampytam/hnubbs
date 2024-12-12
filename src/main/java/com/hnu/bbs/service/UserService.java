package com.hnu.bbs.service;

import com.hnu.bbs.entity.User;
import com.hnu.bbs.entity.dto.LoginDTO;
import com.hnu.bbs.entity.dto.RegisterDTO;
import com.hnu.bbs.entity.vo.ProfileVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
public interface UserService extends IService<User> {
    /**
     * 注册功能
     *
     * @param dto
     * @return 注册对象
     */
    User executeRegister(RegisterDTO dto);
    
    /**
     * 获取用户信息
     *
     * @param username
     * @return dbUser
     */
    User getUserByUsername(String username);
    
    /**
     * 用户登录
     *
     * @param dto
     * @return 生成的JWT的token
     */
    String executeLogin(LoginDTO dto);

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return
     */
    ProfileVO getUserProfile(String id);

}
