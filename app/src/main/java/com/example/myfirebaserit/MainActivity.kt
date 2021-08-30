package com.example.myfirebaserit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnAdd = findViewById<TextView>(R.id.btnAdd)

        btnAdd.setOnClickListener() {

            val student = Student("A123", "Tan Alex")
            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference("Student")

            myRef.child(student.id).setValue(student)
        }


        val btnGet = findViewById<Button>(R.id.btnGEt)

        btnGet.setOnClickListener(){

            val database: FirebaseDatabase = FirebaseDatabase.getInstance()
            val myRef: DatabaseReference = database.getReference("Student")

            myRef.child("A123").get().addOnSuccessListener {

                val name = it.child("name").value.toString()


                Toast.makeText(applicationContext,name, Toast.LENGTH_LONG ).show()


            }.addOnFailureListener(){
                //.....
            }

        }
    }
}