package project.hs.inssaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profiles extends AppCompatActivity {
    Button btn_home;
    Button btn_profiles;
    Button btn_chatting;
    Button btn_board;
    Button btn_setting;
    TextView static_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        btn_home = findViewById(R.id.btn_home);
        btn_chatting = findViewById(R.id.btn_chatting);
        btn_profiles = findViewById(R.id.btn_profiles);
        btn_setting = findViewById(R.id.btn_setting);
        btn_board = findViewById(R.id.btn_board);
        static_test = findViewById(R.id.static_test);

        static_test.setText(MainActivity.user_id);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(profiles.this, MainActivity.class);
                startActivity(intent_home);
                finish();
            }
        });
        btn_profiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_profiles = new Intent(profiles.this, profiles.class);
                startActivity(intent_profiles);
                finish();
            }
        });
        btn_chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_chattingList = new Intent(profiles.this, chattingList.class);
                startActivity(intent_chattingList);
                finish();
            }
        });
        btn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_board = new Intent(profiles.this, board.class);
                startActivity(intent_board);
                finish();
            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_setting = new Intent(profiles.this, setting.class);
                startActivity(intent_setting);
                finish();
            }
        });
    }
}
