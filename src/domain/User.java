package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/26.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -4313782718477229465L;
    // �û�ID
    private String id;
    // �û���
    private String userName;
    // �û�����
    private String userPwd;
    // �û�����
    private String email;
    // �û�����
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
