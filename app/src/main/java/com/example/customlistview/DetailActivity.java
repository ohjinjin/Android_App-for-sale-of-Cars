package com.example.customlistview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    //ArrayList<Object> arr;
    rowData data;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        data = (rowData)bundle.getParcelable("data");

        //Log.d("jinjin","check3" + data.phone);

        ImageView imageView = (ImageView)findViewById(R.id.image);
        TextView title = (TextView)findViewById(R.id.title);
        TextView cost = (TextView)findViewById(R.id.cost);
        TextView year = (TextView)findViewById(R.id.year);
        TextView fuelEconomy = (TextView)findViewById(R.id.fuelEconomy);
        TextView color = (TextView)findViewById(R.id.color);
        TextView transmission = (TextView)findViewById(R.id.transmission);
        TextView displacement = (TextView)findViewById(R.id.displacement);
        TextView mileage = (TextView)findViewById(R.id.mileage);
        TextView fuel = (TextView)findViewById(R.id.fuel);
        TextView hasAccident = (TextView)findViewById(R.id.hasAccident);

        title.setText(data.title);
        cost.setText(data.cost.toString()+"만원");
        year.setText(data.year);
        fuelEconomy.setText(data.fuelEconomy);
        color.setText(data.color);
        transmission.setText(data.transmission);
        displacement.setText(data.displacement);
        mileage.setText(data.mileage);
        fuel.setText(data.fuel);
        hasAccident.setText(data.hasAccident);
        imageView.setImageResource(data.image);


    }

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.call: // 암시적 인텐트 p346
                Log.d("jinjin","check1");
                Bundle bundle = getIntent().getExtras();

                Log.d("jinjin","check2");
                data = (rowData)bundle.getParcelable("data");

                intent = new Intent(Intent.ACTION_DIAL);
                //Log.d("jinjin","check3" + data.phone);
                intent.setData(Uri.parse("tel:(+82)"+data.phone));

                //arr = (ArrayList<Object>)intent.getSerializableExtra("arr");
                break;
        }
        if (intent != null){
            startActivity(intent);
        }
    }
}
