package project.hs.inssaproject.Request;

public class Req_likeyou {
    String loved_id;
    String loving_id;

    public String getLoved_id() {
        return loved_id;
    }

    public String getLoving_id() {
        return loving_id;
    }

    public Req_likeyou(String _loved_id, String _loving_id){
        this.loved_id = _loved_id;
        this.loving_id = _loving_id;
    }
}
