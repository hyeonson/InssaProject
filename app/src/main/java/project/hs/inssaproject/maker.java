package project.hs.inssaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class maker extends AppCompatActivity {
    Intent intent;
    public static String user_id;
    ImageButton btn_home;
    ImageButton btn_profiles;
    ImageButton btn_chatting;
    ImageButton btn_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maker);

        intent = getIntent();
        user_id = intent.getStringExtra("user_id");
        btn_home = (ImageButton)findViewById(R.id.btn_home);
        btn_chatting = (ImageButton)findViewById(R.id.btn_chatting);
        btn_profiles = (ImageButton)findViewById(R.id.btn_profiles);
        btn_setting = (ImageButton)findViewById(R.id.btn_setting);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(maker.this, MainActivity.class);
                intent_home.putExtra("user_id", MainActivity.user_id);
                startActivity(intent_home);
                finish();
            }
        });
        btn_profiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_profiles = new Intent(maker.this, profiles.class);
                startActivity(intent_profiles);
                finish();
            }
        });
        btn_chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_chattingList = new Intent(maker.this, chattingList.class);
                startActivity(intent_chattingList);
                finish();
            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_setting = new Intent(maker.this, setting.class);
                startActivity(intent_setting);
                finish();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent_home = new Intent(maker.this, MainActivity.class);
            intent_home.putExtra("user_id", MainActivity.user_id);
            startActivity(intent_home);
            finish();
        }
        return true;
    }
}
