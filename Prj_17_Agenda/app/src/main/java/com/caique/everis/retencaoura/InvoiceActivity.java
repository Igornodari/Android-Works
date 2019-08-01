package com.caique.everis.retencaoura;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class InvoiceActivity extends AppCompatActivity{

    ProgressBar loaging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        loaging = findViewById(R.id.loading);

        callWebView();
    }

    private void callWebView() {

        WebView webview = (WebView) findViewById(R.id.invoice);
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                setTitle("Carregando..");
                setProgress(progress * 100);

                if(progress == 100)
                    setTitle("Fatura");
                    loaging.setVisibility(View.GONE);
            }
        });
        webview.setWebViewClient(new HelloWebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://www.vivo.com.br/consumo/groups/public/documents/imgpw/pw_m_img_atend_conta_entenda_f.jpg");
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
    }

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
