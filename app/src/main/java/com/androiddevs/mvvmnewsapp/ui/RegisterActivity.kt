package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.androiddevs.mvvmnewsapp.R
import kotlinx.android.synthetic.main.activity_signup.*

class RegisterActivity : Fragment(){

    private lateinit var emailName: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_signup, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var controller = findNavController()

        goTologin.setOnClickListener {
            controller.navigate(R.id.loginActivity)
        }
    }
}