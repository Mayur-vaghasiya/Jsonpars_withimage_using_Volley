package com.example.jsonpars_withimage_using_volley;

/**
 * Created by peacock on 3/30/16.
 */

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

public class CircleTransform implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        return ImageUtil.getCircularBitmapImage(source);
    }

    @Override
    public String key() {
        return "circle-image";
    }
}

