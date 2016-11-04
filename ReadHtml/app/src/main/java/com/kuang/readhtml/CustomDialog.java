package com.kuang.readhtml;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by SONY on 2016/11/1.
 */

public class CustomDialog {

    private Context context;

    public interface ButtonOnClick {
        void click(View v,AlertDialog gg);
    }

    public CustomDialog(Context context) {
        this.context = context;
    }

    public void popout_NS(final ButtonOnClick ccc){

        LayoutInflater inflater = LayoutInflater.from(context);
        final View v = inflater.inflate(R.layout.north_south_direction, null);
        final AlertDialog alertD =new AlertDialog.Builder(context).create();
        alertD.setTitle("請選擇您的方向");
        alertD.setView(v);
        Button mbutton1 =( Button) (v.findViewById(R.id.button_north));
        Button mbutton2 =( Button) (v.findViewById(R.id.button_south));
        Button.OnClickListener direction_command_listener =new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                ccc.click(v,alertD);
            }
        };
        mbutton1.setOnClickListener(direction_command_listener);
        mbutton2.setOnClickListener(direction_command_listener);
        alertD.show();
        alertD.setCanceledOnTouchOutside(true);
    }
    public void popout_EW(final ButtonOnClick ccc){
        LayoutInflater inflater = LayoutInflater.from(context);
        final View v = inflater.inflate(R.layout.east_west_direction, null);
        final AlertDialog alertD =new AlertDialog.Builder(context).create();
        alertD.setTitle("請選擇您的方向");
        alertD.setView(v);
        Button mbutton1 =( Button) (v.findViewById(R.id.button_east));
        Button mbutton2 =( Button) (v.findViewById(R.id.button_west));
        Button.OnClickListener direction_command_listener =new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                ccc.click(v,alertD);
            }
        };
        mbutton1.setOnClickListener(direction_command_listener);
        mbutton2.setOnClickListener(direction_command_listener);
        alertD.show();
        alertD.setCanceledOnTouchOutside(true);
    }
}
