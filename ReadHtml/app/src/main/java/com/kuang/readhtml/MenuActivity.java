package com.kuang.readhtml;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 2016/10/31.
 */
public class MenuActivity extends AppCompatActivity implements DialogButton{
//    private Button mbutton_nation1,mbutton_nation2,mbutton_nation3,mbutton_nation4,mbutton_nation5,mbutton_nation6,mbutton_nation8,mbutton_nation10;
    public static String direction_command="";
    private List<String> imgText = new ArrayList<>();
    private List<Integer> imageId = new ArrayList<>();
    GridView gridView;
//    public Context getContext(){
//     Context context=MenuActivity.this;
//        return context;
//    }

//    private Button.OnClickListener choose_NS =new Button.OnClickListener(){
//        @Override
//        public void onClick(View v) {
//            Button b=(Button)v;
//            direction_command= b.getText().toString();
//            //popout_NS();
//            CustomDialog customDialog = new CustomDialog(MenuActivity.this);
//            customDialog.popout_NS(new CustomDialog.ButtonOnClick() {
//                @Override
//                public void click(View v ,AlertDialog alertD) {
//                    Button b = (Button) v;
//                    direction_command = direction_command + b.getText().toString();
//                    Log.d("QQ", direction_command);
//                    alertD.cancel();
//                    Intent intent = new Intent();
//                    intent.setClass(MenuActivity.this, MainActivity.class);
//                    intent.putExtra("filename",direction_command);
//                    startActivity(intent);
//                }
//            });
//
//            // M V C
//        }
//    };
//    private Button.OnClickListener choose_EW =new Button.OnClickListener(){
//        @Override
//        public void onClick(View v) {
//            Button b=(Button)v;
//            direction_command= b.getText().toString();
////            popout_EW();
//            CustomDialog customDialog = new CustomDialog(MenuActivity.this);
//            customDialog.popout_EW(new CustomDialog.ButtonOnClick() {
//                @Override
//                public void click(View v ,AlertDialog alertD) {
//                    Button b = (Button) v;
//                    direction_command = direction_command + b.getText().toString();
//                    Log.d("QQ", direction_command);
//                    alertD.cancel();
//                    Intent intent = new Intent();
//                    intent.setClass(MenuActivity.this, MainActivity.class);
//                    intent.putExtra("filename",direction_command);
//                    startActivity(intent);
//                }
//            });
//        }
//    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

//        match();
//        match_button();
        matchGrid();
    }

    private void matchGrid(){
        imgText.add(getText(R.string.file1).toString());
        imageId.add(R.drawable.twhw1);
        imgText.add(getText(R.string.file2).toString());
        imageId.add(R.drawable.twhw2);
        imgText.add(getText(R.string.file3).toString());
        imageId.add(R.drawable.twhw3);
        imgText.add(getText(R.string.file4).toString());
        imageId.add(R.drawable.twhw4);
        imgText.add(getText(R.string.file5).toString());
        imageId.add(R.drawable.twhw5);
        imgText.add(getText(R.string.file6).toString());
        imageId.add(R.drawable.twhw6);
        imgText.add(getText(R.string.file7).toString());
        imageId.add(R.drawable.twhw8);
        imgText.add(getText(R.string.file8).toString());
        imageId.add(R.drawable.twhw10);
        CustomGrid adapter = new CustomGrid(MenuActivity.this, imgText, imageId);
        gridView = (GridView)findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                direction_command = imgText.get(position);
                Log.d("QQ",direction_command);
//                CustomDialog customDialog = new CustomDialog(MenuActivity.this);
//                DialogButton buttonOnClick= new MenuActivity();
                if (position==6){
                    popout_EW();
                }
                else if(position%2==0){
                    popout_NS();
                }else{
                    popout_EW();
////                    customDialog.popout_EW(new CustomDialog.ButtonOnClick() {
////                        @Override
////                        public void click(View v ,AlertDialog alertD) {
////                            Button b = (Button) v;
////                            direction_command = direction_command + b.getText().toString();
////                            Log.d("QQ", direction_command);
////                            alertD.cancel();
////                            Intent intent = new Intent();
////                            intent.setClass(MenuActivity.this, MainActivity.class);
////                            intent.putExtra("filename",direction_command);
////                            startActivity(intent);
//                        }
//                    });
                }

            }});}
    public void intitActivity(){
        Intent intent = new Intent();
        intent.setClass(MenuActivity.this, MainActivity.class);
        intent.putExtra("filename",direction_command);
        startActivity(intent);
    }
//    private void match(){
//        mbutton_nation1=(Button)findViewById(R.id.button_nation1);
//        mbutton_nation2=(Button)findViewById(R.id.button_nation2);
//        mbutton_nation3=(Button)findViewById(R.id.button_nation3);
//        mbutton_nation4=(Button)findViewById(R.id.button_nation4);
//        mbutton_nation5=(Button)findViewById(R.id.button_nation5);
//        mbutton_nation6=(Button)findViewById(R.id.button_nation6);
//        mbutton_nation8=(Button)findViewById(R.id.button_nation8);
//        mbutton_nation10=(Button)findViewById(R.id.button_nation10);
//    }
//    private void match_button(){
//        mbutton_nation1.setOnClickListener(choose_NS);
//        mbutton_nation3.setOnClickListener(choose_NS);
//        mbutton_nation5.setOnClickListener(choose_NS);
//        mbutton_nation2.setOnClickListener(choose_EW);
//        mbutton_nation4.setOnClickListener(choose_EW);
//        mbutton_nation6.setOnClickListener(choose_EW);
//        mbutton_nation8.setOnClickListener(choose_EW);
//        mbutton_nation10.setOnClickListener(choose_EW);
//    }
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
                intitActivity();
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
                intitActivity();
            }
        };
        mbutton1.setOnClickListener(direction_command_listener);
        mbutton2.setOnClickListener(direction_command_listener);
        alertD.show();
        alertD.setCanceledOnTouchOutside(true);
    }

    @Override
    public void click(View v, AlertDialog alertD) {
        Button b = (Button) v;
        direction_command = direction_command + b.getText().toString();
        Log.d("QQ", direction_command);
        alertD.cancel();
//        Intent intent = new Intent();
//        intent.setClass(MenuActivity.this, MainActivity.class);
//        intent.putExtra("filename",direction_command);
//        startActivity(intent);
    }
}