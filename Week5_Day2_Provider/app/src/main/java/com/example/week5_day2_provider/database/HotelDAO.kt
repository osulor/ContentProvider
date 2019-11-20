package com.example.week5_day2_provider.database

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HotelDAO {

    @Insert
    fun insertGuest(guestEntity: GuestEntity)

    @Query ("SELECT * FROM Guests")
    fun retrieveAllGuests() : Cursor

}