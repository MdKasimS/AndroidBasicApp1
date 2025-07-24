package com.mdkasims.androidbasicapp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val signIn = findViewById<TextView>(R.id.txtSignIn)
        val input = findViewById<EditText>(R.id.editEmail)
        val pwd = findViewById<EditText>(R.id.editPassword)
        val loginBtn = findViewById<Button>(R.id.btnLoginSignUp)
        val signUp = findViewById<TextView>(R.id.txtSignUp)
        val forgotPassword = findViewById<TextView>(R.id.txtForgotPwd)
        val userName = findViewById<EditText>(R.id.editUserName)
        val verifyPassword = findViewById<EditText>(R.id.editVerifyPassword)

        signUp.setOnClickListener {
            println("Sign Up was clicked")
            userName.isVisible = true
            verifyPassword.isVisible = true
            signIn.isVisible = true

            forgotPassword.isVisible = false
            signUp.isVisible = false
            loginBtn.text = "Sign Up"
        }

        signIn.setOnClickListener {
            println("Sign Up was clicked")
            userName.isVisible = false
            verifyPassword.isVisible = false
            signIn.isVisible = false

            forgotPassword.isVisible = true
            signUp.isVisible = true
            loginBtn.text = "Sign In"

        }

        forgotPassword.setOnClickListener {
            println("Forgot Password was clicked")


        }

        loginBtn.setOnClickListener {
            val enteredEmail = input.text.toString()
            println(enteredEmail)
            println()
        }
    }
}