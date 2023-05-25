package com.cemalabs.towerscan

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CellularReading(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val networkOperator: String,
    val networkType: String,

    // For GSM
    val cidGSM: Int,
    val lacGSM: Int,

    // For CDMA
    val networkIdCDMA: Int,
    val systemIdCDMA: Int,
    val baseStationIdCDMA: Int,

    // For LTE
    val ciLTE: Int,
    val tacLTE: Int,

    // For WCDMA
    val pscWCDMA: Int,

    val neighboringCells: List<NeighboringCell>
)

data class NeighboringCell(
    val networkOperator: String,
    val networkType: String,

    // For GSM
    val cidGSM: Int?,
    val lacGSM: Int?,

    // For CDMA
    val networkIdCDMA: Int?,
    val systemIdCDMA: Int?,
    val baseStationIdCDMA: Int?,

    // For LTE
    val ciLTE: Int?,
    val tacLTE: Int?,

    // For WCDMA
    val pscWCDMA: Int?
)

