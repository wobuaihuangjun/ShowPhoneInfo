package com.huangzj.showphoneinfo.util;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by huangzj on 2016/1/6.
 */
public class SDCardUtil {

    // 获取Android手机中SD卡存储信息 获取剩余空间
    public void getSDCardInfo() {
        // 在manifest.xml文件中要添加
    /*
     * <uses-permission
     * android:name="android.permission.WRITE_EXTERNAL_STORAGE">
     * </uses-permission>
     */
        // 需要判断手机上面SD卡是否插好，如果有SD卡的情况下，我们才可以访问得到并获取到它的相关信息，当然以下这个语句需要用if做判断
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            // 取得sdcard文件路径
            File path = Environment.getExternalStorageDirectory();
            StatFs statfs = new StatFs(path.getPath());
            // 获取block的SIZE
            long blocSize = statfs.getBlockSize();
            // 获取BLOCK数量
            long totalBlocks = statfs.getBlockCount();
            // 空闲的Block的数量
            long availaBlock = statfs.getAvailableBlocks();
            // 计算总空间大小和空闲的空间大小
            // 存储空间大小跟空闲的存储空间大小就被计算出来了。
            long availableSize = blocSize * availaBlock;
            // (availableBlocks * blockSize)/1024 KIB 单位
            // (availableBlocks * blockSize)/1024 /1024 MIB单位
            long allSize = blocSize * totalBlocks;
        }

    }

}
