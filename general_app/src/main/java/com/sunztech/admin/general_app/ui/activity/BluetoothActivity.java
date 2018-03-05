package com.sunztech.admin.general_app.ui.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.widget.adapter.AdvanceDecoration;
import com.sunztech.admin.general_app.widget.adapter.CommonRecyclayerAdapter;
import com.sunztech.admin.general_app.widget.adapter.RecyclayerViewHolder;

import java.util.ArrayList;

public class BluetoothActivity extends AppCompatActivity {

    private BluetoothAdapter bluetoothAdapter;

    private Button button_search,button_stop;
    private RecyclerView recyclerView;

    private ArrayList<String> strings=new ArrayList<>();
    private CommonRecyclayerAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        button_search= (Button) findViewById(R.id.search);
        button_stop= (Button) findViewById(R.id.stop);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdvanceDecoration advanceDecoration=new AdvanceDecoration();
        advanceDecoration.setRight(20);
        advanceDecoration.setSize(3);
        advanceDecoration.setColor(getResources().getColor(R.color.colorPrimary));
        recyclerView.addItemDecoration(advanceDecoration);
        adapter=new CommonRecyclayerAdapter<String>(this,strings,android.R.layout.simple_list_item_1) {
            @Override
            public void convert(RecyclayerViewHolder holder, String item) {
                holder.setText(android.R.id.text1,item);
            }

            @Override
            public void onItemClick(View view, String item, int position) {

            }
        };
        recyclerView.setAdapter(adapter);
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
            }
        });
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(broadcastReceiver,intentFilter);

        initBluetooth();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    private void initBluetooth(){
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
            Toast.makeText(this,"打开蓝牙",Toast.LENGTH_SHORT).show();
        }
    }

    private void search(){
        if (!bluetoothAdapter.isDiscovering())
            bluetoothAdapter.startDiscovery();

    }

    private void stop(){
        if (bluetoothAdapter.isDiscovering()){
            bluetoothAdapter.cancelDiscovery();
        }
    }

    private BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            //找到设备
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    Log.e("BroadcastReceiver", "find device:" + device.getName() + device.getAddress());
                    strings.add(device.getName());
                    adapter.notifyDataSetChanged();
                }
            }
            //搜索完成
            else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                Log.e("BroadcastReceiver", "find over");

            }

        }
    };
}
