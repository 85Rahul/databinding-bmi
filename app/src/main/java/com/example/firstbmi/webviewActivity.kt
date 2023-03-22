package com.example.firstbmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.isGone
import com.example.firstbmi.databinding.ActivityContectBinding
import com.example.firstbmi.databinding.ActivityWebviewBinding



class webviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.webViewClient = mywebviewclient()

        binding.webView.loadUrl("https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/index.html")
    }

    inner class mywebviewclient: WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility = View.GONE
        }

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            Log.d("TAG", "shouldOverrideUrlLoading: "+request?.url)
            return super.shouldOverrideUrlLoading(view, request)
        }
    }
}