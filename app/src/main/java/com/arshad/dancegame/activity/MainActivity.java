package com.arshad.dancegame.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.arshad.dancegame.R;
import com.arshad.dancegame.global.GlobalFunctions;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.tvStartGame)
    TextView tvStartGame;

    @Bind(R.id.etNumber)
    EditText etNumber;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        tvStartGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvStartGame:
                if(etNumber.getText().toString().isEmpty()) {
                    GlobalFunctions.toastShort(mContext, "Add value for n");
                } else {
                    Intent i = new Intent(mContext, GameActivity.class);
                    i.putExtra("n", Integer.parseInt(etNumber.getText().toString()));
                    startActivity(i);
                }
                break;
        }
    }
}
