package com.example.belablok.feature_blok.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey val game_id: Int? = null,
    val we_total: Int,
    val you_total: Int,
    val history_id: Int
)
