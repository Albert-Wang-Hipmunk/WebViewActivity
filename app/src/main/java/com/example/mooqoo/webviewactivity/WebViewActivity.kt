package com.example.mooqoo.webviewactivity

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*
import android.webkit.WebView
import android.view.KeyEvent.KEYCODE_BACK

class WebViewActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_URL = "extra_url"
        const val DEFAULT_URL = "https://www.hipmunk.com/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)


        supportActionBar?.hide()
        initUrlContent(loadUrlFromIntent())
    }

    private fun loadUrlFromIntent(): String {
        return intent.getStringExtra(EXTRA_URL) ?: DEFAULT_URL
    }

    private fun initUrlContent(urlString: String) {
        progress_bar.visibility = View.VISIBLE
        wv_content.settings.javaScriptEnabled = true
        wv_content.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
                view.loadUrl(urlString)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progress_bar.visibility = View.GONE
            }
        }
        wv_content.loadUrl(urlString)
    }

    // handle the webview backstack
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KEYCODE_BACK && wv_content.canGoBack()) {
            wv_content.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
