package com.example.assignmentsportclub

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {
    private var isFirstFragmentDisplayed = true
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listView: ListView = findViewById(R.id.listview)
        val btnlogin: Button = findViewById(R.id.btnlogin1)
        btnlogin.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val members =
            arrayListOf("Kusal", "Pathum", "Wanindu", "Dasun", "Mathews", "Charith")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, members)
        listView.adapter = adapter
        replaceFragment(KusalFragment())
        listView.setOnItemClickListener { parent, view, position, id ->
            val clickedItem = members[position]

            Toast.makeText(this, "You Selected: $clickedItem", Toast.LENGTH_SHORT).show()
            if(clickedItem == "Kusal"){
                replaceFragment(KusalFragment())
            }else if(clickedItem == "Pathum"){
                replaceFragment(PathumFragment())

            }else if(clickedItem == "Wanindu"){
                replaceFragment(WaninduFragment())
            }else if(clickedItem == "Dasun"){
                replaceFragment(DasunFragment())
            }else if(clickedItem == "Mathews"){
                replaceFragment(MathewsFragment())
            }else if(clickedItem == "Charith"){
                replaceFragment(CharithFragment())
            }
            isFirstFragmentDisplayed = isFirstFragmentDisplayed
        }
    }
        private fun replaceFragment(fragment: Fragment){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }


    }


