package com.example.accelerometerapp

import android.R.attr.data
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager
    private lateinit var Accelerometer : Sensor
    lateinit var seekBar: SeekBar
    private var threshold: Int = 12

    fun createToast(input: String) {
        Toast.makeText(
            this, input,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seekBar)
        seekBar.progress = threshold
        seekBar?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                threshold = progress
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        Accelerometer = sensorManager!!.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
        sensorManager!!.registerListener(mSensorEventListener, Accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    private val mSensorEventListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_LINEAR_ACCELERATION) {
                if (event.values[0] > threshold) createToast("X axis movement over threshold")
                if (event.values[1] > threshold) createToast("Y axis movement over threshold")
                if (event.values[2] > threshold) createToast("Z axis movement over threshold")
            }
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }
}
