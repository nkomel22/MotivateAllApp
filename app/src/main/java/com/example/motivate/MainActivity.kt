package com.example.motivate

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var iptxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener{updateMessage()}


        name = findViewById(R.id.edtname)
        iptxt = findViewById(R.id.txt)


    }
    private fun updateMessage() {
        val uname = name.text
        val msg = listOf("Try and try until you succeed", "Never Give Up", "Keep your head up", "Nothing is impossible. The word itself says 'I'm possible!", "Keep your face always toward the sunshine, and shadows will fall behind you")
        val num = (0..4).random()
        val curmsg = msg[num]
        if(uname.toString() == ""){
            iptxt.text = "Please enter your name"
        }
        else {
            iptxt.text = "Hey $uname! $curmsg"

        }
        name.setText("")
        hidekeyboard()


    }
    private fun hidekeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken, 0)
    }
}