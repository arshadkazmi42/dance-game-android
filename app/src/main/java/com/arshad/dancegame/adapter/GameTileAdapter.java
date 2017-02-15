package com.arshad.dancegame.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.arshad.dancegame.R;
import com.arshad.dancegame.global.GlobalFunctions;
import com.arshad.dancegame.global.SharedPrefsGetSet;
import com.arshad.dancegame.model.GameTile;
import com.arshad.dancegame.viewholder.GameTileViewHolder;

import java.util.List;


public class GameTileAdapter extends RecyclerView.Adapter<GameTileViewHolder> {

    private Context mContext;
    private List<GameTile> list;

    public GameTileAdapter(Context mContext, List<GameTile> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(final GameTileViewHolder holder, final int position) {
        final GameTile data = list.get(position);

        if(position == SharedPrefsGetSet.getRandom(mContext)) {
            holder.llParent.setBackgroundResource(R.drawable.bg_border_primary);
        } else {
            holder.llParent.setBackgroundResource(R.drawable.bg_border_primary_selected);
        }

        holder.llParent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if(position != SharedPrefsGetSet.getRandom(mContext)) {
                            int count = SharedPrefsGetSet.getCount(mContext);
                            Log.e("Count: ", count + " ");
                            Log.e("Value: ", (count % 2) + " ");
                            if(count % 2 == 0) {
                                GlobalFunctions.toastLong(mContext, "Player 2 Lost");
                            } else {
                                GlobalFunctions.toastLong(mContext, "Player 1 Lost");
                            }
                            ((Activity)mContext).finish();
                        } else {
                            //Generating Random Position;
                            int random = GlobalFunctions.random(1, SharedPrefsGetSet.getNValue(mContext), SharedPrefsGetSet.getRandom(mContext));

                            //Setting Random to SharedPrefs
                            SharedPrefsGetSet.setRandom(mContext, random);

                            //Incremneting Count in SharedPrefs;
                            SharedPrefsGetSet.setCount(mContext, (SharedPrefsGetSet.getCount(mContext) + 1));

                            //Updating layout color
                            holder.llParent.setBackgroundResource(R.drawable.bg_border_primary);

                            //Notifying adapter change
                            notifyItemChanged(random);
                            notifyItemChanged(position);
                        }

                        return true;
                    case MotionEvent.ACTION_UP:
                        holder.llParent.setBackgroundResource(R.drawable.bg_border_primary_selected);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public GameTileViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from (mContext).inflate(R.layout.single_row_grid, viewGroup, false);
        return new GameTileViewHolder(v);
    }
}
