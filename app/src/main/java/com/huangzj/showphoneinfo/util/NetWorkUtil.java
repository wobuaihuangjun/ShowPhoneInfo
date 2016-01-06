package com.huangzj.showphoneinfo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

/**
 * Created by huangzj on 2016/1/6.
 */
public class NetWorkUtil {

    // 当前网络是否连接
    public boolean isNetConnecting(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            // info.setConnected(false);
            return false;
        } else {
            // info.setConnected(true);
            return true;
        }
    }

    // 获取信号强度
    public void getPhoneState(Context context) {
        // 1. 创建telephonyManager 对象。
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        // 2. 创建PhoneStateListener 对象
        PhoneStateListener MyPhoneListener = new PhoneStateListener() {
            @Override
            public void onCellLocationChanged(CellLocation location) {
                if (location instanceof GsmCellLocation) {// gsm网络
                    int CID = ((GsmCellLocation) location).getCid();
                } else if (location instanceof CdmaCellLocation) {// 其他CDMA等网络
                    int ID = ((CdmaCellLocation) location).getBaseStationId();
                }
            }

            @Override
            public void onServiceStateChanged(ServiceState serviceState) {
                super.onServiceStateChanged(serviceState);
            }

            @Override
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                int asu = signalStrength.getGsmSignalStrength();
                int dbm = -113 + 2 * asu; // 信号强度
                super.onSignalStrengthsChanged(signalStrength);
            }
        };
        // 3. 监听信号改变
        telephonyManager.listen(MyPhoneListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);

    /*
     * 可能需要的权限 <uses-permission
     * android:name="android.permission.WAKE_LOCK"></uses-permission>
     * <uses-permission
     * android:name="android.permission.ACCESS_COARSE_LOCATION"/>
     * <uses-permission
     * android:name="android.permission.ACCESS_FINE_LOCATION"/>
     * <uses-permission android:name="android.permission.READ_PHONE_STATE"
     * /> <uses-permission
     * android:name="android.permission.ACCESS_NETWORK_STATE" />
     */
    }

}
