package com.example.madpractical4_20012021009

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.core.view.WindowCompat
import com.example.madpractical4_20012021009.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        var buttonBrowse=findViewById<Button>(R.id.btn_browse)
        buttonBrowse.setOnClickListener{
            val url = findViewById<TextInputEditText>(R.id.input_browse).text
            var url_text = url.toString()
            Intent(Intent.ACTION_VIEW).setData(Uri.parse(url_text)).apply { startActivity(this) }
        }

        var buttonCall = findViewById<Button>(R.id.btn_call)
        buttonCall.setOnClickListener{
            var number = findViewById<TextInputEditText>(R.id.input_call).text
            var number_text = "tel: $number"
            Intent(Intent.ACTION_DIAL).setData(Uri.parse(number_text)).apply { startActivity(this) }
        }

        var buttonContact = findViewById<Button>(R.id.btn_contact)
        buttonContact.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).apply { startActivity(this) }
        }

        var buttonCallLog = findViewById<Button>(R.id.btn_calllog)
        buttonCallLog.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply { startActivity(this) }
        }

        var buttonGallery = findViewById<Button>(R.id.btn_gallery)
        buttonGallery.setOnClickListener{
            Intent(Intent.ACTION_VIEW).setType("image/*").apply { startActivity(this) }
        }
        var buttonCamera = findViewById<Button>(R.id.btn_camera)
        buttonCamera.setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply { startActivity(this) }
        }
        var buttonAlarm = findViewById<Button>(R.id.btn_alarm)
        buttonAlarm.setOnClickListener{
            Intent(AlarmClock.ACTION_SHOW_ALARMS).apply { startActivity(this) }
        }
    }
}