package com.onezeromm.playme.UI.CustomView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.onezeromm.playme.GlobalValues.GlobalUsage;
import com.onezeromm.playme.UI.MainActivity.MainActivity;

import java.util.ArrayList;

public class DrawView extends View {
    public ArrayList<ArrayList<int[]>> detectedGreenSectors = new ArrayList<>();
    ArrayList<int[]> locations = new ArrayList<>();
    Paint paint = new Paint();
    public AutoFitTextureView textureView;
    Context context;
    int biggestX = 0, smallestX = 0, biggestY = 0, smallestY = 0;
    boolean processing = false;

    private void init() {
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(10);
    }

    public DrawView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        try {
            processing = false;
            for(ArrayList<int[]> location : detectedGreenSectors)
            {
                int startX = -1, startY = -1, endX = -1, endY = -1;
                for(int[] xys : location)
                {
                    if(startX == -1)
                    {
                        startX = xys[0];
                        startY = xys[1];
                        biggestX = startX;
                        smallestX = startX;
                        biggestY = startY;
                        smallestY = startY;
                    }
                    else
                    {
                        endX = xys[0];
                        endY = xys[1];
                        markBiggestAndSmallest(endX, endY);
                        canvas.drawLine(startX,startY, endX, endY, paint);
                        startX = endX;
                        startY = endY;
                    }
                }
                checkToPerformClick();
//                if(!processing)
//                {
//                    processing = true;
//                    checkToPerformClick();
//                }
            }
        }
        catch (Exception e)
        {

        }

//        canvas.drawLine(1000, 1000, 20, 20, paint);
//        canvas.drawLine(20, 1000, 1000, 20, paint);
    }

    private void markBiggestAndSmallest(int eX, int eY)
    {
        if(biggestX < eX)
        {
            biggestX = eX;
        }
        if(biggestY < eY)
        {
            biggestY = eY;
        }
        if(smallestX > eX)
        {
            smallestX = eX;
        }
        if(smallestY > eY)
        {
            smallestY = eY;
        }
//        if((sX >= GlobalUsage.btnBCTopLineStartX && sX <= GlobalUsage.btnBCTopLineEndX && eY >= GlobalUsage.btnBCTopLineEndY && eY <= GlobalUsage.btnBCBottomLineEndY) ||
//                (sX >= GlobalUsage.btnBCTopLineStartX && sX <= GlobalUsage.btnBCTopLineEndX && eY >= GlobalUsage.btnBCTopLineEndY && eY <= GlobalUsage.btnBCBottomLineEndY) ||)
//        ((MainActivity) context).btnBC.performClick();
    }

    private void checkToPerformClick()
    {
        if(biggestX <= GlobalUsage.btnBCRightTop[0] && biggestY <= GlobalUsage.btnBCRightBottom[1]
        && smallestX >= GlobalUsage.btnBCLeftTop[0] && smallestY >= GlobalUsage.btnBCLeftTop[1])
        {
            ((MainActivity) context).btnBC.setPressed(true);
            ((MainActivity) context).btnBD.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnBC.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnBDRightTop[0] && biggestY <= GlobalUsage.btnBDRightBottom[1]
                && smallestX >= GlobalUsage.btnBDLeftTop[0] && smallestY >= GlobalUsage.btnBDLeftTop[1])
        {
            ((MainActivity) context).btnBD.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnBD.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnBERightTop[0] && biggestY <= GlobalUsage.btnBERightBottom[1]
                && smallestX >= GlobalUsage.btnBELeftTop[0] && smallestY >= GlobalUsage.btnBELeftTop[1])
        {
            ((MainActivity) context).btnBE.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnBE.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnBFRightTop[0] && biggestY <= GlobalUsage.btnBFRightBottom[1]
                && smallestX >= GlobalUsage.btnBFLeftTop[0] && smallestY >= GlobalUsage.btnBFLeftTop[1])
        {
            ((MainActivity) context).btnBF.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnBF.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnBGRightTop[0] && biggestY <= GlobalUsage.btnBGRightBottom[1]
                && smallestX >= GlobalUsage.btnBGLeftTop[0] && smallestY >= GlobalUsage.btnBGLeftTop[1])
        {
            ((MainActivity) context).btnBG.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnBG.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnBARightTop[0] && biggestY <= GlobalUsage.btnBARightBottom[1]
                && smallestX >= GlobalUsage.btnBALeftTop[0] && smallestY >= GlobalUsage.btnBALeftTop[1])
        {
            ((MainActivity) context).btnBA.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnBA.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnBBRightTop[0] && biggestY <= GlobalUsage.btnBBRightBottom[1]
                && smallestX >= GlobalUsage.btnBBLeftTop[0] && smallestY >= GlobalUsage.btnBBLeftTop[1])
        {
            ((MainActivity) context).btnBB.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnBB.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnTCRightTop[0] && biggestY <= GlobalUsage.btnTCRightBottom[1]
                && smallestX >= GlobalUsage.btnTCLeftTop[0] && smallestY >= GlobalUsage.btnTCLeftTop[1])
        {
            ((MainActivity) context).btnTC.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnTC.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnTDRightTop[0] && biggestY <= GlobalUsage.btnTDRightBottom[1]
                && smallestX >= GlobalUsage.btnTDLeftTop[0] && smallestY >= GlobalUsage.btnTDLeftTop[1])
        {
            ((MainActivity) context).btnTD.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnTD.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnTERightTop[0] && biggestY <= GlobalUsage.btnTERightBottom[1]
                && smallestX >= GlobalUsage.btnTELeftTop[0] && smallestY >= GlobalUsage.btnTELeftTop[1])
        {
            ((MainActivity) context).btnTE.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnTE.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnTFRightTop[0] && biggestY <= GlobalUsage.btnTFRightBottom[1]
                && smallestX >= GlobalUsage.btnTFLeftTop[0] && smallestY >= GlobalUsage.btnTFLeftTop[1])
        {
            ((MainActivity) context).btnTF.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnTF.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnTGRightTop[0] && biggestY <= GlobalUsage.btnTGRightBottom[1]
                && smallestX >= GlobalUsage.btnTGLeftTop[0] && smallestY >= GlobalUsage.btnTGLeftTop[1])
        {
            ((MainActivity) context).btnTG.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnTG.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnTARightTop[0] && biggestY <= GlobalUsage.btnTARightBottom[1]
                && smallestX >= GlobalUsage.btnTALeftTop[0] && smallestY >= GlobalUsage.btnTALeftTop[1])
        {
            ((MainActivity) context).btnTA.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnTA.setPressed(false);
        }
        if(biggestX <= GlobalUsage.btnTBRightTop[0] && biggestY <= GlobalUsage.btnTBRightBottom[1]
                && smallestX >= GlobalUsage.btnTBLeftTop[0] && smallestY >= GlobalUsage.btnTBLeftTop[1])
        {
            ((MainActivity) context).btnTB.setPressed(true);
//            new ClickTask(context, new ClickTask.ClickFinishResponse() {
//            @Override
//            public void processFinished() {
//                processing = false;
//            }
//        }).execute();
        }
        else
        {
            ((MainActivity) context).btnTB.setPressed(false);
        }
    }


}
