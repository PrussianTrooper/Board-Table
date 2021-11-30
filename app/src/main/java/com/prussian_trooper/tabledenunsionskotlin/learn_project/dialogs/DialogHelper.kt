package com.prussian_trooper.tabledenunsionskotlin.learn_project.dialogs

import android.app.AlertDialog
import com.prussian_trooper.tabledenunsionskotlin.learn_project.MainActivity
import com.prussian_trooper.tabledenunsionskotlin.learn_project.R
import com.prussian_trooper.tabledenunsionskotlin.learn_project.account.AccountHelper
import com.prussian_trooper.tabledenunsionskotlin.learn_project.databinding.SignDialogBinding

class DialogHelper(act:MainActivity) {
    private val activity = act
    private val accHelper = AccountHelper(act)//объект, с помощью которго мы можем регистрироваться

    fun createSignDialog(index: Int) {
        val builder = AlertDialog.Builder(activity)
        val rootDialogElement = SignDialogBinding.inflate(activity.layoutInflater)
        val view = rootDialogElement.root //rootDialogElement превращается во view(которая стоит после val)

        /* Изменяем текст в sign_dialog */
        if (index == DialogConst.SIGN_UP_STATE) {
            rootDialogElement.tvSignTitle.text = activity.resources.getString(R.string.ac_sign_up)
            rootDialogElement.btnSignUpIn.text = activity.resources.getString(R.string.sign_up_action)
        } else {
            rootDialogElement.tvSignTitle.text = activity.resources.getString(R.string.ac_sign_in)
            rootDialogElement.btnSignUpIn.text = activity.resources.getString(R.string.sign_in_action)
        }
      /*прослушивание нажатия на кнопки*/  rootDialogElement.btnSignUpIn.setOnClickListener{
          if (index == DialogConst.SIGN_UP_STATE){

              accHelper.signUpWithEmail(rootDialogElement.edSignEmail.text.toString(),
                  rootDialogElement.edSignPassword.text.toString())

          } else {
         //сделаю позже
          }
        }
        builder.setView(view)
        builder.show()
    }
}