package com.example.belablok.feature_blok.domain.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.belablok.feature_blok.domain.model.Game
import com.example.belablok.feature_blok.domain.model.Record

data class GameWithRecords(
    @Embedded val game: Game,
    @Relation(
        parentColumn = "game_id",
        entityColumn = "game_id"
    )
    val records: List<Record>
)