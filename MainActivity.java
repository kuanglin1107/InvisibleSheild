package com.kuang.readhtml;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private WebView webView,webView2;
    private String DEBUG_TAG="QQ";
    String content;
    String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        fileName = intent.getExtras().getString("filename");
        Log.d("QQ",fileName);
        webView2=(WebView)findViewById(R.id.webView2);
        readbook();
    }

    private void readbook(){
        webView=(WebView)findViewById(R.id.webView);
        webView2.loadDataWithBaseURL("","","text/html","utf-8","");
        webView.getSettings().setJavaScriptEnabled(true);
        content=load();
        webView2.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super. onPageFinished(view, url);
                webView.addJavascriptInterface(new WebAppInterface(MainActivity.this), "test");
                webView.loadUrl("javascript:test.getScreen(document.body.clientWidth);");
                webView.loadUrl("javascript:test.getScreenHeight(document.body.offsetHeight);");
                Log.d(DEBUG_TAG,"長寬LOAD完畢");
            }
        });
                webView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        int action = MotionEventCompat.getActionMasked(event);
                        final float touchPoint= event.getX();
                        switch(action) {
                            case (MotionEvent.ACTION_UP) :
                                if(touchPoint>webView.getWidth()/2){
                                    webView.loadUrl("javascript:window.scrollBy(document.body.clientWidth+20, 0);");
                                    Log.d(DEBUG_TAG,"Action was rightUP");
                                }
                                else{
                                    webView.loadUrl("javascript:window.scrollBy((-document.body.clientWidth-20), 0);");
                                    Log.d(DEBUG_TAG,"Action was leftUP");
                                }
                                return true;
                        }return true;
                    }
                });
    }

    private String load(){
        BufferedReader buffer=null;
        StringBuffer sb = new StringBuffer();
        try {
            InputStream is = getAssets().open(fileName+".xhtml");
            buffer = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=buffer.readLine())!=null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(buffer!=null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }



    public class WebAppInterface{
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void getScreen(final int width) {
            Log.d("QQ","螢幕寬："+width);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    content = content.replace("-webkit-column-width: 100px;","-webkit-column-width: "+width+"px;");
                }
            });}
        @JavascriptInterface
        public void getScreenHeight(final int height) {
            Log.d("QQ","螢幕高："+height);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                   content = content.replace("height: 600px;","height: "+height+"px;");
                    webView.loadDataWithBaseURL("",content,"text/html","utf-8","");
                }
            });
        }
    }
}
