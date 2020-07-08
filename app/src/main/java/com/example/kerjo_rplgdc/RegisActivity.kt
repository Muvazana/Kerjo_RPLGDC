package com.example.kerjo_rplgdc

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_regis.*

class RegisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regis)
        txtInputEmail.editText!!.setText(intent.getStringExtra("Email"))
        CheckInputUser()
        btnRegister.setOnClickListener {
            if (!ValidateEmail() || !ValidatePassword()) {
                return@setOnClickListener
                //TODO Create Process Background Registration to database
                //TODO Create PopUp Email Verification Success or NOT
            }
        }
    }

    private fun ValidateEmail(): Boolean {
        var txtInput = txtInputEmail.editText?.text.toString()

        if (txtInput.isEmpty()) {
            txtInputEmail.error = "Field can't be empty"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(txtInput).matches()) {
            txtInputEmail.error = "Please enter a valid email address"
            return false
        } else {
            txtInputEmail.error = null
            return true
        }
    }

    private fun ValidatePassword(): Boolean {
        var txtInput1 = txtInputPassword1.editText?.text.toString()
        var txtInput2 = txtInputPassword2.editText?.text.toString()
        var valid = true

        if (txtInput1.isEmpty()) {
            txtInputPassword1.error = "Field can't be empty"
            valid = false
        } else {
            txtInputPassword1.error = null
        }

        if (txtInput2.isEmpty()) {
            txtInputPassword2.error = "Field can't be empty"
            valid = false
        } else {
            txtInputPassword2.error = null
        }

        if (txtInput1 != txtInput2) {
            txtInputPassword2.error = "Password not match"
            valid = false
        }

        return valid
    }

    private fun CheckInputUser() {


        txtInputEmail.editText?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
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
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isEmpty()) {
                    txtInputPassword1.error = "Field can't be empty"
                } else if (s != txtInputPassword2.editText?.text.toString()) {
                    txtInputPassword1.error = "Password not match"
                    txtInputPassword2.error = "Password not match"
                } else {
                    txtInputPassword1.error = null
                }
            }
        })
        txtInputPassword2.editText?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (s.toString() == txtInputPassword1.editText?.text.toString()) {
                    txtInputPassword1.error = null
                    txtInputPassword2.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.isEmpty()) {
                    txtInputPassword2.error = "Field can't be empty"
                } else if (s != txtInputPassword1.editText?.text.toString()) {
                    txtInputPassword1.error = "Password not match"
                    txtInputPassword2.error = "Password not match"
                } else {
                    txtInputPassword2.error = null
                }
            }
        })
    }

    fun onRadioButtonChecked(view: View) {
        if (rbReqruiter.isChecked) {
            rbReqruiter.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
            rbSeeker.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        } else {
            rbReqruiter.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
            rbSeeker.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        }
    }
}
