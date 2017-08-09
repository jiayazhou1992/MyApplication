package com.sunztech.admin.general_app.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.base.BaseActivity;
import com.sunztech.admin.general_app.widget.adapter.AdvanceDecoration;
import com.sunztech.admin.general_app.widget.adapter.CommonRecyclayerAdapter;
import com.sunztech.admin.general_app.widget.adapter.RecyclayerViewHolder;

import java.util.Arrays;

public class ListActivity extends BaseActivity {

    private String[] actions={"RecyclerView+DiffUtil+CardView",
            "Apps","陀螺","视频播放"};

    private RecyclerView recyclerView;
    private CommonRecyclayerAdapter<String> recyclayerAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_list;
    }

    @Override
    protected void initFindViewById() {
        super.initFindViewById();
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdvanceDecoration advanceDecoration=new AdvanceDecoration();
        advanceDecoration.setRight(30);
        advanceDecoration.setSize(5);
        advanceDecoration.setColor(getResources().getColor(R.color.colorPrimary));
        recyclerView.addItemDecoration(advanceDecoration);
        recyclayerAdapter=new CommonRecyclayerAdapter<String>(this,Arrays.asList(actions),android.R.layout.simple_list_item_1) {
            @Override
            public void convert(RecyclayerViewHolder holder, String item) {
                holder.setText(android.R.id.text1,item);
            }

            @Override
            public void onItemClick(View view, String item, int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(ListActivity.this,RecyclayerActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(ListActivity.this,AppsActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(ListActivity.this,TuoluoActivity.class));
                        break;
                }

            }
        };
        recyclerView.setAdapter(recyclayerAdapter);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }



}
