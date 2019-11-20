package com.example.displayguests.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.displayguests.R
import com.example.displayguests.adapter.GuestAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var guestList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readFromProvider()
    }


    override fun onResume() {
        super.onResume()

    }

    private fun readFromProvider(){

        val contentResolver = getContentResolver()
        val uri = Uri.parse("content://com.example.week5_day2_provider.provider.HotelProvider/Guests")
        val cursor = contentResolver.query(uri,null,null,null,null)

        cursor?.moveToFirst()

        while (cursor?.moveToNext() == true){


            val guest = cursor.getString(cursor.getColumnIndex("name"))

            guestList.add(guest)

        }

        val adapter = GuestAdapter(guestList)
        guest_view.adapter = adapter
        guest_view.layoutManager = LinearLayoutManager(this)

        cursor?.close()
    }

}
