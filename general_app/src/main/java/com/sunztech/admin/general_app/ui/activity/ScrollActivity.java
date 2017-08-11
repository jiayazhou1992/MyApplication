package com.sunztech.admin.general_app.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.utils.utils1.ArrayUtils;
import com.sunztech.admin.general_app.widget.adapter.CommonAdapter;
import com.sunztech.admin.general_app.widget.adapter.ViewHolder;
import com.sunztech.admin.general_app.widget.view.HorizontalListView;

public class ScrollActivity extends AppCompatActivity {


    private HorizontalListView horizontalListView;

    private String[] strings={"1","2","3","4","5","6","7","8","9","10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        horizontalListView= (HorizontalListView) findViewById(R.id.hlistview);
        CommonAdapter adapter=new CommonAdapter<String>(this, ArrayUtils.array2List(strings),R.layout.item_recyclayer1) {
            @Override
            public void convert(ViewHolder helper, String item) {

            }
        };
        horizontalListView.setAdapter(adapter);
    }
}
