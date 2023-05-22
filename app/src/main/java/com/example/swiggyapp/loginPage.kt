package com.example.swiggyapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.TextView

class loginPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val forgotpass=findViewById<TextView>(R.id.txtFP)


        val loginButton=findViewById<TextView>(R.id.btnLogin)

        forgotpass.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            if (validate()) {
                val intent=Intent(this,ProductList::class.java)
                startActivity(intent)
            }
        }



    }
    private fun validate(): Boolean {
        var isValid = true
        val userEmail=findViewById<TextView>(R.id.etEmail)
        val userPass=findViewById<TextView>(R.id.etPass)
        val email = userEmail.text.toString()
        val password = userPass.text.toString()

        if (TextUtils.isEmpty(email)) {
            userEmail.error = "Email is required"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            userEmail.error = "Invalid email format"
            isValid = false
        }

        if (TextUtils.isEmpty(password)) {
            userPass.error = "Password is required"
            isValid = false
        } else if (password.length < 6) {
            userPass.error = "Password must be at least 6 characters long"
            isValid = false
        }

        return isValid
    }





}