package com.example.week5_day2_provider.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.week5_day2_provider.R
import com.example.week5_day2_provider.database.GuestEntity
import com.example.week5_day2_provider.database.HotelDB
import com.example.week5_day2_provider.util.Constants.CONTENT_URL
import com.example.week5_day2_provider.util.Constants.DATABASE_NAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var database: HotelDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(this,HotelDB::class.java,DATABASE_NAME)
            .allowMainThreadQueries()
            .build()

        add_button.setOnClickListener {
            insertNewGuest()
            clearTextFields()
        }
    }



//    private fun readFromProvider(){
//
//        val contentResolver = getContentResolver()
//        val uri = Uri.parse(CONTENT_URL)
//        val cursor = contentResolver.query(uri,null,null,null,null)
//
//        cursor?.moveToFirst()
//
//        while (cursor?.moveToNext() == true){
//
//            //Log.d("TAG",cursor.getString(cursor.getColumnIndex("name")))
//
//            Log.d("TAG",cursor.getString(cursor.getColumnIndex("name")))
//
//
//
//        }
//
//        cursor?.close()
//    }



    private fun insertNewGuest() {
        val guestName = name_text.text.toString()
        val roomNumber = room_text.text.toString()
        val roomPrice = price_text.text.toString().toInt()

        val guest = GuestEntity(guestName,roomNumber,roomPrice)
        database.hotelDAO().insertGuest(guest)
        Toast.makeText(this,guest.guestName.plus(" has been saved to the Database"),Toast.LENGTH_LONG).show()

        clearTextFields()
    }

    private fun clearTextFields() {
        name_text.text.clear()
        room_text.text.clear()
        price_text.text.clear()
    }


}
