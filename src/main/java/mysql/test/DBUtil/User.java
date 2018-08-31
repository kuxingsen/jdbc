package mysql.test.DBUtil;

/**
 * Created by Kuexun on 2018/4/21.
 */
public class User {
    private String yb_userid;
    private String yb_username;
    private String yb_sex;
    private String phonenumber;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "yb_userid='" + yb_userid + '\'' +
                ", yb_username='" + yb_username + '\'' +
                ", yb_sex='" + yb_sex + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

    public String getYb_userid() {
        return yb_userid;
    }

    public void setYb_userid(String yb_userid) {
        this.yb_userid = yb_userid;
    }

    public String getYb_username() {
        return yb_username;
    }

    public void setYb_username(String yb_username) {
        this.yb_username = yb_username;
    }

    public String getYb_sex() {
        return yb_sex;
    }

    public void setYb_sex(String yb_sex) {
        this.yb_sex = yb_sex;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
