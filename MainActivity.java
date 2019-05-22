package com.example.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // String[] list = {"이순신", "광개토대왕", "신사임당", "세종대왕", "이성계"};
        String[] list = getResources().getStringArray(R.array.people);


       /* final String[] list_explain = {
                ":이순신",
                "광개토대왕",
                "신사임당",
                "세종대왕",
                "이성계"
        };  //listView의 항목 눌렀을때 나오는 설명내용 배열에 입력
        */

       //data2.xml 파일에 저장한 원본데이터를 getResources 이용하여 사용하는법
        final String[] list_explain = getResources().getStringArray(R.array.achievement);



        ArrayAdapter<String> adapter; //ArrayAdapter생성

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list); //텍스트뷰 하나로 구성된 레이아웃(안드로이드 기본제공 ListView 레이아웃)

        ListView listView = (ListView) findViewById(R.id.ListView);

        //리스트뷰에 어댑터 설정
        listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Toast.makeText(getApplicationContext(), ((TextView) view).getText() + list_explain[i], Toast.LENGTH_LONG).show();
        }
    });





    }
}
