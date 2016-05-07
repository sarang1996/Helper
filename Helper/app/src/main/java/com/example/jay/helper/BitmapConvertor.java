package com.example.jay.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

/**
 * Created by jay on 29/01/2016.
 */
public class BitmapConvertor{

    BitmapFactory.Options options = new BitmapFactory.Options();

    static int res_Id;

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        // Raw height & width of the image
        final int height = options.outHeight;
        final int width = options.outWidth;

        int inSampleSize = 1;

        if(height > reqHeight || width > reqWidth){
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height & width larger than the requested height & width.
            while((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth){
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){

        res_Id = resId;

        // First check with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        //options.inJustDecodeBounds = true;
        //return BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set.
        options.inJustDecodeBounds = false;

        //BitmapFactory.decodeFile();

        Bitmap bitmap = BitmapFactory.decodeResource(res, resId, options);
        //bitmap.compress(Bitmap.CompressFormat.PNG, 512, );

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 30, stream);

        return bitmap;
    }

    public static void setBitmapOnImageView(Bitmap bitmap, ImageView imageView){
        imageView.setImageBitmap(bitmap);
    }

}
