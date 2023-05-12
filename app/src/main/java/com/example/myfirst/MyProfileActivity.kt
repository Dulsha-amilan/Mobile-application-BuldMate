package com.example.clickin.activities


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.clickin.R

class MyProfileActivity : AppCompatActivity(){

    private lateinit var my_profile_M_L: Button
    private lateinit var my_profile_M_D:Button
    private lateinit var my_profile_M_P_D:Button
    private lateinit var my_profile_M_O:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myprofile)


        my_profile_M_L = findViewById(R.id.my_profile_M_L)
        my_profile_M_D = findViewById(R.id.my_profile_M_D)
        my_profile_M_P_D = findViewById(R.id.my_profile_M_P_D)
        my_profile_M_O = findViewById(R.id.my_profile_M_O)



        my_profile_M_L.setOnClickListener {
            val intent = Intent(this, MyListingActivity::class.java)
            startActivity(intent)
        }
        my_profile_M_D.setOnClickListener {
            val intent = Intent(this, FetchingActivity::class.java)
            startActivity(intent)
        }
        my_profile_M_P_D.setOnClickListener {
            val intent = Intent(this, MyPaymentActivity::class.java)
            startActivity(intent)
        }
        my_profile_M_O.setOnClickListener {
            val intent = Intent(this, InsertionActivity::class.java)
            startActivity(intent)
        }
    }
}