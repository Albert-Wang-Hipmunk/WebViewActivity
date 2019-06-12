package com.example.mooqoo.webviewactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "WebViewTest"
    var counter: Int = 0
    val testUrl = "https://www.hipmunk.com/hotelbook/1560373197.3.eJxdU9Fu4yAQ_JXKD3662GAcx4kUnaI2Uqpre1WTPiMC6wQVA8K4bXS6fz9wXCXXN3sYZnd2hz_J0XhQ1EqRLG4SXNeIFCj5cZMI6YD7ADZMdRAA3jsHmp8i73V7FznMSro35o3tFVwxz1pTgXA143M8JYyTshD1tK5npIwXdd9SwU5d4OHx99BD5yNQxFpKgvb-ZKNswrRwRoobbVzLVLyv2B5UPFp_WhCSRcwq5pvAuLoR4XdwnTQ6onWGUUYiKDvaAXP8SMMNuu87qaGLxb3rowPrzLsU4L6VcPAuR7GCzCJgTNtRBU0clO6VGs0M-GjOOsmjjQIXGZ5Hc0fgb1QOLRUIzyeomuAi6p93MY4PzTlCDa8qELwuqwqjEvGSJ1ftBSoMMnDp8axuev-f_OBaG007poB-tTR2_Cb1UHIoPxBZC9-sK6YPPTsMcKgZkN4NGzh6b7tFnn98fGRjGxk3bX4w-aCXnwedW6k1iHxMWH4xfvkkP33I4RKnT327Er3yeFmkrbNLlPJjOCBlzTk09YQRAZNyDvVkXqNmgpq9aKYC-JQ1KbCoMSsJmkadl7CJoNhyz5ekSh3zEIKiA6UgBS6rosa0KNOvcC9DstPoNfaBCIkST_Jw9F0Qebx7vr2_C5Tscb1bZZv758fXp1_Zdr16ud28rLevD7tttvm9Wz-krbDCq-Vm95Bdvalh7lQb6tlnTEeNMoQC3pq9VPAtuCGjzNpLJseHeln91eIXV0W46bV3J2pNd36qyd9_sGUtyA.ySvl5fJPFUb8HP1SPzYiflzNYdIfDC12KtNSfjRavgl?user_id=5d013ba79649801ffafa2f0b"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { onFabClicked() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onFabClicked(url: String = testUrl) {
        when(counter % 2) {
            0 -> { openWebActivity(url) }
            1 -> { openExternalBrowser(url) }
        }
        counter++
    }

    private fun openWebActivity(url: String) {
        Log.d(TAG, "openWebActivity: is called")

        val activityIntent = Intent(this, WebViewActivity::class.java)
        activityIntent.putExtra(WebViewActivity.EXTRA_URL, url)
        startActivity(activityIntent)
    }

    private fun openExternalBrowser(url: String) {
        Log.d(TAG, "openExternalBrowser: is called")

        val externalIntent = Intent(Intent.ACTION_VIEW)
        externalIntent.data = Uri.parse(url)
        startActivity(externalIntent)
    }
}
