package com.sunztech.admin.general_app.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.base.BaseActivity;
import com.sunztech.admin.general_app.utils.utils1.ArrayUtils;
import com.sunztech.admin.general_app.widget.adapter.AdvanceDecoration;
import com.sunztech.admin.general_app.widget.adapter.CommonRecyclayerAdapter;
import com.sunztech.admin.general_app.widget.adapter.DiffUtilCallback;
import com.sunztech.admin.general_app.widget.adapter.RecyclayerViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclayerActivity extends BaseActivity {

    private String[] actions={"item1","item2","item3","item4","item5","item6","item7","item8"};

    private RecyclerView recyclerView;
    private CommonRecyclayerAdapter<String> recyclayerAdapter;
    private List<String> list=new ArrayList<>();

    @Override
    protected int getContentView() {
        return R.layout.activity_recyclayer;
    }

    @Override
    protected void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdvanceDecoration advanceDecoration=new AdvanceDecoration();
        advanceDecoration.setRight(30);
        advanceDecoration.setBottom(30);
        recyclerView.addItemDecoration(advanceDecoration);
        ArrayUtils.array2List(actions,list);
        recyclayerAdapter=new CommonRecyclayerAdapter<String>(this,list ,R.layout.item_recyclayer1) {
            @Override
            public void convert(RecyclayerViewHolder holder, String item) {
                holder.setText(android.R.id.text1,item);
            }

            @Override
            public void onItemClick(View view, String item, int position) {
                List<String> oldList=new ArrayList<>();
                oldList.addAll(list);
                list.remove(position);
                DiffUtil.DiffResult diffResult=DiffUtil.calculateDiff(new DiffUtilCallback(oldList,list));
                diffResult.dispatchUpdatesTo(recyclayerAdapter);

            }
        };
        recyclerView.setAdapter(recyclayerAdapter);


    }

    @Override
    protected void initData() {

    }
}
