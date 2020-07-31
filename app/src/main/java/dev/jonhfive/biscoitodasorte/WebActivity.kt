package dev.jonhfive.biscoitodasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        wbView.settings.javaScriptEnabled = true
        wbView.loadUrl("https://sadanduseless.b-cdn.net/wp-content/uploads/2019/06/cat-breading7.jpg")
        wbView.webViewClient = WebViewClient()

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 5000)
    }
}