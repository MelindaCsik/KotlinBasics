package com.example.kotlinbasics

import android.os.Bundle
import android.telecom.Call
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.model.WeatherResponse
import java.security.cert.CertPathValidatorException.Reason

class WeatherActvity : AppCompatActivity() {

    private lateinit var textviewTemp: TextView
    private val apiKey = 3f19b2dde5ec8b9a9659df3afb92204a;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather_actvity)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        textviewTemp = findViewById(R.id.textview_temp)


        fetchWeatherData()

    }

    private fun fetchWeatherData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.oppenweather.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherSevice = retrofit.create(WeatherServices::class.java)
        val call = weatherServices.getweather("Tatabánya", apiKey, "metric")

        call.enqueue(object:CallBack<WeatherResponse> {

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Reasponse<WeatherResponse>
            ) {
                if (reasponse.isSuccesful){
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        val weatherInfo = weatherResponse.main.temp
                        textviewTemp.text = weatherInfo()
                    }
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("HIBA", "Hiba az API kérés során")
            }
        })
    }

}