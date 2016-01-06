package com.huangzj.showphoneinfo.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by huangzj on 2016/1/6.
 */
public class AndroidUtil {
    // 获取手机屏幕高度
    private String getWeithAndHeight(Context context) {
        // 这种方式在service中无法使用，
        DisplayMetrics dm = new DisplayMetrics();
        int width = dm.widthPixels; // 宽
        int height = dm.heightPixels; // 高
        float density = dm.density; // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi; // 屏幕密度DPI（120 / 160 / 240）
        // 在service中也能得到高和宽
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        width = mWindowManager.getDefaultDisplay().getWidth();
        height = mWindowManager.getDefaultDisplay().getHeight();
        return "(像素)宽:" + width + "\n" + "(像素)高:" + height + "\n"
                + "屏幕密度（0.75 / 1.0 / 1.5）:" + density + "\n"
                + "屏幕密度DPI（120 / 160 / 240）:" + densityDpi + "\n";
    /*
     * 下面的代码即可获取屏幕的尺寸。 在一个Activity的onCreate方法中，写入如下代码：
      DisplayMetrics metric   = new DisplayMetrics();
     * getWindowManager().getDefaultDisplay().getMetrics(metric);
     * int width  = metric.widthPixels; // 屏幕宽度（像素）
     * int height = metric.heightPixels;   // 屏幕高度（像素）
     * float density = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
     * int densityDpi = metric.densityDpi; // 屏幕密度DPI（120 / 160 / 240）
     *
     * 但是，需要注意的是，在一个低密度的小屏手机上，仅靠上面的代码是不能获取正确的尺寸的。
     * 比如说，一部240x320像素的低密度手机，如果运行上述代码，获取到的屏幕尺寸是320x427。
     * 因此，研究之后发现，若没有设定多分辨率支持的话
     * ，Android系统会将240x320的低密度（120）尺寸转换为中等密度（160）对应的尺寸，
     * 这样的话就大大影响了程序的编码。所以，需要在工程的AndroidManifest
     * .xml文件中，加入supports-screens节点，具体的内容如下： <supports-screens
     * android:smallScreens="true" android:normalScreens="true"
     * android:largeScreens="true" android:resizeable="true"
     * android:anyDensity="true" />
     * 这样的话，当前的Android程序就支持了多种分辨率，那么就可以得到正确的物理尺寸了。
     */
    }

}
