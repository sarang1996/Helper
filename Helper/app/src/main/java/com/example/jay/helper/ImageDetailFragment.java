package com.example.jay.helper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by jay on 29/01/2016.
 */
public class ImageDetailFragment extends Fragment {

    private static final String IMAGE_DATA_EXTRA = "resId";
    private int mImageNum;
    private ImageView mImageView;
    private ImageView next;

    static ImageDetailFragment newInstance(int imageNum){
        final ImageDetailFragment f = new ImageDetailFragment();
        final Bundle args = new Bundle();

        args.putInt(IMAGE_DATA_EXTRA, imageNum);
        f.setArguments(args);

        return f;
    }

    public ImageDetailFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mImageNum = getArguments() != null ? getArguments().getInt(IMAGE_DATA_EXTRA) : -1;
        //Toast.makeText(getContext(), "mImageNum : "+mImageNum, Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.image_detail_fragment, container, false);

        mImageView = (ImageView) v.findViewById(R.id.imageView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //final int resId = ImageDetailActivity.imageResIds[mImageNum];

        //Bitmap bitmap = BitmapConvertor.decodeSampledBitmapFromResource(getResources(), resId, 500, 500);
        //BitmapConvertor.setBitmapOnImageView(bitmap, mImageView);

        if(ImageDetailActivity.class.isInstance(getActivity())){
            final int resId = ImageDetailActivity.imageResIds[mImageNum];
            ((ImageDetailActivity)getActivity()).loadBitmap(mImageView, getResources(), resId, 100, 100);
        }

        //mImageView.setImageResource(resId);
    }
}
