package com.example.jopfinderapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class JobsActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobs)


        val sharedPreferences=getSharedPreferences("login",Context.MODE_PRIVATE)
        val email=sharedPreferences.getString("email",null)
        val password =sharedPreferences.getString("password",null)
        Toast.makeText(this,"email: $email and password $password",Toast.LENGTH_LONG).show()

        loadFragment(HomeFragment())
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.application -> {
                    loadFragment(ApplicationFragment())
                    true
                }

                R.id.account -> {
                    loadFragment(AccountFragment())
                    true
                }

                R.id.bookMarks -> {
                    loadFragment(BookmarksFragment())
                    true
                }

                else -> {
                    loadFragment(BookmarksFragment())
                    true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

}