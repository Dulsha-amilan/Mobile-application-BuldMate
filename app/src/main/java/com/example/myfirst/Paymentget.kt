package com.example.clickin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.clickin.R
import com.example.clickin.models.EmployeeModel
import com.example.clickin.models.PaymentModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Paymentget : AppCompatActivity() {
    private lateinit var cardHoderName :EditText
    private lateinit var card_number:EditText
    private lateinit var card_date:EditText
    private lateinit var card_cvv:EditText
    private lateinit var buttonsav:Button


    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paymentget)

        cardHoderName=findViewById(R.id.cardHoderName)
        card_number=findViewById(R.id.card_number)
        card_date=findViewById(R.id.card_date)
        card_cvv=findViewById(R.id.card_cvv)
        buttonsav=findViewById(R.id.pay_button)

        dbRef = FirebaseDatabase.getInstance().getReference("Employees")

        buttonsav.setOnClickListener {
            savePaymentData()
        }
    }
    private fun savePaymentData(){
        val ccardHoderName = cardHoderName.text.toString()
        val ccard_number= card_number.text.toString()
        val ccard_date=card_date.text.toString()
        val ccard_cvv = card_cvv.text.toString()

        if (ccardHoderName.isEmpty()) {
            cardHoderName.error = "Please enter cardholder name"
        }
        if (ccard_number.isEmpty()) {
            card_number.error = "Please enter cardnumber"
        }
        if (ccard_date.isEmpty()) {
            card_date.error = "Please enter carddate"
        }
        if (ccard_cvv.isEmpty()) {
            card_cvv.error = "Please enter cardcvc"
        }

        val empId = dbRef.push().key!!

        val employee = PaymentModel(empId,ccardHoderName,ccard_number,ccard_date)

        dbRef.child(empId).setValue(employee)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                cardHoderName.text.clear()
                card_number.text.clear()
                card_date.text.clear()
                card_cvv.text.clear()


            }.addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }






    }











}