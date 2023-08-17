package com.example.belablok.feature_blok.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.belablok.feature_blok.domain.model.Game
import com.example.belablok.feature_blok.domain.model.History
import com.example.belablok.feature_blok.domain.model.Record
import kotlin.synchronized

@Database(
    entities = [
        Record::class,
        Game::class,
        History::class
    ],
    version = 1
)
abstract class BelaBlokDatabase: RoomDatabase() {

    abstract val historyDao: HistoryDao

    companion object {
        @Volatile
        private var INSTANCE: BelaBlokDatabase? = null

        fun getInstance(context: Context): BelaBlokDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    BelaBlokDatabase::class.java,
                    "belaBlok_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}