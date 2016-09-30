package service.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import exception.UserExistException;
import service.IUserService;

/**
 * Created by Administrator on 2016/9/26.
 */
public class UserServiceImpl implements IUserService {

    private IUserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) throws UserExistException {
        if (userDao.find(user.getUserName()) != null) {
            //checked exception
            //unchecked exception
            //�����ױ���ʱ�쳣��ԭ����������һ�����������쳣���Ը��û�һ���Ѻ���ʾ
            throw new UserExistException("ע����û����Ѵ��ڣ�����");
        }
        userDao.add(user);
    }

    @Override
    public User loginUser(String userName, String userPwd) {
        return userDao.find(userName, userPwd);
    }
}
