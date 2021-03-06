package com.qizu.shoppingcarcar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by jiuhao on 2017/11/16.
 * data 2017/11/16
 * time 下午 06:35
 */

public class CustomView extends LinearLayout{
    private EditText editText;
    private Button revserse;
    private Button add;
    private int mCount = 1 ;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        View view =   LayoutInflater.from(context).inflate(R.layout.customview,null,false);
        revserse = (Button) view.findViewById(R.id.revserse);
        add = (Button) view.findViewById(R.id.add);
        editText = (EditText) view.findViewById(R.id.content);
        revserse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //减号
                try {
                    String content = editText.getText().toString().trim();
                    int count = Integer.valueOf(content)-1;
                    mCount = count;
                    if(count>=1){
                        editText.setText(count+"");
                    }
                    if(listener != null){
                        listener.click(count);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //加号
                try {
                    String content = editText.getText().toString().trim();
                    int count = Integer.valueOf(content)+1;
                    mCount = count;
                    editText.setText(count+"");
                    if(listener != null){
                        listener.click(count);
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();


                }
            }
        });
        addView(view);
    }
    public int getCurrentCount(){
        return mCount;
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public ClickListener listener;
    public void setListener(ClickListener listener){
        this.listener = listener;
    }
    public interface ClickListener {
        public void click(int count);
    }
}
