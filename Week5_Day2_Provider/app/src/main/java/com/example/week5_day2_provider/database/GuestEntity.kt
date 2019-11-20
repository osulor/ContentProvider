package com.example.week5_day2_provider.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Guests")
class GuestEntity(
    @PrimaryKey(autoGenerate = true) var guestID: Int?,
    @ColumnInfo(name = "name") var guestName: String,
    @ColumnInfo(name = "room") var roomNumber: String,
    @ColumnInfo(name = "price") var roomPrice : Int
) {

    constructor(guestName: String,roomNumber: String,roomPrice: Int):
            this(null,guestName,roomNumber,roomPrice)
}