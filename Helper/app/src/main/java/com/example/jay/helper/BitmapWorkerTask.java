package com.example.jay.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * Created by jay on 30/01/2016.
 */
public class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {

    private final WeakReference<ImageView> imageViewWeakReference;
    private int data = 0;

    private Resources res;
    private int resId, reqWidth, reqHeight;

    public BitmapWorkerTask(ImageView imageView, Resources res, int reqWidth, int reqHeight){
        // Use a WeakReference to ensure the ImageView can be garbage collected.
        imageViewWeakReference = new WeakReference<ImageView>(imageView);

        this.res = res;
        this.reqWidth = reqWidth;
        this.reqHeight = reqHeight;
    }

    // Decode image in background
    @Override
    protected Bitmap doInBackground(Integer... params) {
        data = params[0];
        return BitmapConvertor.decodeSampledBitmapFromResource(res, data, reqWidth, reqHeight);
    }

    // Once complete, see if ImageView is still around and set Bitmap
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if(imageViewWeakReference != null && bitmap != null){
            final ImageView imageView = imageViewWeakReference.get();
            if(imageView != null){
                BitmapConvertor.setBitmapOnImageView(bitmap, imageView);
            }
        }
    }
}
