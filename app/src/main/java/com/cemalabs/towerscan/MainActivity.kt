package com.cemalabs.towerscan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity as AppCompatActivity1

private lateinit var wifiScanReceiver: android.content.BroadcastReceiver
private lateinit var bluetoothReceiver: android.content.BroadcastReceiver

import android.os.Bundle

class MainActivity : AppCompatActivity1() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    wifiScanReceiver = internal object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
            if (success) {
                val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                val results = wifiManager.scanResults
                // TODO: Use the results
            }
        }
    }

    bluetoothReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action: String = intent.action
            if (BluetoothDevice.ACTION_FOUND == action) {
                val device: BluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                val rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE)
                // TODO: Use device details and rssi
            }
        }
    }
    registerReceiver(wifiScanReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
    registerReceiver(bluetoothReceiver, IntentFilter(BluetoothDevice.ACTION_FOUND))
    val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    wifiManager.startScan()

    val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    bluetoothAdapter.startDiscovery()
    val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        // TODO: Request the permission
        return
    }

    val cellInfoList = telephonyManager.allCellInfo
// TODO: Use cellInfoList

}
override fun onDestroy() {
    super.onDestroy()
    unregisterReceiver(wifiScanReceiver)
    unregisterReceiver(bluetoothReceiver)
}
bluetoothAdapter.cancelDiscovery()