package com.example.kerjo_rplgdc.activity

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.kerjo_rplgdc.R
import kotlinx.android.synthetic.main.activity_regis.*

class RegisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regis)
        ValidateTextInput()
        btnRegister.setOnClickListener {
            if (!ValidateEmail() || !ValidatePassword()) {
                return@setOnClickListener
            }
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
        var txtinput1 = txtInputPassword1.editText?.text.toString()
        var txtinput2 = txtInputPassword2.editText?.text.toString()
        var valid = true
        if (txtinput1.isEmpty()) {
            txtInputPassword1.error = "Field can't be empty"
            valid = false
        } else if (txtinput1 != txtinput2 && txtinput2 != null) {
            txtInputPassword1.error = "Password not match"
            txtInputPassword2.error = "Password not match"
            valid = false
        } else {
            txtInputEmail.error = null
            return true
        }


        return valid
    }

    private fun ValidateTextInput() {
        txtInputEmail.editText?.setText(intent.getStringExtra("txtEmail"))
    }
}
