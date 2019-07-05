package project.hs.inssaproject.Response;

public class Res_lm {
    String user_loved;
    String user_matched;
    public Res_lm(String _user_loved, String _user_matched){
        this.user_loved = _user_loved;
        this.user_matched = _user_matched;
    }

    public String getUser_loved() {
        return user_loved;
    }

    public String getUser_matched() {
        return user_matched;
    }
}
