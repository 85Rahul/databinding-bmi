package com.example.firstbmi

import android.os.Binder
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.firstbmi.databinding.ActivityContectBinding

class contect_Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityContectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContectBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnDial.setOnClickListener(this)
        binding.call.setOnClickListener(this)
        binding.email.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_dial -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9690333885"))
                startActivity(intent)
            }

            R.id.call -> {

                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:85339199194")
                    startActivity(intent)
                } else {
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1001)
                }

            }

            R.id.email->{
                val intent=Intent(Intent.ACTION_SENDTO).apply {
                    data=Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("rahulparihar853391@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT,"Hello  Friends   I hope you are well-in good ")
                }
                startActivity(intent)

            }
        }
    }
}