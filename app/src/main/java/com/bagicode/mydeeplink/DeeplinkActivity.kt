package com.bagicode.mydeeplink

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DeeplinkActivity : AppCompatActivity() {
    lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink)

        textView = findViewById(R.id.textView)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        val appLinkAction = intent?.action
        val appLinkData = intent?.data
        showDataDeeplink(appLinkAction, appLinkData )
    }

    private fun showDataDeeplink(appLinkAction: String?, appLinkData: Uri?) {

        val code = appLinkData?.getQueryParameter("code")
        if (Intent.ACTION_VIEW == appLinkAction && appLinkData!= null) {
            textView.setText("Data ${code}")
        } else {
            textView.setText("Nothing Data")
        }
    }
}