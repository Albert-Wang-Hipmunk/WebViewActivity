package com.example.mooqoo.webviewactivity

import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*
import android.webkit.WebView
import android.widget.ProgressBar
import android.view.KeyEvent.KEYCODE_BACK





class WebViewActivity : AppCompatActivity() {
    // url to test
    val url = "https://www.hipmunk.com/hotelbook/1560373197.3.eJxdU9Fu4yAQ_JXKD3662GAcx4kUnaI2Uqpre1WTPiMC6wQVA8K4bXS6fz9wXCXXN3sYZnd2hz_J0XhQ1EqRLG4SXNeIFCj5cZMI6YD7ADZMdRAA3jsHmp8i73V7FznMSro35o3tFVwxz1pTgXA143M8JYyTshD1tK5npIwXdd9SwU5d4OHx99BD5yNQxFpKgvb-ZKNswrRwRoobbVzLVLyv2B5UPFp_WhCSRcwq5pvAuLoR4XdwnTQ6onWGUUYiKDvaAXP8SMMNuu87qaGLxb3rowPrzLsU4L6VcPAuR7GCzCJgTNtRBU0clO6VGs0M-GjOOsmjjQIXGZ5Hc0fgb1QOLRUIzyeomuAi6p93MY4PzTlCDa8qELwuqwqjEvGSJ1ftBSoMMnDp8axuev-f_OBaG007poB-tTR2_Cb1UHIoPxBZC9-sK6YPPTsMcKgZkN4NGzh6b7tFnn98fGRjGxk3bX4w-aCXnwedW6k1iHxMWH4xfvkkP33I4RKnT327Er3yeFmkrbNLlPJjOCBlzTk09YQRAZNyDvVkXqNmgpq9aKYC-JQ1KbCoMSsJmkadl7CJoNhyz5ekSh3zEIKiA6UgBS6rosa0KNOvcC9DstPoNfaBCIkST_Jw9F0Qebx7vr2_C5Tscb1bZZv758fXp1_Zdr16ud28rLevD7tttvm9Wz-krbDCq-Vm95Bdvalh7lQb6tlnTEeNMoQC3pq9VPAtuCGjzNpLJseHeln91eIXV0W46bV3J2pNd36qyd9_sGUtyA.ySvl5fJPFUb8HP1SPzYiflzNYdIfDC12KtNSfjRavgl?user_id=5d013ba79649801ffafa2f0b"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        supportActionBar?.hide()
        initUrlContent(url)
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
