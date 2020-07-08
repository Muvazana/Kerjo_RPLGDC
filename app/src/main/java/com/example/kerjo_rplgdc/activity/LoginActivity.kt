package com.example.kerjo_rplgdc.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.kerjo_rplgdc.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ValidateTextInput()
        btnLogin.setOnClickListener {
            if (!ValidateEmail() || !ValidatePassword()) {
                return@setOnClickListener
            }
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisActivity::class.java)
            intent.putExtra("txtEmail", txtInputEmail.editText?.text.toString())
            startActivity(intent)
        }
    }

    private fun ValidateEmail(): Boolean {
        var txtinput = txtInputEmail.editText?.text.toString()
        if (txtinput.isEmpty()) {
            txtInputEmail.error = "Field can't be empty"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(txtinput).matches()) {
            txtInputEmail.error = "Please enter a valid email address"
            return false
        } else {
            txtInputEmail.error = null
            return true
        }
    }

    private fun ValidatePassword(): Boolean {
        var txtinput = txtInputPassword.editText?.text.toString()
        if (txtinput.isEmpty()) {
            txtInputPassword.error = "Field can't be empty"
            return false
        } else {
            txtInputPassword.error = null
            return true
        }
    }

    private fun ValidateTextInput() {
        txtInputEmail.editText?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isEmpty()) {
                    txtInputEmail.error = "Field can't be empty"
                } else if (!Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    txtInputEmail.error = "Please enter a valid email address"
                } else {
                    txtInputEmail.error = null
                }
            }
        })
        txtInputPassword.editText?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isEmpty()) {
                    txtInputPassword.error = "Field can't be empty"
                } else {
                    txtInputPassword.error = null
                }
            }
        })
    }
}
