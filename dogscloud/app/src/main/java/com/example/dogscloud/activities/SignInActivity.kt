package com.example.dogscloud.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dogscloud.R

class SignInActivity : AppCompatActivity() {

    var botonGoToSingUp: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        botonGoToSingUp = findViewById(R.id.buttonNewAcccount)

        botonGoToSingUp?.setOnClickListener{
            goToSignUp()
        }
    }

    private fun goToSignUp(){
        val i = Intent(this,SignUpActivity::class.java)
        startActivity(i)
    }
}