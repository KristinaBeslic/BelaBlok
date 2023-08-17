package com.example.belablok.feature_blok.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History(
    @PrimaryKey val history_id: Int? = null,
    val we_wins: Int,
    val you_wins: Int
)