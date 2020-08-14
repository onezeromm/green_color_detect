package com.onezeromm.playme.GlobalValues;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

public class GlobalUsage {

    public static int resizeSize = 10;
    public static int[] btnBCLeftTop = new int[2], btnBCRightTop = new int[2], btnBCLeftBottom = new int[2], btnBCRightBottom = new int[2];
    public static int[] btnBDLeftTop = new int[2], btnBDRightTop = new int[2], btnBDLeftBottom = new int[2], btnBDRightBottom = new int[2];
    public static int[] btnBELeftTop = new int[2], btnBERightTop = new int[2], btnBELeftBottom = new int[2], btnBERightBottom = new int[2];
    public static int[] btnBFLeftTop = new int[2], btnBFRightTop = new int[2], btnBFLeftBottom = new int[2], btnBFRightBottom = new int[2];
    public static int[] btnBGLeftTop = new int[2], btnBGRightTop = new int[2], btnBGLeftBottom = new int[2], btnBGRightBottom = new int[2];
    public static int[] btnBALeftTop = new int[2], btnBARightTop = new int[2], btnBALeftBottom = new int[2], btnBARightBottom = new int[2];
    public static int[] btnBBLeftTop = new int[2], btnBBRightTop = new int[2], btnBBLeftBottom = new int[2], btnBBRightBottom = new int[2];
    public static int[] btnTCLeftTop = new int[2], btnTCRightTop = new int[2], btnTCLeftBottom = new int[2], btnTCRightBottom = new int[2];
    public static int[] btnTDLeftTop = new int[2], btnTDRightTop = new int[2], btnTDLeftBottom = new int[2], btnTDRightBottom = new int[2];
    public static int[] btnTELeftTop = new int[2], btnTERightTop = new int[2], btnTELeftBottom = new int[2], btnTERightBottom = new int[2];
    public static int[] btnTFLeftTop = new int[2], btnTFRightTop = new int[2], btnTFLeftBottom = new int[2], btnTFRightBottom = new int[2];
    public static int[] btnTGLeftTop = new int[2], btnTGRightTop = new int[2], btnTGLeftBottom = new int[2], btnTGRightBottom = new int[2];
    public static int[] btnTALeftTop = new int[2], btnTARightTop = new int[2], btnTALeftBottom = new int[2], btnTARightBottom = new int[2];
    public static int[] btnTBLeftTop = new int[2], btnTBRightTop = new int[2], btnTBLeftBottom = new int[2], btnTBRightBottom = new int[2];

    public boolean hasPermissionsGranted(String[] permissions, Context context) {
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(context, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> location = new ArrayList<>();
}
