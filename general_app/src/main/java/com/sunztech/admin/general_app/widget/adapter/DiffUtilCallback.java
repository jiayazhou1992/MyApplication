package com.sunztech.admin.general_app.widget.adapter;

import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by jiayazhou on 2017/6/15 0015.
 */

public class DiffUtilCallback extends DiffUtil.Callback {

    private List oldList,newList;

    public DiffUtilCallback(List oldList,List newList){
        this.oldList=oldList;
        this.newList=newList;
    }

    @Override
    public int getOldListSize() {
        return oldList!=null?oldList.size():0;
    }

    @Override
    public int getNewListSize() {
        return newList!=null?newList.size():0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
}
