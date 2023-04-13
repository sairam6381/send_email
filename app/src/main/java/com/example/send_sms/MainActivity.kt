package com.example.send_sms

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Sms
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPhno:EditText =findViewById(R.id.Phno)
        val etmsg :EditText=findViewById(R.id.msg)
        val btsend: Button = findViewById(R.id.button)


        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.SEND_SMS),10)

        btsend.setOnClickListener{
            var message=etmsg.text.toString()
            var phoneno=etPhno.text.toString()

            val smsManager:SmsManager
            smsManager=SmsManager.getDefault()
            smsManager.sendTextMessage(phoneno,null,message,null,null)

            Toast.makeText(applicationContext, "SMS Sent", Toast.LENGTH_SHORT).show()
            etmsg.setText("");
            etPhno.setText("");


        }





    }
}