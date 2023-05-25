package com.cemalabs.towerscan

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WifiReading::class, CellularReading::class, BluetoothDeviceReading::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wifiReadingDao(): WifiReadingDao
    abstract fun cellularReadingDao(): CellularReadingDao
    abstract fun bluetoothDeviceReadingDao(): BluetoothDeviceReadingDao
}
