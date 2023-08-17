package com.example.belablok.feature_blok.domain.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.belablok.feature_blok.domain.model.Game
import com.example.belablok.feature_blok.domain.model.History

data class HistoryWithGames(
    @Embedded val history: History,
    @Relation(
        parentColumn = "history_id",
        entityColumn = "history_id"
    )
    val games: List<Game>
)