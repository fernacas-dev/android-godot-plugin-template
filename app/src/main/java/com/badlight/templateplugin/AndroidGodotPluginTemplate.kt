package com.badlight.templateplugin

import android.telephony.SmsManager
import android.util.Log
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin


class AndroidGodotPluginTemplate(godot: Godot) : GodotPlugin(godot) {

    override fun getPluginName(): String {
        return "AndroidGodotPluginTemplate"
    }
    override fun getPluginMethods(): List<String> {
        return listOf(
            "getHelloWorldNative",
            "sendSms"
        )
    }
    fun getHelloWorldNative(): String {
        return "Hello World from Android"
    }

    fun sendSms(number: String, message: String): String? {
        return try{
            val smsManager = SmsManager.getDefault() as SmsManager
            smsManager.sendTextMessage(number, null, message, null, null)
            "Ok"
        }catch(exp: Exception){
            exp.message?.toString()
        }
    }
}