package com.example.week5_day2_provider.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 2, entities = [GuestEntity::class])
abstract class HotelDB : RoomDatabase() {
   abstract fun hotelDAO(): HotelDAO
}