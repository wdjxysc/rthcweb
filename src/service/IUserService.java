package service;

import domain.User;
import exception.UserExistException;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface IUserService {
    /**
     * 提供注册服务
     *
     * @param user
     * @throws UserExistException
     */
    void registerUser(User user) throws UserExistException;

    /**
     * 提供登录服务
     *
     * @param userName
     * @param userPwd
     * @return
     */
    User loginUser(String userName, String userPwd);
}
