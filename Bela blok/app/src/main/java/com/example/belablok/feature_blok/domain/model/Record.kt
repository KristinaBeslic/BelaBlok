package com.example.belablok.feature_blok.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Record(
    @PrimaryKey val record_id: Int? = null,
    val we_currently: Int,
    val you_currently: Int,
    val game_id: Int
)