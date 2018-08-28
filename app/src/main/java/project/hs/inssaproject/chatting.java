package project.hs.inssaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class chatting extends AppCompatActivity {
    //자신의 아이디 : MainActivity.user_id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        Intent intent = getIntent();
        String profile_id = intent.getStringExtra("profile_id"); //상대방의 아이디

    }
}
