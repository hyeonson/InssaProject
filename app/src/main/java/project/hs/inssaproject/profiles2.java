package project.hs.inssaproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class profiles2 extends AppCompatActivity {
    ImageButton btn_home;
    ImageButton btn_profiles;
    ImageButton btn_chatting;
    ImageButton btn_board;
    ImageButton btn_setting;
    ImageButton btn_all;
    ImageButton btn_loving;
    ListView allListView2 = null;
    ListViewAdapter allListViewAdapter2 = null;
    int userSize;
    List userIDs;

    //ImageView imgView;
    Bitmap bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles2);

        btn_home = (ImageButton)findViewById(R.id.btn_home);
        btn_chatting = (ImageButton)findViewById(R.id.btn_chatting);
        btn_profiles = (ImageButton)findViewById(R.id.btn_profiles);
        btn_setting = (ImageButton)findViewById(R.id.btn_setting);
        btn_board = (ImageButton)findViewById(R.id.btn_board);

        btn_all = (ImageButton)findViewById(R.id.btn_all);
        btn_loving = (ImageButton)findViewById(R.id.btn_loving);
        allListView2 = (ListView)findViewById(R.id.allListView2);

        userIDs = new ArrayList();

        setAllList();

        for(int i = 0; i < userIDs.size(); i++){
            setAllList2(userIDs.get(i).toString());
        }
        allListView2.setAdapter(allListViewAdapter2);
        /*
        imgView = findViewById(R.id.imgView);
        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    URL url = new URL("http://54.180.32.249:3000/uploads/1395728192374.jpg");
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                    bm = BitmapFactory.decodeStream(is);
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        try{
            thread.join();
            imgView.setImageBitmap(bm);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        */

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_home = new Intent(profiles2.this, MainActivity.class);
                intent_home.putExtra("user_id", MainActivity.user_id);
                startActivity(intent_home);
                finish();
            }
        });
        btn_profiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_profiles = new Intent(profiles2.this, profiles.class);
                startActivity(intent_profiles);
                finish();
            }
        });
        btn_chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_chattingList = new Intent(profiles2.this, chattingList.class);
                startActivity(intent_chattingList);
                finish();
            }
        });
        btn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_board = new Intent(profiles2.this, board.class);
                startActivity(intent_board);
                finish();
            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_setting = new Intent(profiles2.this, setting.class);
                startActivity(intent_setting);
                finish();
            }
        });
        btn_all.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_profiles = new Intent(profiles2.this, profiles.class);
                startActivity(intent_profiles);
                finish();
            }
        });
        btn_loving.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent_profiles2 = new Intent(profiles2.this, profiles2.class);
                startActivity(intent_profiles2);
                finish();
            }
        });
    }
    private void setAllList(){
        Retrofit retrofit =new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.BASEURL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Req_number req_number = new Req_number(MainActivity.user_id);
        Call<Res_string> res = apiService.likeYouList(req_number);
        Log.d("respon2", req_number.user_id);
        res.enqueue(new Callback<Res_string>() {
            @Override
            public void onResponse(Call<Res_string> call, Response<Res_string> response) {
                if(response.isSuccessful()){
                    if(response.body() != null) {
                        Log.d("####response.body2()###", "여길봐2");
                        Log.d("response.body()2", response.body().toString());
                        String userList = response.body().getList_id();
                        Log.d("userList", userList);
                        StringTokenizer recordToken = new StringTokenizer(userList, "$");

                        while(recordToken.hasMoreTokens()){
                            String temp_id = recordToken.nextToken();
                            userIDs.add(temp_id);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Res_string> call, Throwable t) {

            }
        });
    }
    ////////

    private void setAllList2(String temp_user_id){
        allListViewAdapter2 = new ListViewAdapter(this);
        Retrofit retrofit =new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.BASEURL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Req_number req_number = new Req_number(temp_user_id);
        Call<User> res = apiService.likeYouList2(req_number);
        res.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    if(response.body() != null) {
                        Log.d("####response.body()3###", "여길봐3");
                        Log.d("response.body()3", response.body().toString());
                        User user = response.body();
                        allListViewAdapter2.addItem(user.getUser_id(), user.getUser_major(), user.getUser_grade(), user.getUser_age());
                        Log.d("getUser_id()", user.getUser_id());
                        Log.d("getUser_major()", user.getUser_major());
                        Log.d("getUser_age()", Integer.toString(user.getUser_age()));
                        Log.d("getUser_grade()", Integer.toString(user.getUser_grade()));
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<profileListData> mListData = new ArrayList<profileListData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_profile_listview, null);
                //holder.mIcon = (ImageView) convertView.findViewById(R.id.mImage);
                holder.profile_id = (TextView) convertView.findViewById(R.id.profile_id);
                holder.profile_major = (TextView) convertView.findViewById(R.id.profile_major);
                holder.profile_age = (TextView) convertView.findViewById(R.id.profile_age);
                holder.profile_grade = (TextView) convertView.findViewById(R.id.profile_grade);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            profileListData mData = mListData.get(position);
                /*
                if (mData.mIcon != null) {
                    holder.mIcon.setVisibility(View.VISIBLE);
                    holder.mIcon.setImageDrawable(mData.mIcon);
                }else{
                    holder.mIcon.setVisibility(View.GONE);
                }
                */
            holder.profile_id.setText(mData.user_id);
            final String tmp_id = mData.user_id;
            holder.profile_major.setText(mData.major);
            holder.profile_grade.setText(Integer.toString(mData.grade));
            holder.profile_age.setText(Integer.toString(mData.age));

            holder.profile_id.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent_one_profile = new Intent(profiles2.this, one_profile.class);
                    intent_one_profile.putExtra("profile_id", tmp_id);
                    Log.d("profile_id", holder.profile_id.getText().toString());
                    startActivity(intent_one_profile);
                    finish();
                }
            });

            return convertView;
        }

        public void addItem(String _user_id, String _major, int _grade, int _age) {
            profileListData addInfo = null;
            addInfo = new profileListData(_user_id, _major, _grade, _age);
            //addInfo.user_id = _user_id;
            //addInfo.major = _major;
            //addInfo.age = _age;
            //addInfo.grade = _grade;
            mListData.add(addInfo);
        }
        /*
        public void remove(int position) {
            mListData.remove(position);
            dataChange();
        }
        */
            /*
            public void sort(){
                Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
                dataChange();
            }
            */
            /*
        public void dataChange() {
            allListViewAdapter.notifyDataSetChanged();
        }
        */
    }

    ////////

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent_home = new Intent(profiles2.this, MainActivity.class);
            intent_home.putExtra("user_id", MainActivity.user_id);
            startActivity(intent_home);
            finish();
        }
        return true;
    }
}
