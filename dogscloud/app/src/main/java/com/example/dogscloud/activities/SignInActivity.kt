package com.example.dogscloud.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dogscloud.R



class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val boton = findViewById<Button>(R.id.buttonNewAcccount)
        boton.setOnClickListener{

            val lanzar = Intent(this,SignUpActivity::class.java)
            startActivity(lanzar)

        }

    }


}