package com.example.ado1

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCheckBoxOptions()
    }

    fun setupCheckBoxOptions() {

        check1!!.setOnClickListener {
            setValueCheckBox(check2, check3, check4)
            showToast(this,"ROXO SELECIONADO")
        }
        check2!!.setOnClickListener {
            setValueCheckBox(check1, check3, check4)
            showToast(this,"VERMELHO SELECIONADO")
        }
        check3!!.setOnClickListener {
            setValueCheckBox(check1, check2, check4)
            showToast(this,"VERDE SELECIONADO")
        }
        check4!!.setOnClickListener {
            setValueCheckBox(check1, check2, check3)
            showToast(this,"AMARELO SELECIONADO")
        }
    }

    fun setValueCheckBox(checkbox1: CheckBox, checkbox2: CheckBox, checkbox3: CheckBox) {
        checkbox1.isChecked = false
        checkbox2.isChecked = false
        checkbox3.isChecked = false
    }
    fun showToast(context:Context,string: String){
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show()
    }
}
