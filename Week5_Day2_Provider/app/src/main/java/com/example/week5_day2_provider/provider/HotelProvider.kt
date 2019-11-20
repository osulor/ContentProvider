package com.example.week5_day2_provider.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import androidx.room.Room
import com.example.week5_day2_provider.database.HotelDB
import com.example.week5_day2_provider.util.Constants.AUTHORITY
import com.example.week5_day2_provider.util.Constants.DATABASE_NAME

class HotelProvider: ContentProvider() {

    val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    private val SINGLE_GUEST = 0
    private val ALL_GUEST = 1

    private var database: HotelDB? = null

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {

        var cursor: Cursor? = null

        when(uriMatcher.match(uri)){

            SINGLE_GUEST -> {

            }

            ALL_GUEST -> {
                cursor = database?.hotelDAO()?.retrieveAllGuests()
            }
        }

        return cursor
    }

    override fun onCreate(): Boolean {

        uriMatcher.apply {
            addURI(AUTHORITY, "Guests/#",SINGLE_GUEST)
            addURI(AUTHORITY,"Guests", ALL_GUEST)
        }

        context?.let{actualContext ->

            database = Room.databaseBuilder(actualContext,HotelDB::class.java,DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
        }

        return (database != null)
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }
}