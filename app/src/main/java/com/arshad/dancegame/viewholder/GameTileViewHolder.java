package com.arshad.dancegame.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arshad.dancegame.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameTileViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.llParent)
    public LinearLayout llParent;

    @Bind(R.id.ivImage)
    public ImageView ivImage;

    public GameTileViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
