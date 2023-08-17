package com.example.belablok.feature_blok.data.data_source

import androidx.room.*
import com.example.belablok.feature_blok.domain.model.Game
import com.example.belablok.feature_blok.domain.model.History
import com.example.belablok.feature_blok.domain.model.Record
import com.example.belablok.feature_blok.domain.model.relations.GameWithRecords
import com.example.belablok.feature_blok.domain.model.relations.HistoryWithGames
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: Game)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: Record)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(history: History)

    @Transaction
    @Query("SELECT * FROM game WHERE game_id = :game_id")
    suspend fun getGameWithRecords(game_id: Int): List<GameWithRecords>

    @Transaction
    @Query("SELECT * FROM history WHERE history_id = :history_id")
    suspend fun getHistoryWithGames(history_id: Int): List<HistoryWithGames>
}