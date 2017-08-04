package com.linxiao.highlightguide;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.linxiao.library.HighlightGuideView;

public class MainActivity extends AppCompatActivity {
    
    private TextView tvHello;
    private Button btnShowSingle;
    private Button btnShowQueue;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvHello = (TextView) findViewById(R.id.tv_hello);
        btnShowSingle = (Button) findViewById(R.id.btn_show_single);
        btnShowQueue = (Button) findViewById(R.id.btn_show_queue);
        btnShowSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingleGuide();
            }
        });
        
        btnShowQueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGuideQueue();
            }
        });
        
    }
    
    private void showSingleGuide() {
        TextView tvDesc = new TextView(this);
        tvDesc.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        tvDesc.setText("guide 1");
        tvDesc.setTextSize(16);
        HighlightGuideView.newInstance(this)
        .setHighlightStyle(HighlightGuideView.STYLE_CIRCLE)
        .addTargetView(tvHello)
        .addGuideImage(tvHello, R.drawable.ic_arrow,
                dp2px(100),
                dp2px(50),
                dp2px(50), 0)
        .addGuideView(tvHello,
                tvDesc,
                dp2px(50),
                dp2px(60)
        )
        .show();
    }
    
    public void showGuideQueue() {
        HighlightGuideView.GuideQueue queue = HighlightGuideView.newGuideQueue();
        TextView tvDesc1 = new TextView(this);
        tvDesc1.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        tvDesc1.setText("guide 1");
        tvDesc1.setTextSize(16);
        
        queue.add(
            HighlightGuideView.newInstance(this)
            .setHighlightStyle(HighlightGuideView.STYLE_CIRCLE)
            .addTargetView(tvHello)
            .addGuideImage(tvHello, R.drawable.ic_arrow,
                    dp2px(100),
                    dp2px(50),
                    dp2px(50), 0)
            .addGuideView(tvHello, tvDesc1, dp2px(50), dp2px(60))
        );
    
        TextView tvDesc2 = new TextView(this);
        tvDesc2.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        tvDesc2.setText("guide 2");
        tvDesc2.setTextSize(16);
    
        queue.add(
            HighlightGuideView.newInstance(this)
            .setHighlightStyle(HighlightGuideView.STYLE_RECT)
            .addTargetView(btnShowSingle)
            .addGuideView(btnShowSingle, tvDesc2, dp2px(50), dp2px(60))
        );
    
        TextView tvDesc3 = new TextView(this);
        tvDesc3.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        tvDesc3.setText("guide 3");
        tvDesc3.setTextSize(16);
        queue.add(
            HighlightGuideView.newInstance(this)
            .setHighlightStyle(HighlightGuideView.STYLE_OVAL)
            .addTargetView(btnShowQueue)
            .addGuideView(btnShowQueue, tvDesc3, dp2px(50), dp2px(60))
        );
        
        queue.show();
    }
    
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dp2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
