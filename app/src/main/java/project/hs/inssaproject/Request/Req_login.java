package project.hs.inssaproject.Request;

public class Req_login {
    String user_id;
    String user_pw;

    public String getUser_id() {
        return user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public Req_login(String _user_id, String _user_pw){
        this.user_id = _user_id;
        this.user_pw = _user_pw;
    }
}
