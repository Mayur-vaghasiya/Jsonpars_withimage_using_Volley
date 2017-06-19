package com.example.jsonpars_withimage_using_volley;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
//import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.squareup.picasso.Picasso;


/**
 * Created by peacock on 3/29/16.
 */
public class Listadapter extends BaseAdapter {
    private Context context;
    private ArrayList<Forbsbillenior> forbsbilleniors;
    private LayoutInflater inflater;
    // ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public Listadapter(Context context, ArrayList<Forbsbillenior> forbsbilleniors) {
        this.context = context;
        this.forbsbilleniors = forbsbilleniors;
    }

    @Override
    public int getCount() {
        return forbsbilleniors.size();
    }

    @Override
    public Object getItem(int location) {
        return forbsbilleniors.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, null);
            holder = new Holder();

            //   imageLoader = AppController.getInstance().getImageLoader();
            //  holder.photos = (NetworkImageView) convertView.findViewById(R.id.thumbnail);

            holder.txtusername = (TextView) convertView.findViewById(R.id.name);
            holder.txtworth = (TextView) convertView.findViewById(R.id.worth);
            holder.txtsource = (TextView) convertView.findViewById(R.id.source);
            holder.txtyear = (TextView) convertView.findViewById(R.id.inYear);
            holder.imageview = (ImageView) convertView.findViewById(R.id.thumbnail);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.txtusername.setText(forbsbilleniors.get(position).getName());
        holder.txtworth.setText(forbsbilleniors.get(position).getWorth());
        holder.txtsource.setText("Wealth Source: " + forbsbilleniors.get(position).getSources());
        holder.txtyear.setText(String.valueOf(forbsbilleniors.get(position).getYear()));


        /* holder.photos.setImageUrl(forbsbilleniors.get(position).getPhoto(), imageLoader);*/

        /*DisplayImageOptions options = new DisplayImageOptions.Builder()
                .displayer(new RoundedBitmapDisplayer(190))
                .cacheInMemory(true)
                .resetViewBeforeLoading(true)
                .build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        imageLoader.displayImage(forbsbilleniors.get(position).getPhoto(), holder.imageview, options);*/

        //Picasso.with(context).load(forbsbilleniors.get(position).getPhoto()).transform(new CircleTransform()).into(holder.imageview);

        Glide.with(context)
                .load(forbsbilleniors.get(position).getPhoto())
                .transform(new GlideCircleTransform(context))
                .into(holder.imageview);

        return convertView;
    }

    public class Holder {

        public TextView txtusername, txtworth, txtyear, txtsource;
        public ImageView imageview;
        public NetworkImageView photos;

    }
}
