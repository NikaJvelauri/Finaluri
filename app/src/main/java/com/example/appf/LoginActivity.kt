package com.example.appf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var forgotPwdTextView: TextView
    private lateinit var signInButton: Button
    private lateinit var goBackButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        emailEditText = findViewById(R.id.loginmailText)
        passwordEditText = findViewById(R.id.loginpassText)
        forgotPwdTextView = findViewById(R.id.forgotPwdTextView)
        signInButton = findViewById(R.id.signInPageButton)
        goBackButton = findViewById(R.id.backB)
        auth = FirebaseAuth.getInstance()
        supportActionBar?.hide()
        goBackButton.setOnClickListener {
            finish()
        }

        forgotPwdTextView.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        signInButton.setOnClickListener {
            val email: String = emailEditText.text.toString()
            val password: String = passwordEditText.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                Toast.makeText(this, "გთხოვთ შეავსოთ ყველა ველი", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "Authentification failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}