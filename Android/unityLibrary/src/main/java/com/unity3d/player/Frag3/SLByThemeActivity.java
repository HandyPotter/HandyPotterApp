package com.unity3d.player.Frag3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.unity3d.player.R;
import com.unity3d.player.UnityPlayerActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SLByThemeActivity extends AppCompatActivity {

    public String theme;
    ArrayList<SignLanguage> slDataList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themelist);


        Intent intent = getIntent();

        theme = intent.getExtras().getString("item");
        TextView themename = (TextView)findViewById(R.id.theme_item);
        themename.setText(theme);
        Log.d("item", theme);


        this.InitializeSLData();

        ListView listView = (ListView)findViewById(R.id.List_SL);
        final SLByThemeAdapter slListAdapter = new SLByThemeAdapter(this, slDataList);
        listView.setAdapter(slListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        slListAdapter.getItem(position).getSL_WORD(),
                        Toast.LENGTH_LONG).show();

                String word2 = slListAdapter.getItem(position).getSL_WORD(); //여기가 테마별 클릭한 단어 값 넘어가는 곳

                Intent tomain2 = new Intent(SLByThemeActivity.this, UnityPlayerActivity.class);
                tomain2.putExtra("str",word2);
                startActivity(tomain2);

            }
        });

    }

    public void InitializeSLData() {

        slDataList = new ArrayList<SignLanguage>();

        Log.d("item", theme);

        if(theme.equals("일상생활")){

            slDataList.add(new SignLanguage("1","나", "1"));
            slDataList.add(new SignLanguage("2","너","1"));
            slDataList.add(new SignLanguage("3","사랑","1"));
            slDataList.add(new SignLanguage("5","달리기","1"));
            slDataList.add(new SignLanguage("6","다치다","1"));
            slDataList.add(new SignLanguage("7","아버지","1"));
            slDataList.add(new SignLanguage("8","어머니","1"));
            slDataList.add(new SignLanguage("10","감기","1"));
            slDataList.add(new SignLanguage("11","병원","1"));
            slDataList.add(new SignLanguage("12","걱정하다","1"));
            slDataList.add(new SignLanguage("13","가방","1"));
            slDataList.add(new SignLanguage("14","잘","1"));
            slDataList.add(new SignLanguage("15","능숙하다","1"));
            slDataList.add(new SignLanguage("16","이름","1"));
            slDataList.add(new SignLanguage("17","만나다","1"));
            slDataList.add(new SignLanguage("18","방문하다","1"));

        }
        else if(theme.equals("전문용어")){

            slDataList.add(new SignLanguage("42","정부","2"));
            slDataList.add(new SignLanguage("45","자제","2"));
            slDataList.add(new SignLanguage("46","권고","2"));
            slDataList.add(new SignLanguage("76","청탁","2"));
            slDataList.add(new SignLanguage("78","원활","2"));
            slDataList.add(new SignLanguage("99","변질","2"));
            slDataList.add(new SignLanguage("100","변환","2"));

        }else{

            slDataList.add(new SignLanguage("31","가수","3"));
            slDataList.add(new SignLanguage("104","가요","3"));

        }


    }
}
