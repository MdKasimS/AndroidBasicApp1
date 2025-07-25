package com.mdkasims.androidbasicapp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.mdkasims.androidbasicapp1.databinding.ActivityHomeBinding
import com.mdkasims.androidbasicapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var emails = mutableListOf<String>();
    var passwords = mutableListOf<String>();

    private lateinit var signIn: TextView
    private lateinit var email: EditText
    private lateinit var pwd: EditText
    private lateinit var loginBtn: Button
    private lateinit var signUp: TextView
    private lateinit var forgotPassword: TextView
    private lateinit var userName: EditText
    private lateinit var verifyPassword: EditText

    private fun initViews() {
        signIn = findViewById(R.id.txtSignIn)
        email = findViewById(R.id.editEmail)
        pwd = findViewById(R.id.editPassword)
        loginBtn = findViewById(R.id.btnLoginSignUp)
        signUp = findViewById(R.id.txtSignUp)
        forgotPassword = findViewById(R.id.txtForgotPwd)
        userName = findViewById(R.id.editUserName)
        verifyPassword = findViewById(R.id.editVerifyPassword)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)
//        var binding = ActivityHomeBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        initViews()

        signUp.setOnClickListener {
            toggleSignUp()
        }

        signIn.setOnClickListener {
            toggleSignIn()
        }

        forgotPassword.setOnClickListener {
            println("Forgot Password was clicked")

        }

        loginBtn.setOnClickListener {
            val enteredEmail = email.text.toString()
            println(enteredEmail)
            if(loginBtn.text.toString().equals("Login"))
            {
                println("I will perform Login!")
                performSignIn()
            }
            else
            {
                println("I will perform Sign Up")
                performSignUp()
            }
        }
    }

    fun performSignUp()
    {
        emails.add(email.text.toString())
        passwords.add(pwd.text.toString())

        Toast.makeText(this@MainActivity
                        ,"Signed Up Successfully"
                        ,Toast.LENGTH_SHORT).show()

        toggleSignIn()
    }

    fun performSignIn()
    {
        var isAuthenticated = false

        isAuthenticated = emails.contains(email.text.toString()) && passwords.contains(pwd.text.toString())
        if(isAuthenticated)
        {
            Toast.makeText(this@MainActivity
                ,"Signed In Successfully"
                ,Toast.LENGTH_SHORT).show()

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
//            toggleSignIn()
        }
        else
        {
            Toast.makeText(this@MainActivity
                ,"Invalid Credentials"
                ,Toast.LENGTH_SHORT).show()
        }

    }

    fun toggleSignUp()
    {
        println("Sign Up was clicked")
        userName.isVisible = true
        verifyPassword.isVisible = true
        signIn.isVisible = true

        forgotPassword.isVisible = false
        signUp.isVisible = false
        loginBtn.text = "Sign Up"
    }

    fun toggleSignIn()
    {
        println("Sign In was clicked")
        userName.isVisible = false
        verifyPassword.isVisible = false
        signIn.isVisible = false

        forgotPassword.isVisible = true
        signUp.isVisible = true
        loginBtn.text = "Login"
    }

}