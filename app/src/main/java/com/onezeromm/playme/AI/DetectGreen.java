package com.onezeromm.playme.AI;

import android.graphics.Bitmap;
import android.util.Log;

import com.onezeromm.playme.GlobalValues.GlobalUsage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class DetectGreen {

    private static final int DIRECTION_EAST = 180;
    private static final int DIRECTION_SOUTH_EAST = 225;
    private static final int DIRECTION_SOUTH = 270;
    private static final int DIRECTION_SOUTH_WEST = 315;
    private static final int DIRECTION_WEST = 360;
    private static final int DIRECTION_NORTH_WEST = 45;
    private static final int DIRECTION_NORTH = 90;
    private static final int DIRECTION_NORTH_EAST = 135;

    private Bitmap frame = null;

    public int lastRightMostX = 0, lastBottomMostY = 0, lastTopMostY = 0;
    private ArrayList<ArrayList<int[]>> detectedGreenSectors = new ArrayList<>();
    public boolean noMoreGreen = false;

    public ArrayList<ArrayList<int[]>> startDetection(Bitmap frame)
    {
        noMoreGreen = false;
        lastRightMostX = 0;
        lastBottomMostY = frame.getHeight();
        lastTopMostY = 0;
        return  detectGreenSectors(frame);
    }

    public ArrayList<ArrayList<int[]>> detectGreenSectors(Bitmap frame)
    {
        try
        {
            detectedGreenSectors = new ArrayList<>();
            while (!noMoreGreen)
            {
                ArrayList<int[]> tempLocation  = detect(frame);
                if(tempLocation != null && !noMoreGreen)
                {
                    detectedGreenSectors.add(tempLocation);
                }
            }
        }
        catch (Exception e)
        {
            Log.e("DetectGreenSect",e.toString());
        }
        return detectedGreenSectors;
    }

    private ArrayList<int[]> detect(Bitmap frame)
    {
//        boolean startHor = false, endHor = false, startVer = false, endVer = false;
//        int startX = -1, startY = -1, endX = -1, endY = -1;
        int direction = DIRECTION_EAST;
        this.frame = frame;
        int w = frame.getWidth();
        int h = frame.getHeight();
        int rightMostX, bottomMostY;
        ArrayList<String> locationCheck = new ArrayList<>();
        ArrayList<int[]> locations = new ArrayList<>();
        boolean endLine = false;

        //System.out.println("w,h: " + w + ", " + h);
        //int pixShifter = 1;// resolutionPercent / 100;

        int[] xy = findStartGreenLocation(w, h);
        int[] detectedXY;

        if(xy == null)
        {
            return null;
        }

        int x = xy[0];
        int y = xy[1];
        int pixel;
        int directedCount = 0;
        rightMostX = x;
        bottomMostY = y;

        try
        {
            while (!endLine) {
                if (directedCount == 8) {
                    break;
                }
                if (x < 0) {
                    x = 0;
                }
                if (y < 0) {
                    y = 0;
                }
                if( x >= frame.getWidth())
                {
                    x = frame.getWidth() - 1;
                }
                if (y >= frame.getHeight())
                {
                    y = frame.getHeight() - 1;
                }
                pixel = frame.getPixel(x, y);

                switch (direction)
                {
                    case DIRECTION_EAST:
                        if(checkGreen(pixel))
                        {
                            if(x > rightMostX)
                            {
                                rightMostX = x;
                            }
                            if(y > bottomMostY)
                            {
                                bottomMostY = y;
                            }
                            detectedXY = new int[2];
                            detectedXY[0] = x * GlobalUsage.resizeSize;
                            detectedXY[1] = y * GlobalUsage.resizeSize;
                            String checkingLocation = x * GlobalUsage.resizeSize + String.valueOf(y * GlobalUsage.resizeSize);

                            if(!locationCheck.contains(checkingLocation))
                            {
                                locationCheck.add(checkingLocation);
                                directedCount = 1;
                                locations.add(detectedXY);
                            }
                            else
                            {
                                locations.add(detectedXY);
                                endLine = true;
                            }
                            x++;
                            y--;
                            direction = DIRECTION_NORTH_EAST;
                        }
                        else
                        {
                            directedCount++;
                            y++;
                            direction = DIRECTION_SOUTH_EAST;
                        }
                        break;
                    case DIRECTION_SOUTH_EAST:
                        if(checkGreen(pixel))
                        {
                            if(x > rightMostX)
                            {
                                rightMostX = x;
                            }
                            if(y > bottomMostY)
                            {
                                bottomMostY = y;
                            }
                            detectedXY = new int[2];
                            detectedXY[0] = x * GlobalUsage.resizeSize;
                            detectedXY[1] = y * GlobalUsage.resizeSize;
                            String checkingLocation = x * GlobalUsage.resizeSize + String.valueOf(y * GlobalUsage.resizeSize);

                            if(!locationCheck.contains(checkingLocation))
                            {
                                locationCheck.add(checkingLocation);
                                directedCount = 1;
                                locations.add(detectedXY);
                            }
                            else
                            {
                                locations.add(detectedXY);
                                endLine = true;
                            }
                            x++;
                            direction = DIRECTION_EAST;
                        }
                        else
                        {
                            directedCount++;
                            x--;
                            direction = DIRECTION_SOUTH;
                        }
                        break;
                    case DIRECTION_SOUTH:
                        if(checkGreen(pixel))
                        {
                            if(x > rightMostX)
                            {
                                rightMostX = x;
                            }
                            if(y > bottomMostY)
                            {
                                bottomMostY = y;
                            }
                            detectedXY = new int[2];
                            detectedXY[0] = x * GlobalUsage.resizeSize;
                            detectedXY[1] = y * GlobalUsage.resizeSize;
                            String checkingLocation = x * GlobalUsage.resizeSize + String.valueOf(y * GlobalUsage.resizeSize);

                            if(!locationCheck.contains(checkingLocation))
                            {
                                locationCheck.add(checkingLocation);
                                directedCount = 1;
                                locations.add(detectedXY);
                            }
                            else
                            {
                                locations.add(detectedXY);
                                endLine = true;
                            }
                            x++;
                            direction = DIRECTION_EAST;
                        }
                        else
                        {
                            directedCount++;
                            x--;
                            direction = DIRECTION_SOUTH_WEST;
                        }
                        break;
                    case DIRECTION_SOUTH_WEST:
                        if(checkGreen(pixel))
                        {
                            if(x > rightMostX)
                            {
                                rightMostX = x;
                            }
                            if(y > bottomMostY)
                            {
                                bottomMostY = y;
                            }
                            detectedXY = new int[2];
                            detectedXY[0] = x * GlobalUsage.resizeSize;
                            detectedXY[1] = y * GlobalUsage.resizeSize;
                            String checkingLocation = x * GlobalUsage.resizeSize + String.valueOf(y * GlobalUsage.resizeSize);

                            if(!locationCheck.contains(checkingLocation))
                            {
                                locationCheck.add(checkingLocation);
                                directedCount = 1;
                                locations.add(detectedXY);
                            }
                            else
                            {
                                locations.add(detectedXY);
                                endLine = true;
                            }
                            x++;
                            y++;
                            direction = DIRECTION_SOUTH_EAST;
                        }
                        else
                        {
                            directedCount++;
                            y--;
                            direction = DIRECTION_WEST;
                        }
                        break;
                    case DIRECTION_WEST:
                        if(checkGreen(pixel))
                        {
                            if(x > rightMostX)
                            {
                                rightMostX = x;
                            }
                            if(y > bottomMostY)
                            {
                                bottomMostY = y;
                            }
                            detectedXY = new int[2];
                            detectedXY[0] = x * GlobalUsage.resizeSize;
                            detectedXY[1] = y * GlobalUsage.resizeSize;
                            String checkingLocation = x * GlobalUsage.resizeSize + String.valueOf(y * GlobalUsage.resizeSize);

                            if(!locationCheck.contains(checkingLocation))
                            {
                                locationCheck.add(checkingLocation);
                                directedCount = 1;
                                locations.add(detectedXY);
                            }
                            else
                            {
                                locations.add(detectedXY);
                                endLine = true;
                            }
                            x--;
                            y++;
                            direction = DIRECTION_SOUTH_WEST;
                        }
                        else
                        {
                            directedCount++;
                            y--;
                            direction = DIRECTION_NORTH_WEST;
                        }
                        break;
                    case DIRECTION_NORTH_WEST:
                        if(checkGreen(pixel))
                        {
                            if(x > rightMostX)
                            {
                                rightMostX = x;
                            }
                            if(y > bottomMostY)
                            {
                                bottomMostY = y;
                            }
                            detectedXY = new int[2];
                            detectedXY[0] = x * GlobalUsage.resizeSize;
                            detectedXY[1] = y * GlobalUsage.resizeSize;
                            String checkingLocation = x * GlobalUsage.resizeSize + String.valueOf(y * GlobalUsage.resizeSize);

                            if(!locationCheck.contains(checkingLocation))
                            {
                                locationCheck.add(checkingLocation);
                                directedCount = 1;
                                locations.add(detectedXY);
                            }
                            else
                            {
                                locations.add(detectedXY);
                                endLine = true;
                            }
                            y++;
                            x--;
                            direction = DIRECTION_SOUTH_WEST;
                        }
                        else
                        {
                            directedCount++;
                            x++;
                            direction = DIRECTION_NORTH;
                        }
                        break;
                    case DIRECTION_NORTH:
                        if(checkGreen(pixel))
                        {
                            if(x > rightMostX)
                            {
                                rightMostX = x;
                            }
                            if(y > bottomMostY)
                            {
                                bottomMostY = y;
                            }
                            detectedXY = new int[2];
                            detectedXY[0] = x * GlobalUsage.resizeSize;
                            detectedXY[1] = y * GlobalUsage.resizeSize;
                            String checkingLocation = x * GlobalUsage.resizeSize + String.valueOf(y * GlobalUsage.resizeSize);

                            if(!locationCheck.contains(checkingLocation))
                            {
                                locationCheck.add(checkingLocation);
                                directedCount = 1;
                                locations.add(detectedXY);
                            }
                            else
                            {
                                locations.add(detectedXY);
                                endLine = true;
                            }
                            x--;
                            y--;
                            direction = DIRECTION_NORTH_WEST;
                        }
                        else
                        {
                            directedCount++;
                            x++;
                            direction = DIRECTION_NORTH_EAST;
                        }
                        break;
                    case DIRECTION_NORTH_EAST:
                        if(checkGreen(pixel))
                        {
                            if(x > rightMostX)
                            {
                                rightMostX = x;
                            }
                            if(y > bottomMostY)
                            {
                                bottomMostY = y;
                            }
                            detectedXY = new int[2];
                            detectedXY[0] = x * GlobalUsage.resizeSize;
                            detectedXY[1] = y * GlobalUsage.resizeSize;
                            String checkingLocation = x * GlobalUsage.resizeSize + String.valueOf(y * GlobalUsage.resizeSize);

                            if(!locationCheck.contains(checkingLocation))
                            {
                                locationCheck.add(checkingLocation);
                                directedCount = 1;
                                locations.add(detectedXY);
                            }
                            else
                            {
                                locations.add(detectedXY);
                                endLine = true;
                            }
                            x--;
                            y--;
                            direction = DIRECTION_NORTH_WEST;
                        }
                        else
                        {
                            directedCount++;
                            y++;
                            direction = DIRECTION_EAST;
                        }
                        break;
                }
            }
        }
        catch (Exception e)
        {
            Log.e("Detect",e.toString());
        }
        lastBottomMostY = bottomMostY + 1;
        lastRightMostX = rightMostX + 1;
        return locations;
    }

    private int[] findStartGreenLocation(int w, int h)
    {
        int[] xy = new int[2];
        int y = 0, x = 0;
        for (y = lastTopMostY; y < lastBottomMostY; y++)
        {
            for (x = lastRightMostX; x < w; x++)
            {
                int pixel = frame.getPixel(x, y);
                if(checkGreen(pixel))
                {
                    lastTopMostY = y;
                    xy[0] = x;
                    xy[1] = y;
                    return xy;
                }
            }
        }
        if(y == h && x == w)
        {
            noMoreGreen = true;
            return null;
        }
        else
        {
            lastTopMostY = lastBottomMostY;
            lastBottomMostY = h;
            lastRightMostX = 0;
            return null;
        }
    }

    private static boolean checkGreen(int pixel)
    {
        boolean possibleGreen = true;
        int g = getGreen(pixel);
        int b = getBlue(pixel);
        int r = getRed(pixel);
        try
        {
            if(b > r)
            {
                if(b - r <= 90)
                {
                    possibleGreen = true;
                }
                else
                {
                    possibleGreen = false;
                }
            }
            else if(r > b)
            {
                if(r - b <= 90)
                {
                    possibleGreen = true;
                }
                else
                {
                    possibleGreen = false;
                }
            }
            else
            {
                possibleGreen = true;
            }
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        int avgRNB = 0;
        if(r + b >= 90)
        {
            avgRNB = (r + b) / 2;
        }
        else
        {
            avgRNB = r + b;
        }

        if((g <= 255 && g >= 70) && r <= 150 && b <= 150 && possibleGreen)
        {
            int greenVal = ((185 * avgRNB) / 150) + 70;
            if((greenVal + 50) >= g && (greenVal - 50) <= g)
            {
                return true;
            }
        }
        else
        {
            return false;
        }
        return false;
    }


    public static int getRed(int pixel){
        int red = (pixel >> 16) & 0xff;
        return red;
    }
    public static int getGreen(int pixel){
        int green = (pixel >> 8) & 0xff;
        return green;
    }
    public static int getBlue(int pixel){
        int blue = (pixel) & 0xff;
        return blue;
    }

}
