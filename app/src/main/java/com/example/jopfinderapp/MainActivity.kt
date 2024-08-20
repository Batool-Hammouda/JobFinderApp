package com.example.jopfinderapp

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var signIn: Button? = null
    private var email: EditText? = null
    private var password:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filledIcon: ImageView = findViewById(R.id.filledIcon)
        val welcome: TextView = findViewById(R.id.welcomeMessage)
        val happyMessage: TextView = findViewById(R.id.happyMessage)
        val forgotPassword: TextView = findViewById(R.id.forgotPassword)
        val askForAccount: TextView = findViewById(R.id.askAboutAccount)
        val createAccount: TextView = findViewById(R.id.createAccount)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signIn = findViewById(R.id.signIn)

        signIn?.isEnabled=false

        email?.addTextChangedListener(textWatcher)
        password?.addTextChangedListener(textWatcher)

        signIn?.setOnClickListener {
            //next branch this button will open the next activity
            Toast.makeText(this,"signed in",Toast.LENGTH_SHORT).show()
        }


        forgotPassword.setOnClickListener{
            Toast.makeText(this,"forgot password ", Toast.LENGTH_SHORT).show()
        }

        createAccount.setOnClickListener{
            Toast.makeText(this," want to create new account ", Toast.LENGTH_SHORT).show()
        }


    }

    private val textWatcher=object: TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if((email?.text.toString()).isNotEmpty() && (password?.text.toString()).isNotEmpty()){
                signIn?.isEnabled=true
                signIn?.setBackgroundColor(Color.parseColor("#475BD8"))
                signIn?.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }
}