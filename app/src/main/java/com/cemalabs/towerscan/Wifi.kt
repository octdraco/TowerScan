package com.cemalabs.towerscan

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WifiReading(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val SSID: String,
    val BSSID: String,
    val signalStrength: Int
)

