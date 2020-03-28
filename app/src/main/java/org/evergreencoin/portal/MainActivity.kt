package org.evergreencoin.portal

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        poe_submit.setOnClickListener {
            startPage("http://evergreencoin.org/poe-submit")
        }

        poe_scoring.setOnClickListener {
            startPage("http://evergreencoin.org/poe-scoring")
        }

        web_wallet.setOnClickListener {
            startPage("http://webwallet.evergreencoin.org/")
        }

        reward_center.setOnClickListener {
            startPage("http://evergreencoin.org/reward-center")
        }
    }

    fun startPage(url : String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }



}
