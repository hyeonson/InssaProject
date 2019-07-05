package project.hs.inssaproject.Response;

import project.hs.inssaproject.Data.User;

public class Res_join {
    int code; //서버로부터의 응답 코드. 404, 500, 200 등.
    String msg; //서버로부터의 응답 메세지.
    User user;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public User getUser() {
        return user;
    }
}
