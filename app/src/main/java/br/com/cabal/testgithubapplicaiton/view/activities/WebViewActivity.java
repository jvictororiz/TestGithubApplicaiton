package br.com.cabal.testgithubapplicaiton.view.activities;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.com.cabal.testgithubapplicaiton.R;


public class WebViewActivity extends SuperActivity {
    public static final String EXTRA_URL = "EXTRA_URL";

    private View imgBack;
    private WebView wvTvTerms;

    private String urlRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getExtras();
        setViews();
        setUrlRepository();
        setEvents();
    }

    private void getExtras() {
        urlRepository = getIntent().getStringExtra(EXTRA_URL);
    }

    private void setUrlRepository() {
//        wvTvTerms.getSettings().setJavaScriptEnabled(true);
        wvTvTerms.setWebViewClient(new WebViewClient());
        registerForContextMenu(wvTvTerms);

        wvTvTerms.loadUrl(urlRepository);
        wvTvTerms.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        wvTvTerms.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);


    }

    private void setViews() {
        imgBack = findViewById(R.id.img_back_black);
        wvTvTerms = findViewById(R.id.webview_tv_terms);
    }

    private void setEvents() {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
