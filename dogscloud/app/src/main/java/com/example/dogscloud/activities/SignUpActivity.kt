package com.example.dogscloud.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dogscloud.R

class SignUpActivity : AppCompatActivity() {

    var botonGoToSingIn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        botonGoToSingIn = findViewById(R.id.buttonLogIn)

        botonGoToSingIn?.setOnClickListener{
            goToSignIn()
        }
    }

    private fun goToSignIn(){
        val i = Intent(this,SignInActivity::class.java)
        startActivity(i)
    }
}