package com.prussian_trooper.tabledenunsionskotlin.learn_project.account

import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.prussian_trooper.tabledenunsionskotlin.learn_project.MainActivity
import com.prussian_trooper.tabledenunsionskotlin.learn_project.R

class AccountHelper(act:MainActivity) {
    private val act = act
    fun signUpWithEmail(email:String, password:String){
    if (email.isNotEmpty() && password.isNotEmpty()){
        act.myAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{task ->
            //зачем task. По нему мы хотим узнать
            if(task.isSuccessful){
                sendEmailVerification(task.result?.user!!)
            }else{
                Toast.makeText(act, act.resources.getString(R.string.sign_up_error), Toast.LENGTH_SHORT).show()
            }

        }
        /*addOnCompleteListener() - слушатель, который объявляет об успешной регистрации либо о неудачной попытке*/
    }
  }
    //отправка письма для финальной регистрации
    private fun sendEmailVerification(user:FirebaseUser) {
        user.sendEmailVerification().addOnCompleteListener{task ->
            if (task.isSuccessful) {
                Toast.makeText(act, act.resources.getString(R.string.send_verification_email_done), Toast.LENGTH_SHORT).show()
//Временный тост, потом поставить смс ""на вашу почту была отправленна ссылка с подтверждением
            }else{
                Toast.makeText(act, act.resources.getString(R.string.send_verification_email_error), Toast.LENGTH_SHORT).show()

            }
        }
    }
}