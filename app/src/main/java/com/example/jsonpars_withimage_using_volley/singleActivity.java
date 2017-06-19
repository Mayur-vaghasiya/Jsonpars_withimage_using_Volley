package com.example.jsonpars_withimage_using_volley;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.api.GoogleApiClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.*;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.squareup.picasso.Picasso;

public class singleActivity extends Activity {

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        Intent in = getIntent();
        // Get JSON values from previous intent
        String name = in.getStringExtra("name");
        String worth = in.getStringExtra("worth");
        String source = in.getStringExtra("source");
        int year = in.getIntExtra("InYear", 0);
        String image = in.getStringExtra("image");


        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name);
        TextView lblworth = (TextView) findViewById(R.id.worth);
        TextView lblsource = (TextView) findViewById(R.id.source);
        TextView lblyear = (TextView) findViewById(R.id.inYear);
        ImageView imageView = (ImageView) findViewById(R.id.thumbnail);

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        lblName.setText("Name : " + name);
        lblworth.setText("Worth : " + worth);
        lblsource.setText("Source : " + source);
        lblyear.setText("Year : " + String.valueOf(year));
        try {
            /* for resize not work
            BitmapFactory.Options resizeOptions = new BitmapFactory.Options();
            resizeOptions.inSampleSize = 8; // decrease size 3 times
            resizeOptions.inScaled = true;*/
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .displayer(new RoundedBitmapDisplayer(190))
                    .cacheInMemory(true)
                    .resetViewBeforeLoading(true)
                   /* .decodingOptions(resizeOptions)*/
                    .displayer(new CircleBitmapDisplayer(Color.parseColor("#ABB2B9"),7)).build();

                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.init(ImageLoaderConfiguration.createDefault(this));
                imageLoader.displayImage(image, imageView,options);

        } catch (Exception e) {
            Toast.makeText(getApplication(), "" + e.toString(), Toast.LENGTH_SHORT).show();
        }

        //Loading image from below url into imageView
       // Picasso.with(this).load(image).transform(new CircleTransform()).into(imageView);

        //Loading image from below url into imageView
        //   Glide.with(this).load(image).transform(new GlideCircleTransform(singleActivity.this)).into(imageView);
        //Glide.with(this)
        //      .load(image)
        //       .transform(new GlideCircleTransform(singleActivity.this))
        //  .thumbnail(0.5f)
        // .crossFade()
        //  .diskCacheStrategy(DiskCacheStrategy.ALL)
        //.override(400, 400)
        // .centerCrop()
        //    .into(imageView);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }


}
