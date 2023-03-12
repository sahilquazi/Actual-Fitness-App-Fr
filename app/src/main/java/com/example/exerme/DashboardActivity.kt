package com.example.exerme

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val buttonCalendar = findViewById<Button>(R.id.calendarButton)
        buttonCalendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)











            @SuppressLint("SetJavaScriptEnabled")
            class WebViewActivity : AppCompatActivity() {

                private lateinit var webView: WebView


                class CustomChromeClient : WebChromeClient() {
                    private var mCustomView: View? = null
                    private var mCustomViewCallback: CustomViewCallback? = null
                    private var mOriginalOrientation = 0
                    private var mOriginalSystemUiVisibility = 0
                    override fun getDefaultVideoPoster(): Bitmap? {
                        return if (mCustomView == null) {
                            null
                        } else BitmapFactory.decodeResource(applicationContext.resources, 2130837573)
                    }

                    override fun onHideCustomView() {
                        (window.decorView as FrameLayout).removeView(mCustomView)
                        mCustomView = null
                        window.decorView.systemUiVisibility = mOriginalSystemUiVisibility
                        requestedOrientation = mOriginalOrientation
                        mCustomViewCallback!!.onCustomViewHidden()
                        mCustomViewCallback = null
                    }

                    override fun onShowCustomView(
                        paramView: View?,
                        paramCustomViewCallback: CustomViewCallback?
                    ) {
                        if (mCustomView != null) {
                            onHideCustomView()
                            return
                        }
                        mCustomView = paramView
                        mOriginalSystemUiVisibility = window.decorView.systemUiVisibility
                        mOriginalOrientation = requestedOrientation
                        mCustomViewCallback = paramCustomViewCallback
                        (window.decorView as FrameLayout).addView(mCustomView, FrameLayout.LayoutParams(-1, -1))
                        window.decorView.systemUiVisibility = 3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    }
                }
                    fun onSaveInstanceState(outState: Bundle) {
                    super.onSaveInstanceState(outState)
                    webView.saveState(outState)
                }

                    fun onRestoreInstanceState(savedInstanceState: Bundle) {
                    super.onRestoreInstanceState(savedInstanceState)
                    webView.restoreState(savedInstanceState)
                }
            }
        }
    }
        }