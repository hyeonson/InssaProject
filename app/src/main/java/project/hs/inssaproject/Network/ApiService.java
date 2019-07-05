package project.hs.inssaproject.Network;

import java.util.List;

import okhttp3.MultipartBody;
import project.hs.inssaproject.Request.Req_likeyou;
import project.hs.inssaproject.Request.Req_login;
import project.hs.inssaproject.Request.Req_number;
import project.hs.inssaproject.Response.Res_img;
import project.hs.inssaproject.Response.Res_join;
import project.hs.inssaproject.Response.Res_lm;
import project.hs.inssaproject.Response.Res_number;
import project.hs.inssaproject.Response.Res_string;
import project.hs.inssaproject.Data.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {
    static final String BASEURL  = "http://54.180.32.249:3000";

    @POST("signup_test")
    Call<Res_join> join(@Body User user); //보낼때는 Req로 보내고 받을 때는 Res로 받음.

    @POST("login")
    Call<Res_img> login(@Body Req_login req_login);

    @POST("numberSetting")
    Call<Res_number> numberSetting(@Body Req_number req_number);

    @POST("showProfile")
    Call<User> showProfile(@Body Req_number req_number);

    @POST("allProfile")
    Call<List<User>> allProfile();

    @POST("likeYou")
    Call<Res_img> likeYou(@Body Req_likeyou req_likeyou);

    @POST("likeYou2")
    Call<Res_img> likeYou2(@Body Req_likeyou req_likeyou);

    @POST("likeYouList")
    Call<Res_string> likeYouList(@Body Req_number req_number);
    //Call<Res_string> likeYouList(@Body Req_number req_number);

    @POST("likeYouList2")
    Call<User> likeYouList2(@Body Req_number req_number);

    @POST("matchedList")
    Call<Res_string> matchedList(@Body Req_number req_number);

    @POST("matchedList2")
    Call<User> matchedList2(@Body Req_number req_number);

    @POST("getlm")
    Call<Res_lm> getlm(@Body Req_number req_number);

    @Multipart
    @POST("imgUpload/{userID}")
    Call<Res_img> uploadAttachment(@Part MultipartBody.Part file, @Path("userID") String userID);//@Part("description") RequestBody description);@Path("filename") String filename);//, @Part("name") RequestBody description);
    //Call<JsonObject> getSuccess (@Query("getSuc);
}
