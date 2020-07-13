package com.reshmaakhil.native_player


import android.content.Intent
import android.os.Bundle

import io.flutter.app.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity : FlutterActivity() {
    companion object {
        const val CHANNEL = "sample"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegistrant.registerWith(FlutterEngine(this))
        MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, _ ->
            if (call.method == "showNativeView") {
                val intent = Intent(this, PlayerActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
