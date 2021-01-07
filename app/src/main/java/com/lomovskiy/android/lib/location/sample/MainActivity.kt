package com.lomovskiy.android.lib.location.sample

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.lomovskiy.android.lib.location.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val locationSource: LocationSource = AppLoader.locationSource

    private lateinit var buttonLastKnownLocation: Button
    private lateinit var buttonCurrentLocation: Button
    private lateinit var buttonRequestUpdates: Button
    private lateinit var buttonRemoveUpdates: Button
    private lateinit var label: TextView

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonLastKnownLocation = findViewById(R.id.last_known_location)
        buttonCurrentLocation = findViewById(R.id.current_location)
        buttonRequestUpdates = findViewById(R.id.request_updates)
        buttonRemoveUpdates = findViewById(R.id.remove_updates)
        label = findViewById(R.id.label)

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)

        buttonLastKnownLocation.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val location = locationSource.getLastKnownLocation()
                    location?.let {
                        showToast(it.toString())
                    }
                } catch (e: LocationException) {
                    handleLocationException(e)
                }
            }
        }

        buttonCurrentLocation.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val location = locationSource.getCurrentLocation()
                    location?.let {
                        showToast(it.toString())
                    }
                } catch (e: LocationException) {
                    handleLocationException(e)
                }
            }
        }

        buttonRequestUpdates.setOnClickListener {
            lifecycleScope.launch {
                try {
                    locationSource.subscribeOnLocationUpdatesStream(0, 0F).collect {
                        label.text = it.toString()
                    }
                } catch (e: LocationException) {
                    handleLocationException(e)
                }
            }
        }

        buttonRemoveUpdates.setOnClickListener {

        }
    }

    private fun handleLocationException(e: LocationException) {
        when (e) {
            is LocationException.UnresolvableLocationException -> {
                showToast("UnresolvableLocationException")
            }
            is LocationException.ResolvableLocationException -> {
                showToast("ResolvableLocationException")
            }
            is LocationException.SecurityLocationException -> {
                showToast("SecurityLocationException")
            }
            is LocationException.CommonLocationException -> {
                showToast("CommonLocationException")
            }
        }
    }

}

@Suppress("NOTHING_TO_INLINE")
private inline fun Activity.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
