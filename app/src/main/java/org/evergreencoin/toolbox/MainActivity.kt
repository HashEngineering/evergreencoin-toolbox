package org.evergreencoin.toolbox

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import org.evergreencoin.toolbox.customtabs.CustomTabActivityHelper;

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setTitle(R.string.actionbar_title)

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

    private fun startPage(url : String) {
        val builder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        val toolbarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        val customTabsIntent: CustomTabsIntent = builder.setShowTitle(true)
            .setToolbarColor(toolbarColor).build()

        CustomTabActivityHelper.openCustomTab(this, customTabsIntent, Uri.parse(url)
        ) { _, _ ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }



}
