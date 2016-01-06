package com.huangzj.showphoneinfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.huangzj.showphoneinfo.util.CpuInfoUtil;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCupInfo();
    }

    private void setCupInfo() {
        TextView cupText = (TextView) findViewById(R.id.cpu_info);
        cupText.setText(CpuInfoUtil.getCpuInfo());
    }

}
