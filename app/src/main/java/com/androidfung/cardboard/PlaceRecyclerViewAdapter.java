package com.androidfung.cardboard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by fung on 5/4/2016.
 */
public class PlaceRecyclerViewAdapter extends RecyclerView.Adapter<PlaceRecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private String[] mNames;
//    private TypedArray mImages;
    private String[] mImages;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;
        public View mRootView;

        public ViewHolder(View v) {
            super(v);
            mRootView = v;
            mTextView = (TextView) v.findViewById(R.id.textview_place_name);
            mImageView = (ImageView) v.findViewById(R.id.imageview_place_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PlaceRecyclerViewAdapter(Context context) {
        mContext = context;
        mNames = mContext.getResources().getStringArray(R.array.place_name);
        mImages = mContext.getResources().getStringArray(R.array.place_image_asset);
//     mImages = mContext.getResources().obtainTypedArray(R.array.place_image);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlaceRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_place, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mNames[position]);
//        holder.mImageView.setImageResource(mImages[position]);
        Glide.with(mContext).load(Uri.parse(mImages[position])).centerCrop().into(holder.mImageView);
        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FullscreenPanoActivity.class);
                intent.putExtra(FullscreenPanoActivity.ARG_URI,Uri.parse(mImages[position]));
                mContext.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mNames.length;
    }
}

