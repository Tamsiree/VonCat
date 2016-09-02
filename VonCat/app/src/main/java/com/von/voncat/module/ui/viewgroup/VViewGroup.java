package com.von.voncat.module.ui.viewgroup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class VViewGroup extends ViewGroup {

    public VViewGroup(Context context) {  
        super(context);  
        // TODO Auto-generated constructor stub  
        addView(new VonViewGroup(context));  
    }  
  
    @Override  
    protected void onLayout(boolean changed, int l, int t, int r, int b) {  
        // TODO Auto-generated method stub  
        final int count = getChildCount();  
        for (int i = 0; i < count; i++) {  
            final View child = getChildAt(i);  
            child.measure(r - l, b - t);  
            child.layout(0, 0, 320, 480);  
        }  
    }  

}
