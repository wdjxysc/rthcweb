package service;

import domain.User;
import exception.UserExistException;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface IUserService {
    /**
     * �ṩע�����
     *
     * @param user
     * @throws UserExistException
     */
    void registerUser(User user) throws UserExistException;

    /**
     * �ṩ��¼����
     *
     * @param userName
     * @param userPwd
     * @return
     */
    User loginUser(String userName, String userPwd);
}
