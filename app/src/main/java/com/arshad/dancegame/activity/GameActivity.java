package com.arshad.dancegame.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arshad.dancegame.global.GlobalFunctions;
import com.arshad.dancegame.global.SharedPrefsGetSet;
import com.arshad.dancegame.model.GameTile;
import com.arshad.dancegame.R;
import com.arshad.dancegame.adapter.GameTileAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {

    @Bind(R.id.rvGrid)
    RecyclerView rvGrid;

    private Context mContext;
    private RecyclerView.LayoutManager rvLayoutManager;
    private int n=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        mContext = this;

        if(getIntent().hasExtra("n")) {
            n = getIntent().getIntExtra("n", 0);

            rvLayoutManager = new GridLayoutManager(mContext, n);
            rvGrid.setLayoutManager(rvLayoutManager);

            int random = GlobalFunctions.random(1, n*n, SharedPrefsGetSet.getRandom(mContext));
            SharedPrefsGetSet.setRandom(mContext, random);
            SharedPrefsGetSet.setNValue(mContext, (n*n));
            SharedPrefsGetSet.setCount(mContext, 0);

            List<GameTile> numbers = new ArrayList<>();
            for(int i=0;i<(n*n);i++) {
                GameTile gTile = new GameTile();
                gTile.setPosition(i+1);
                gTile.setSelected(false);
                if(i+1 == random) {
                    gTile.setSelected(true);
                }
                numbers.add(gTile);
            }

            GameTileAdapter adapter = new GameTileAdapter(mContext, numbers);
            rvGrid.setAdapter(adapter);
        }

    }
}
