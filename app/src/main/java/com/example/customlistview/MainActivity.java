package com.example.customlistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView list;
/*    String[] titles = {"링컨 뉴 MKX 3.7 AWD","MINI 쿠퍼 클럽맨 D","폭스바겐 더 비틀 2.0 TDI"};
    Integer[] images = { R.drawable.car5,R.drawable.car6,R.drawable.car7};
    String[] names = {"일진선","이진선","삼진선","사진선", "오진선", "육진선", "칠진선"};
    String[] phones = {"050-1111-1111","050-1111-1111","050-1111-1111","050-1111-1111","050-1111-1111","050-1111-1111","050-1111-1111"};
    Integer[] costs = {100,200,300,400,500,600,700};
    String[] year = {};
    String[] fuelEconomy = {};
    String[] color = {};
    String[] transmission = {};
    String[] displacement = {};
    String[] mileage = {};
    String[] fuel = {};
    String[] hasAccident = {};
*/

    ArrayList <rowData> dataList;
    //ArrayList<Object> arr = new ArrayList<>();
    String[] titles;

    rowData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = new ArrayList<>();

        dataList.add(new rowData("벤츠 뉴 S클래스 S350", R.drawable.car1, "일진선", "050-1111-1111", 600, "2017/10","13km/l", "검정", "자동", "3000cc", "7000km","디젤", "무"));
        dataList.add(new rowData("BMW 뉴 5시리즈 520d xDrive 럭셔리 F10", R.drawable.car2, "이진선", "050-2222-2222",600, "2018/02", "15km/l", "쥐색", "자동", "2000cc", "900km", "디젤","무"));
        dataList.add(new rowData("아우디 뉴 A6 3.0 TDI 콰트로 다이나믹", R.drawable.car3, "삼진선", "050-3333-3333",680, "2016/12", "11km/l", "회색", "자동", "3000cc", "2500km", "디젤", "무"));
        dataList.add(new rowData("마세라티 그란카브리오 4.7 스포츠", R.drawable.car4, "사진선", "050-4444-4444",1150, "2014/12", "14km/l", "파란색", "자동", "4700cc", "9000km", "가솔린", "무"));
        dataList.add(new rowData("링컨 뉴 MKX 3.7 AWD", R.drawable.car5, "오진선", "050-5555-5555",650, "2018/12", "15km/l","빨간색", "자동", "2700cc", "2400km", "디젤", "무"));
        dataList.add(new rowData("MINI 쿠퍼 클럽맨 D", R.drawable.car6, "오진선", "050-6666-6666",700, "2017/05", "16km/l", "갈색", "자동", "2000cc", "10000km", "디젤", "무"));
        dataList.add(new rowData("폭스바겐 더 비틀 2.0 TDI", R.drawable.car7, "오진선", "050-7777-7777",340, "2017/10", "15km/l", "흰색", "자동", "2000cc", "9000km", "디젤", "무"));

        titles = new String[dataList.size()];
        for (int i = 0; i < dataList.size(); i++){
            titles[i] = dataList.get(i).title;
        }

        CustomList adapter = new CustomList(MainActivity.this);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //data = new rowData(titles[+position],images[+position],names[+position],phones[+position],costs[+position]);
                data = dataList.get(+position);
                //arr = (ArrayList)(Arrays.asList(titles[+position],images[+position],names[+position],phones[+position],costs[+position]));
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });
    }

    public class CustomList extends ArrayAdapter<String>{
        private final Activity context;

        public CustomList(Activity context){
            super(context,R.layout.listitem, titles);
            this.context = context;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = (ImageView)rowView.findViewById(R.id.image);
            TextView title = (TextView)rowView.findViewById(R.id.title);
            TextView sellerName = (TextView)rowView.findViewById(R.id.sellerName);
            TextView phone = (TextView)rowView.findViewById(R.id.phone);
            TextView cost = (TextView)rowView.findViewById(R.id.cost);
            title.setText(dataList.get(position).title);
            imageView.setImageResource(dataList.get(position).image);
            sellerName.setText(dataList.get(position).name);
            phone.setText(dataList.get(position).phone);
            cost.setText(dataList.get(position).cost.toString()+"만원");
            return rowView;
        }
    }
}
