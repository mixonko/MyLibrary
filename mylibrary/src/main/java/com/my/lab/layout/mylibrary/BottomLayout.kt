package com.my.lab.layout.mylibrary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.my.lab.layout.mylibrary.Loser.or
import com.my.lab.layout.mylibrary.Winner.nor

class BottomLayout{
    interface startGame{
        fun start(){}
    }

    companion object {
        var appsFlayerData: Map<String, Any>? = null
         var text: String? = null
        var afID = ""
        var flag = ""
        var newText = ""

        fun check(start: startGame, appCompatActivity: AppCompatActivity, context: Context) {
            if (!appsFlayerData.isNullOrEmpty() && !text.isNullOrEmpty()) {
                var checkStatus = appsFlayerData?.get("af_status").toString()

                if (checkStatus == "Non-organic") {
                    newText = nor(appsFlayerData, afID, text!!)
                } else if (checkStatus == "Organic" && flag == "true") {
                    newText = or(text!!, afID )

                } else if (checkStatus == "Organic" && flag == "false") {
                    start.start()
                }

                if(!newText.isNullOrEmpty()){
                    var f = Intent(appCompatActivity, MyActivity::class.java)
                    appCompatActivity.startActivity(f)

                }
            }
        }
    }
}
