package me.gacl.service;

import me.gacl.domain.User;

public interface IUserService {
    /**
     * 注册
     */
    void registerUser(User user);

    /**
     * 提供登录服务
     */
    User loginUser(String userid, String userpawd);
}
