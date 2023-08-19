package com.example.belablok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.belablok.feature_blok.data.data_source.BelaBlokDatabase
import com.example.belablok.feature_blok.domain.model.Game
import com.example.belablok.feature_blok.domain.model.History
import com.example.belablok.feature_blok.domain.model.Record
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = BelaBlokDatabase.getInstance(this).historyDao

        val records = listOf(
            Record(1,111, 51, 2),
            Record(2,112, 50, 2),
            Record(3,113, 49, 2),
        )

        val games = listOf(
            Game(2, 1006, 898, 1),
            Game(2, 1011, 839, 1),
            Game(2, 1020, 600, 1)
        )

        val history = History(1, 5, 2)

        lifecycleScope.launch {
            records.forEach { dao.insertRecord(it) }
            games.forEach { dao.insertGame(it) }
            dao.insertHistory(history)
        }
    }
}
