package com.sirdave.alcleaderboard.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.sirdave.alcleaderboard.R

class SubmitActivity : AppCompatActivity() {
    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var email : EditText
    private lateinit var project_link : EditText
    private lateinit var submit : Button
    private val TAG = "SubmitActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        setAppBarHeight()

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


    private fun setAppBarHeight() {
        val appBarLayout: AppBarLayout = findViewById(R.id.appbar)
        appBarLayout.layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            getStatusBarHeight() + dpToPx(48 + 56)
        )
    }

    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height",
            "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    private fun dpToPx(dp: Int): Int {
        val density = resources
            .displayMetrics
            .density
        return Math.round(dp.toFloat() * density)
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
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            Log.d(TAG, e.message!!)

        }
    }
}
