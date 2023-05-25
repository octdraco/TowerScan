package com.cemalabs.towerscan
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BluetoothDeviceReading(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String?,
    val address: String,
    val type: String, // Could be Bluetooth Classic, BLE, or Dual
    val signalStrength: Int
)

