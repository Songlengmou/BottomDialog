package com.anningtex.bottomdialog.two;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anningtex.bottomdialog.R;

/**
 * @author Administrator
 */
public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnShow1, mBtnShow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
    }

    private void initView() {
        mBtnShow1 = findViewById(R.id.btn_show_1);
        mBtnShow2 = findViewById(R.id.btn_show_2);
        mBtnShow1.setOnClickListener(this);
        mBtnShow2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_1:
                show1();
                break;
            case R.id.btn_show_2:
                show2();
                break;
            default:
                break;
        }
    }

    private void show1() {
        Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_normal, null);
        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();
    }

    private void show2() {
        Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_content_circle, null);
        bottomDialog.setContentView(contentView);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contentView.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(this, 16f);
        params.bottomMargin = DensityUtil.dp2px(this, 8f);
        contentView.setLayoutParams(params);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();
        TextView tvOne = contentView.findViewById(R.id.tv_one);
        TextView tvTwo = contentView.findViewById(R.id.tv_two);
        tvOne.setOnClickListener(view -> Toast.makeText(TwoActivity.this, "1111", Toast.LENGTH_SHORT).show());
        tvTwo.setOnClickListener(view -> Toast.makeText(TwoActivity.this, "222", Toast.LENGTH_SHORT).show());
    }
}