package dao;

import domain.User;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface IUserDao {
    /**
     * �����û����������������û�
     *
     * @param userName
     * @param userPwd
     * @return �鵽�����û�
     */
    User find(String userName, String userPwd);


    /**
     * ����û�
     *
     * @param user
     */
    void add(User user);

    /**
     * �����û����������û�
     *
     * @param userName
     * @return �鵽�����û�
     */
    User find(String userName);
}
