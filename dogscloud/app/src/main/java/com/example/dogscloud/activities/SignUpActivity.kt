package com.example.dogscloud.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dogscloud.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val boton = findViewById<Button>(R.id.buttonLogIn)
        boton.setOnClickListener{

            val lanzar = Intent(this,SignInActivity::class.java)
            startActivity(lanzar)

        }
    }
}