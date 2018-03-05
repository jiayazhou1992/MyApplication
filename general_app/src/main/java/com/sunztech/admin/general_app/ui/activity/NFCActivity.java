package com.sunztech.admin.general_app.ui.activity;

import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.ui.view.MosaicView;
import com.sunztech.admin.general_app.utils.utils1.SDCardUtils;

public class NFCActivity extends AppCompatActivity {

    private NfcAdapter nfcAdapter;
    private MosaicView mosaicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        mosaicView= (MosaicView) findViewById(R.id.iv_content);
        mosaicView.setSrcPath(SDCardUtils.getSDCardPath()+"yasuo.jpg");
        mosaicView.setMode(MosaicView.Mode.GRID);
    }

    private void initNFC(){
        Tag tag;
    }
}
