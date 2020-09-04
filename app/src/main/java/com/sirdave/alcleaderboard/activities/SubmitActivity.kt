package com.sirdave.alcleaderboard.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.sirdave.alcleaderboard.R

class SubmitActivity : AppCompatActivity() {
    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var email : EditText
    private lateinit var project_link : EditText
    private lateinit var submit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        email = findViewById(R.id.emailAddress)
        project_link = findViewById(R.id.project_link)
        submit = findViewById(R.id.submit_project)

        submit.setOnClickListener {
            hideSoftKeyboard()
            checkFields()
        }
    }

    private fun checkFields(){
        if (!IsEmpty(firstName.text.toString()) && !IsEmpty(lastName.text.toString())
            && !IsEmpty(email.text.toString()) && !IsEmpty(project_link.text.toString())) {

            //Do the submission

        }

    }

    private fun IsEmpty(text: String): Boolean{
        return text.equals("")
    }

    private fun hideSoftKeyboard() {
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}
