package com.example.kerjo_rplgdc.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
                //TODO Create Process Registration
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
        var valid: Boolean = true

        txtInputPassword1.error = null
        txtInputPassword2.error = null

        if (txtinput1.isEmpty()) {
            txtInputPassword1.error = "Field can't be empty"
            valid = false
        }

        if (txtinput2.isEmpty()) {
            txtInputPassword2.error = "Field can't be empty"
            valid = false
        }

        if (txtinput1 != txtinput2 && !txtinput1.isEmpty() && !txtinput2.isEmpty()) {
            txtInputPassword1.error = "Password not match"
            txtInputPassword2.error = "Password not match"
            valid = false
        }


        return valid
    }

    private fun ValidateTextInput() {
        txtInputEmail.editText?.setText(intent.getStringExtra("txtEmail"))

        txtInputEmail.editText?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                txtInputPassword1.error = null
                txtInputPassword2.error = null
            }

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
        txtInputPassword1.editText?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (s.toString() == txtInputPassword2.editText?.text.toString()) {
                    txtInputPassword1.error = null
                    txtInputPassword2.error = null
                } else if (s.toString().isEmpty()) {
                    txtInputPassword2.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                txtInputPassword1.error = null
                txtInputPassword2.error = null
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isEmpty()) {
                    txtInputPassword1.error = "Field can't be empty"
                } else if (s != txtInputPassword2.editText?.text.toString() && !s.isEmpty() && !txtInputPassword2.editText?.text.toString()
                        .isEmpty()
                ) {
                    txtInputPassword1.error = "Password not match"
                    txtInputPassword2.error = "Password not match"
                }
            }
        })
        txtInputPassword2.editText?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (s.toString() == txtInputPassword1.editText?.text.toString()) {
                    txtInputPassword1.error = null
                    txtInputPassword2.error = null
                } else if (s.toString().isEmpty()) {
                    txtInputPassword1.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isEmpty()) {
                    txtInputPassword2.error = "Field can't be empty"
                } else if (s != txtInputPassword1.editText?.text.toString() && !s.isEmpty() && !txtInputPassword1.editText?.text.toString()
                        .isEmpty()
                ) {
                    txtInputPassword1.error = "Password not match"
                    txtInputPassword2.error = "Password not match"
                }
            }
        })
    }

    fun onRadioButtonChecked(view: View) {
        if (rbReqruiter.isChecked) {
            rbReqruiter.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
            rbSeeker.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        } else {
            rbReqruiter.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
            rbSeeker.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
        }
    }
}
