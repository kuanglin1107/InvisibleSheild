package scott.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mWebView = (WebView) findViewById(R.id.webView);

        try {
            InputStream inputStream = getAssets().open("CH01.xhtml");
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }

            content = total.toString();
            mWebView.loadDataWithBaseURL("",total.toString(),"text/html","utf-8","");
            mWebView.setWebContentsDebuggingEnabled(true);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.addJavascriptInterface(new WebAppInterface(this), "Kuang");
            Log.d("QQ","載入");

            mWebView.setWebViewClient(new WebViewClient(){

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    Log.d("QQ","好溜～～～～～");
                    mWebView.loadUrl("javascript:Kuang.getScreen(document.body.clientWidth);");
                }
            });

        }catch (Exception e){
            Log.e("QQ",e.getLocalizedMessage());
        }
    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void getScreen(int width) {
            Log.d("QQ","螢幕寬："+width);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    content = content.replace("-webkit-column-width: 10px;","-webkit-column-width: 312px;");
                    mWebView.loadDataWithBaseURL("",content,"text/html","utf-8","");
                }
            });
        }

        @JavascriptInterface
        public void qq() {
            Log.d("QQ","安安安安安安ㄢ");
        }
    }
}
