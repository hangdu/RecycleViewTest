package com.example.hang.recycleviewtest;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ContactButton extends AppCompatTextView {
    public ContactButton(Context context) {
        super(context);
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        int padd = (int) context.getResources().getDimension(R.dimen.developer_links_small_padding);
        setPadding(padd, padd, padd, padd);
        setTextSize(16);
    }

    public void bold() {
        setTypeface(null, Typeface.BOLD);
    }
}
