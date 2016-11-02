package com.kuang.readhtml;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by SONY on 2016/10/31.
 */
public class MenuActivity extends AppCompatActivity{
    private Button mbutton_nation1,mbutton_nation2,mbutton_nation3,mbutton_nation4,mbutton_nation5,mbutton_nation6,mbutton_nation8,mbutton_nation10;
    public String direction_command="";
    private Button.OnClickListener choose_NS =new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Button b=(Button)v;
            direction_command= b.getText().toString();
            //popout_NS();
            CustomDialog customDialog = new CustomDialog(MenuActivity.this);
            customDialog.popout_NS(new CustomDialog.ButtonOnClick() {
                @Override
                public void click(View v ,AlertDialog alertD) {
                    Button b = (Button) v;
                    direction_command = direction_command + b.getText().toString();
                    Log.d("QQ", direction_command);
                    alertD.cancel();
                    Intent intent = new Intent();
                    intent.setClass(MenuActivity.this, MainActivity.class);
                    intent.putExtra("filename",direction_command);
                    startActivity(intent);
                }
            });

            // M V C
        }
    };
    private Button.OnClickListener choose_EW =new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Button b=(Button)v;
            direction_command= b.getText().toString();
//            popout_EW();
            CustomDialog customDialog = new CustomDialog(MenuActivity.this);
            customDialog.popout_EW(new CustomDialog.ButtonOnClick() {
                @Override
                public void click(View v ,AlertDialog alertD) {
                    Button b = (Button) v;
                    direction_command = direction_command + b.getText().toString();
                    Log.d("QQ", direction_command);
                    alertD.cancel();
                    Intent intent = new Intent();
                    intent.setClass(MenuActivity.this, MainActivity.class);
                    intent.putExtra("filename",direction_command);
                    startActivity(intent);
                }
            });
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        match();
        match_button();
    }

    private void match(){
        mbutton_nation1=(Button)findViewById(R.id.button_nation1);
        mbutton_nation2=(Button)findViewById(R.id.button_nation2);
        mbutton_nation3=(Button)findViewById(R.id.button_nation3);
        mbutton_nation4=(Button)findViewById(R.id.button_nation4);
        mbutton_nation5=(Button)findViewById(R.id.button_nation5);
        mbutton_nation6=(Button)findViewById(R.id.button_nation6);
        mbutton_nation8=(Button)findViewById(R.id.button_nation8);
        mbutton_nation10=(Button)findViewById(R.id.button_nation10);
    }
    private void match_button(){
        mbutton_nation1.setOnClickListener(choose_NS);
        mbutton_nation3.setOnClickListener(choose_NS);
        mbutton_nation5.setOnClickListener(choose_NS);
        mbutton_nation2.setOnClickListener(choose_EW);
        mbutton_nation4.setOnClickListener(choose_EW);
        mbutton_nation6.setOnClickListener(choose_EW);
        mbutton_nation8.setOnClickListener(choose_EW);
        mbutton_nation10.setOnClickListener(choose_EW);
    }
    public void popout_NS(){
        LayoutInflater inflater = LayoutInflater.from(MenuActivity.this);
        final View v = inflater.inflate(R.layout.north_south_direction, null);
        final AlertDialog alertD =new AlertDialog.Builder(MenuActivity.this).create();
        alertD.setTitle("請選擇您的方向");
        alertD.setView(v);
        Button mbutton1 =( Button) (v.findViewById(R.id.button_north));
        Button mbutton2 =( Button) (v.findViewById(R.id.button_south));
        Button.OnClickListener direction_command_listener =new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                direction_command = direction_command + b.getText().toString();
                Log.d("QQ", direction_command);
                alertD.cancel();
                Intent intent = new Intent();
                intent.setClass(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
        mbutton1.setOnClickListener(direction_command_listener);
        mbutton2.setOnClickListener(direction_command_listener);
        alertD.show();
        alertD.setCanceledOnTouchOutside(true);
    }
    public void popout_EW(){
        LayoutInflater inflater = LayoutInflater.from(MenuActivity.this);
        final View v = inflater.inflate(R.layout.east_west_direction, null);
        final AlertDialog alertD =new AlertDialog.Builder(MenuActivity.this).create();
        alertD.setTitle("請選擇您的方向");
        alertD.setView(v);
        Button mbutton1 =( Button) (v.findViewById(R.id.button_east));
        Button mbutton2 =( Button) (v.findViewById(R.id.button_west));
        Button.OnClickListener direction_command_listener =new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                direction_command = direction_command + b.getText().toString();
                Log.d("QQ", direction_command);
                alertD.cancel();
            }
        };
        mbutton1.setOnClickListener(direction_command_listener);
        mbutton2.setOnClickListener(direction_command_listener);
        alertD.show();
        alertD.setCanceledOnTouchOutside(true);
    }
}