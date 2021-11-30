package com.prussian_trooper.tabledenunsionskotlin.learn_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.prussian_trooper.tabledenunsionskotlin.learn_project.databinding.ActivityMainBinding
import com.prussian_trooper.tabledenunsionskotlin.learn_project.dialogs.DialogConst
import com.prussian_trooper.tabledenunsionskotlin.learn_project.dialogs.DialogHelper


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var rootElement: ActivityMainBinding
    private val dialogHelper = DialogHelper(this)//Инициализация класса DialogHelper
    val myAuth = FirebaseAuth.getInstance()

/*lateinit - инициализация init later*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityMainBinding.inflate(layoutInflater)
        val view = rootElement.root
        setContentView(view)/*Вывод основного контейнера с инф-й на экран*/
        init()
    }
/* убрали плагин kotlin-android-extensions*/
     private fun init(){
        val toogle = ActionBarDrawerToggle(this, rootElement.drawerLayout, rootElement.mainContent.toolbar, R.string.open, R.string.close)
        rootElement.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        rootElement.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_my_ads -> {

       /*Проверка работаспособности*/
                Toast.makeText(this, "Pressed id_my_ads", Toast.LENGTH_LONG).show()
            }
            R.id.id_car -> {
                Toast.makeText(this, "Pressed id_car", Toast.LENGTH_LONG).show()
            }

            R.id.id_pc -> {
                Toast.makeText(this, "Pressed id_pc", Toast.LENGTH_LONG).show()
            }

            R.id.id_smart -> {
                Toast.makeText(this, "Pressed id_smart", Toast.LENGTH_LONG).show()
            }

            R.id.id_dm -> {
                Toast.makeText(this, "Pressed id_dm", Toast.LENGTH_LONG).show()
            }
            /*Вход для регистрации*/
            R.id.id_sign_up -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)
            }
            /*Вход для входа :) */
            R.id.id_sing_in -> {
                dialogHelper.createSignDialog(DialogConst.SIGN_IN_STATE)
            }

            R.id.id_sign_out -> {
                Toast.makeText(this, "Pressed id_sign_out", Toast.LENGTH_LONG).show()
            }
        }
        rootElement.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}