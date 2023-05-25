package com.cemalabs.towerscan

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WifiReadingDao {
    @Query("SELECT * FROM WifiReading")
    fun getAll(): List<WifiReading>

    @Insert
    fun insert(vararg wifiReadings: WifiReading)
}

@Dao
interface CellularReadingDao {
    @Query("SELECT * FROM CellularReading")
    fun getAll(): List<CellularReading>

    @Insert
    fun insert(vararg cellularReadings: CellularReading)
}

@Dao
interface BluetoothDeviceReadingDao {
    @Query("SELECT * FROM BluetoothDeviceReading")
    fun getAll(): List<BluetoothDeviceReading>

    @Insert
    fun insert(vararg bluetoothDeviceReadings: BluetoothDeviceReading)
}
