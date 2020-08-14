package com.onezeromm.playme.Async;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.onezeromm.playme.AI.DetectGreen;
import com.onezeromm.playme.UI.CustomView.DrawView;
import com.onezeromm.playme.UI.MainActivity.MainActivity;

public class ImageTask extends AsyncTask<Void, Void, Exception> {

    DrawView drawView;
    DetectGreen detectGreen = new DetectGreen();

    public interface ImageResponse {
        void processFinished();
    }

    private Bitmap photo;
    private ImageResponse imageResponse;
    public ImageTask(Bitmap photo, ImageResponse imageResponse, DrawView drawView) {
        this.drawView = drawView;
        this.photo = photo;
        this.imageResponse = imageResponse;
    }

    @Override
    protected Exception doInBackground(Void... params) {
        drawView.detectedGreenSectors = detectGreen.startDetection(photo);
        imageResponse.processFinished();
        return null;
    }

    @Override
    protected void onPostExecute(Exception result) {
        drawView.invalidate();
    }
}