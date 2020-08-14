package com.onezeromm.playme.UI.MainActivity;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.onezeromm.playme.AI.DetectGreen;
import com.onezeromm.playme.Async.ImageTask;
import com.onezeromm.playme.GlobalValues.GlobalUsage;
import com.onezeromm.playme.R;
import com.onezeromm.playme.UI.CustomView.CameraView;
import com.onezeromm.playme.UI.CustomView.AutoFitTextureView;
import com.onezeromm.playme.UI.CustomView.DrawView;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    private AutoFitTextureView mTextureView;
    private RelativeLayout mainView;
    CameraView cameraView;
    DrawView drawView;
    public Button btnBC, btnBD, btnBE, btnBF, btnBG, btnBA, btnBB,
            btnTC, btnTD, btnTE, btnTF, btnTG, btnTA, btnTB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainView = findViewById(R.id.mainView);
        mTextureView = mainView.findViewById(R.id.texture);
        cameraView = new CameraView(MainActivity.this, mTextureView);

        drawView = new DrawView(MainActivity.this);
        drawView.textureView = mTextureView;
        mainView.addView(drawView);

        btnBC = findViewById(R.id.btnBC);
        btnBD = findViewById(R.id.btnBD);
        btnBE = findViewById(R.id.btnBE);
        btnBF = findViewById(R.id.btnBF);
        btnBG = findViewById(R.id.btnBG);
        btnBA = findViewById(R.id.btnBA);
        btnBB = findViewById(R.id.btnBB);
        btnTC = findViewById(R.id.btnTC);
        btnTD = findViewById(R.id.btnTD);
        btnTE = findViewById(R.id.btnTE);
        btnTF = findViewById(R.id.btnTF);
        btnTG = findViewById(R.id.btnTG);
        btnTA = findViewById(R.id.btnTA);
        btnTB = findViewById(R.id.btnTB);
    }


    @Override
    public void onWindowFocusChanged (boolean hasFocus)
    {
        int[] BCLocation = new int[2];
        int[] BDLocation = new int[2];
        int[] BELocation = new int[2];
        int[] BFLocation = new int[2];
        int[] BGLocation = new int[2];
        int[] BALocation = new int[2];
        int[] BBLocation = new int[2];
        int[] TCLocation = new int[2];
        int[] TDLocation = new int[2];
        int[] TELocation = new int[2];
        int[] TFLocation = new int[2];
        int[] TGLocation = new int[2];
        int[] TALocation = new int[2];
        int[] TBLocation = new int[2];
        btnBC.getLocationOnScreen(BCLocation);
        btnBD.getLocationOnScreen(BDLocation);
        btnBE.getLocationOnScreen(BELocation);
        btnBF.getLocationOnScreen(BFLocation);
        btnBG.getLocationOnScreen(BGLocation);
        btnBA.getLocationOnScreen(BALocation);
        btnBB.getLocationOnScreen(BBLocation);
        btnTC.getLocationOnScreen(TCLocation);
        btnTD.getLocationOnScreen(TDLocation);
        btnTE.getLocationOnScreen(TELocation);
        btnTF.getLocationOnScreen(TFLocation);
        btnTG.getLocationOnScreen(TGLocation);
        btnTA.getLocationOnScreen(TALocation);
        btnTB.getLocationOnScreen(TBLocation);

        GlobalUsage.btnBCLeftTop[0] = BCLocation[0];
        GlobalUsage.btnBCLeftTop[1] = BCLocation[1] - 90;
        GlobalUsage.btnBCRightTop[0] = BCLocation[0] + btnBC.getWidth();
        GlobalUsage.btnBCRightTop[1] = BCLocation[1] - 90;
        GlobalUsage.btnBCLeftBottom[0] = BCLocation[0];
        GlobalUsage.btnBCLeftBottom[1] =  BCLocation[1] + btnBC.getHeight() - 90;
        GlobalUsage.btnBCRightBottom[0] = BCLocation[0] + btnBC.getWidth();
        GlobalUsage.btnBCRightBottom[1] = BCLocation[1] + btnBC.getHeight() - 90;

        GlobalUsage.btnBDLeftTop[0] = BDLocation[0];
        GlobalUsage.btnBDLeftTop[1] = BDLocation[1] - 90;
        GlobalUsage.btnBDRightTop[0] = BDLocation[0] + btnBD.getWidth();
        GlobalUsage.btnBDRightTop[1] = BDLocation[1] - 90;
        GlobalUsage.btnBDLeftBottom[0] = BDLocation[0];
        GlobalUsage.btnBDLeftBottom[1] =  BDLocation[1] + btnBD.getHeight() - 90;
        GlobalUsage.btnBDRightBottom[0] = BDLocation[0] + btnBD.getWidth();
        GlobalUsage.btnBDRightBottom[1] = BDLocation[1] + btnBD.getHeight() - 90;

        GlobalUsage.btnBELeftTop[0] = BELocation[0];
        GlobalUsage.btnBELeftTop[1] = BELocation[1] - 90;
        GlobalUsage.btnBERightTop[0] = BELocation[0] + btnBE.getWidth();
        GlobalUsage.btnBERightTop[1] = BELocation[1] - 90;
        GlobalUsage.btnBELeftBottom[0] = BELocation[0];
        GlobalUsage.btnBELeftBottom[1] =  BELocation[1] + btnBE.getHeight() - 90;
        GlobalUsage.btnBERightBottom[0] = BELocation[0] + btnBE.getWidth();
        GlobalUsage.btnBERightBottom[1] = BELocation[1] + btnBE.getHeight() - 90;

        GlobalUsage.btnBFLeftTop[0] = BFLocation[0];
        GlobalUsage.btnBFLeftTop[1] = BFLocation[1] - 90;
        GlobalUsage.btnBFRightTop[0] = BFLocation[0] + btnBF.getWidth();
        GlobalUsage.btnBFRightTop[1] = BFLocation[1] - 90;
        GlobalUsage.btnBFLeftBottom[0] = BFLocation[0];
        GlobalUsage.btnBFLeftBottom[1] =  BFLocation[1] + btnBF.getHeight() - 90;
        GlobalUsage.btnBFRightBottom[0] = BFLocation[0] + btnBF.getWidth();
        GlobalUsage.btnBFRightBottom[1] = BFLocation[1] + btnBF.getHeight() - 90;

        GlobalUsage.btnBGLeftTop[0] = BGLocation[0];
        GlobalUsage.btnBGLeftTop[1] = BGLocation[1] - 90;
        GlobalUsage.btnBGRightTop[0] = BGLocation[0] + btnBG.getWidth();
        GlobalUsage.btnBGRightTop[1] = BGLocation[1] - 90;
        GlobalUsage.btnBGLeftBottom[0] = BGLocation[0];
        GlobalUsage.btnBGLeftBottom[1] =  BGLocation[1] + btnBG.getHeight() - 90;
        GlobalUsage.btnBGRightBottom[0] = BGLocation[0] + btnBG.getWidth();
        GlobalUsage.btnBGRightBottom[1] = BGLocation[1] + btnBG.getHeight() - 90;

        GlobalUsage.btnBALeftTop[0] = BALocation[0];
        GlobalUsage.btnBALeftTop[1] = BALocation[1] - 90;
        GlobalUsage.btnBARightTop[0] = BALocation[0] + btnBA.getWidth();
        GlobalUsage.btnBARightTop[1] = BALocation[1] - 90;
        GlobalUsage.btnBALeftBottom[0] = BALocation[0];
        GlobalUsage.btnBALeftBottom[1] =  BALocation[1] + btnBA.getHeight() - 90;
        GlobalUsage.btnBARightBottom[0] = BALocation[0] + btnBA.getWidth();
        GlobalUsage.btnBARightBottom[1] = BALocation[1] + btnBA.getHeight() - 90;

        GlobalUsage.btnBBLeftTop[0] = BBLocation[0];
        GlobalUsage.btnBBLeftTop[1] = BBLocation[1] - 90;
        GlobalUsage.btnBBRightTop[0] = BBLocation[0] + btnBB.getWidth();
        GlobalUsage.btnBBRightTop[1] = BBLocation[1] - 90;
        GlobalUsage.btnBBLeftBottom[0] = BBLocation[0];
        GlobalUsage.btnBBLeftBottom[1] =  BBLocation[1] + btnBB.getHeight() - 90;
        GlobalUsage.btnBBRightBottom[0] = BBLocation[0] + btnBB.getWidth();
        GlobalUsage.btnBBRightBottom[1] = BBLocation[1] + btnBB.getHeight() - 90;

        GlobalUsage.btnTCLeftTop[0] = TCLocation[0];
        GlobalUsage.btnTCLeftTop[1] = TCLocation[1] - 90;
        GlobalUsage.btnTCRightTop[0] = TCLocation[0] + btnTC.getWidth();
        GlobalUsage.btnTCRightTop[1] = TCLocation[1] - 90;
        GlobalUsage.btnTCLeftBottom[0] = TCLocation[0];
        GlobalUsage.btnTCLeftBottom[1] =  TCLocation[1] + btnTC.getHeight() - 90;
        GlobalUsage.btnTCRightBottom[0] = TCLocation[0] + btnTC.getWidth();
        GlobalUsage.btnTCRightBottom[1] = TCLocation[1] + btnTC.getHeight() - 90;

        GlobalUsage.btnTDLeftTop[0] = TDLocation[0];
        GlobalUsage.btnTDLeftTop[1] = TDLocation[1] - 90;
        GlobalUsage.btnTDRightTop[0] = TDLocation[0] + btnTD.getWidth();
        GlobalUsage.btnTDRightTop[1] = TDLocation[1] - 90;
        GlobalUsage.btnTDLeftBottom[0] = TDLocation[0];
        GlobalUsage.btnTDLeftBottom[1] =  TDLocation[1] + btnTD.getHeight() - 90;
        GlobalUsage.btnTDRightBottom[0] = TDLocation[0] + btnTD.getWidth();
        GlobalUsage.btnTDRightBottom[1] = TDLocation[1] + btnTD.getHeight() - 90;

        GlobalUsage.btnTELeftTop[0] = TELocation[0];
        GlobalUsage.btnTELeftTop[1] = TELocation[1] - 90;
        GlobalUsage.btnTERightTop[0] = TELocation[0] + btnTE.getWidth();
        GlobalUsage.btnTERightTop[1] = TELocation[1] - 90;
        GlobalUsage.btnTELeftBottom[0] = TELocation[0];
        GlobalUsage.btnTELeftBottom[1] =  TELocation[1] + btnTE.getHeight() - 90;
        GlobalUsage.btnTERightBottom[0] = TELocation[0] + btnTE.getWidth();
        GlobalUsage.btnTERightBottom[1] = TELocation[1] + btnTE.getHeight() - 90;

        GlobalUsage.btnTFLeftTop[0] = TFLocation[0];
        GlobalUsage.btnTFLeftTop[1] = TFLocation[1] - 90;
        GlobalUsage.btnTFRightTop[0] = TFLocation[0] + btnTF.getWidth();
        GlobalUsage.btnTFRightTop[1] = TFLocation[1] - 90;
        GlobalUsage.btnTFLeftBottom[0] = TFLocation[0];
        GlobalUsage.btnTFLeftBottom[1] =  TFLocation[1] + btnTF.getHeight() - 90;
        GlobalUsage.btnTFRightBottom[0] = TFLocation[0] + btnTF.getWidth();
        GlobalUsage.btnTFRightBottom[1] = TFLocation[1] + btnTF.getHeight() - 90;

        GlobalUsage.btnTGLeftTop[0] = TGLocation[0];
        GlobalUsage.btnTGLeftTop[1] = TGLocation[1] - 90;
        GlobalUsage.btnTGRightTop[0] = TGLocation[0] + btnTG.getWidth();
        GlobalUsage.btnTGRightTop[1] = TGLocation[1] - 90;
        GlobalUsage.btnTGLeftBottom[0] = TGLocation[0];
        GlobalUsage.btnTGLeftBottom[1] =  TGLocation[1] + btnTG.getHeight() - 90;
        GlobalUsage.btnTGRightBottom[0] = TGLocation[0] + btnTG.getWidth();
        GlobalUsage.btnTGRightBottom[1] = TGLocation[1] + btnTG.getHeight() - 90;

        GlobalUsage.btnTALeftTop[0] = TALocation[0];
        GlobalUsage.btnTALeftTop[1] = TALocation[1] - 90;
        GlobalUsage.btnTARightTop[0] = TALocation[0] + btnTA.getWidth();
        GlobalUsage.btnTARightTop[1] = TALocation[1] - 90;
        GlobalUsage.btnTALeftBottom[0] = TALocation[0];
        GlobalUsage.btnTALeftBottom[1] =  TALocation[1] + btnTA.getHeight() - 90;
        GlobalUsage.btnTARightBottom[0] = TALocation[0] + btnTA.getWidth();
        GlobalUsage.btnTARightBottom[1] = TALocation[1] + btnTA.getHeight() - 90;

        GlobalUsage.btnTBLeftTop[0] = TBLocation[0];
        GlobalUsage.btnTBLeftTop[1] = TBLocation[1] - 90;
        GlobalUsage.btnTBRightTop[0] = TBLocation[0] + btnTB.getWidth();
        GlobalUsage.btnTBRightTop[1] = TBLocation[1] - 90;
        GlobalUsage.btnTBLeftBottom[0] = TBLocation[0];
        GlobalUsage.btnTBLeftBottom[1] =  TBLocation[1] + btnTB.getHeight() - 90;
        GlobalUsage.btnTBRightBottom[0] = TBLocation[0] + btnTB.getWidth();
        GlobalUsage.btnTBRightBottom[1] = TBLocation[1] + btnTB.getHeight() - 90;
    }

    /**
     * {@link TextureView.SurfaceTextureListener} handles several lifecycle events on a
     * {@link TextureView}.
     */
    boolean processing = false;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener
            = new TextureView.SurfaceTextureListener() {

        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture,
                                              int width, int height) {
            cameraView.openCamera(width, height);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture,
                                                int width, int height) {
            cameraView.configureTransform(width, height);
        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (processing) {
                return;
            }
            processing = true;

            Bitmap photo = mTextureView.getBitmap(mTextureView.getWidth()/ GlobalUsage.resizeSize, mTextureView.getHeight() / GlobalUsage.resizeSize);
            new ImageTask(photo, new ImageTask.ImageResponse() {
                @Override
                public void processFinished() {
                    processing = false;
                }
            }, drawView).execute();
        }

    };

    @Override
    public void onResume() {
        super.onResume();
        cameraView.startBackgroundThread();
        if (mTextureView.isAvailable()) {
            cameraView.openCamera(mTextureView.getWidth(), mTextureView.getHeight());
        } else {
            mTextureView.setSurfaceTextureListener(mSurfaceTextureListener);
        }
    }

    @Override
    public void onPause() {
        cameraView.closeCamera();
        cameraView.stopBackgroundThread();
        super.onPause();
    }
}
