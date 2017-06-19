package com.sunztech.admin.general_app.utils.utils2;

import android.content.Context;
import android.widget.Toast;

import com.sunztech.admin.general_app.utils.utils1.SDCardUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by jiayazhou on 2016/9/12.
 */
public class Excel {

    private String file_p="HJJCXT/excel";
    private File file;
    //private WritableWorkbook writableWorkbook;

    public Excel(String fileName, Context context){
        if (!SDCardUtils.isSDCardEnable()){
            Toast.makeText(context,"SD卡不可用",Toast.LENGTH_SHORT).show();
            return;
        }
        if (SDCardUtils.getSDCardAllSize()/1024/1024<=1){
            Toast.makeText(context,"SD卡不可用",Toast.LENGTH_SHORT).show();
            return;
        }
        File p=new File(SDCardUtils.getSDCardPath()+file_p);
        if (!p.exists()){
            p.mkdirs();
        }
        file=new File(SDCardUtils.getSDCardPath()+file_p+File.separator+fileName);
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            //writableWorkbook= Workbook.createWorkbook(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public WritableSheet createSheet(String name,int i){
        WritableSheet sheet=writableWorkbook.createSheet(name,i);
        return sheet;
    }

    public void createLabel(List<String> labels,WritableSheet sheet,int r){
        for(int i=0;i<labels.size();i++){
            Label label=new Label(i,r,labels.get(i));
            try {
                sheet.addCell(label);
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public void end(){
        try {
            writableWorkbook.write();
            writableWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }

    }*/
}
