package com.sirdave.alcleaderboard.activities

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.AppBarLayout
import com.sirdave.alcleaderboard.R
import com.sirdave.alcleaderboard.core.APIServices
import com.sirdave.alcleaderboard.core.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class SubmitActivity : AppCompatActivity() {
    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var email : EditText
    private lateinit var project_link : EditText
    private lateinit var dialog: Dialog
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
        return (dp.toFloat() * density).roundToInt()
    }

    private fun submitFormDialog(){
        dialog = Dialog(this)
        dialog.setContentView(R.layout.submit_dialog)
        val confirmButton: Button = dialog.findViewById(R.id.confirm_submit_button)
        val cancelButton: ImageButton = dialog.findViewById(R.id.cancel_imageButton)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

        cancelButton.setOnClickListener {
            dialog.cancel()
        }

        confirmButton.setOnClickListener {
            val apiServices = ServiceBuilder().buildService(APIServices::class.java)
            val submitFormRequest = apiServices.submitForm(
                "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse",
                firstName.text.toString(),
                lastName.text.toString(),
                email.text.toString(),
                project_link.text.toString()
            )

            submitFormRequest.enqueue(object: Callback<Void>{
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    showResponseDialog(R.drawable.ic_baseline_warning_24, R.string.submission_failure)
                    Toast.makeText(this@SubmitActivity, t.message, Toast.LENGTH_LONG).show()

                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.d(TAG, "response code is ${response.code()}")
                    if (response.isSuccessful){
                        clearFields()
                        showResponseDialog(R.drawable.ic_baseline_check_24, R.string.submission_success)
                        Toast.makeText(this@SubmitActivity, "response message is ${response.message()}", Toast.LENGTH_LONG).show()
                        Toast.makeText(this@SubmitActivity, "response code is ${response.code()}", Toast.LENGTH_LONG).show()

                    }
                    else{
                        Toast.makeText(this@SubmitActivity, "responseError is ${response.errorBody()}", Toast.LENGTH_LONG).show()
                    }

                }

            })
        }
    }

    private fun showResponseDialog(responseImage: Int, responseText: Int){
        dialog.dismiss()

        dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_response)
        val imageView: ImageView = dialog.findViewById(R.id.response_imageView)
        val textView: TextView = dialog.findViewById(R.id.response_textView)
        imageView.setImageResource(responseImage)
        textView.text = getString(responseText)
        dialog.show()

    }

    private fun checkFields(){
        if (!IsEmpty(firstName.text.toString()) && !IsEmpty(lastName.text.toString())
            && !IsEmpty(email.text.toString()) && !IsEmpty(project_link.text.toString())) {

          submitFormDialog()

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

    private fun clearFields(){
        firstName.setText("")
        lastName.setText("")
        email.setText("")
        project_link.setText("")
    }
}
