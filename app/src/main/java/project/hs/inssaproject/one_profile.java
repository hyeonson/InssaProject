package project.hs.inssaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class one_profile extends AppCompatActivity {
    TextView profile_id;
    TextView profile_name;
    TextView profile_age;
    TextView profile_grade;
    TextView profile_sex;
    TextView profile_saying;
    TextView profile_major;
    ImageView image_select;
    Button btn_back;
    Button btn_loving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_profile);

        profile_id = (TextView)findViewById(R.id.profile_id);
        profile_name = (TextView)findViewById(R.id.profile_name);
        profile_age = (TextView)findViewById(R.id.profile_age);
        profile_grade = (TextView)findViewById(R.id.profile_grade);
        profile_sex = (TextView)findViewById(R.id.profile_sex);
        profile_saying = (TextView)findViewById(R.id.profile_saying);
        profile_major = (TextView)findViewById(R.id.profile_major);
        image_select = (ImageView)findViewById(R.id.image_select);
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_loving = (Button)findViewById(R.id.btn_loving);

        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent_profiles = new Intent(one_profile.this, profiles.class);
                startActivity(intent_profiles);
                finish();
            }
        });

    }

}
