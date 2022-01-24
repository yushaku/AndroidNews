package com.androiddevs.mvvmnewsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.activity_signup.*
import android.content.Intent
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast


class LoginActivity : AppCompatActivity() {

    private lateinit var emailName: EditText
    private lateinit var password: EditText

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.activity_login, container, false)
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        var controller = findNavController();
//
//        loginBtn.setOnClickListener {
//            controller.navigate(R.id.home);
//        }
//
//        gotoSignUp.setOnClickListener {
//            controller.navigate(R.id.regiserActivity)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //-----------------------------------------------------------------------------------


        var listLogin = arrayOf(
            Account("son@gmail.com","1"),
            Account("hieu@gmail.com","1"),
            Account("bach@gmail.com","1")
        )

        loginBtn.setOnClickListener {

            if( validateLogin() == true){
                var loginInfo = Account(email_login.text.toString(),pass_login.text.toString());
                if(loginInfo in listLogin ){
                    val intent = Intent(this, NewsActivity::class.java);
                    startActivity(intent)
                }
                else {
                    val toast = Toast.makeText(applicationContext, "Vui lòng check lại thông tin đăng nhập", Toast.LENGTH_LONG)
                    toast.show()
                }
            }


        }

        gotoSignUp.setOnClickListener {
            setContentView(R.layout.activity_signup);
        }
    }

    fun validateLogin(): Boolean {
        if (TextUtils.isEmpty(email_login.text.toString())) {
            val toast = Toast.makeText(applicationContext, "email không được để trống", Toast.LENGTH_LONG)
            toast.show()
            return false
        }
        if (TextUtils.isEmpty(pass_login.text.toString())) {
            val toast = Toast.makeText(applicationContext, "password không được để trống", Toast.LENGTH_LONG)
            toast.show()
            return false
        }
        if(!isValidEmail(email_login.text.toString())){
            val toast = Toast.makeText(applicationContext, "Vui lòng nhập email đúng định dạng", Toast.LENGTH_LONG)
            toast.show()
            return false
        }
        return true;
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    data class Account (val username:String ,val password:String)
}