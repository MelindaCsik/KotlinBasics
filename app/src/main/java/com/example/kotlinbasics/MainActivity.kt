package com.example.kotlinbasics

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.health.connect.datatypes.units.Temperature
import android.location.Address
import android.os.Build.Partition
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    data class Student(
        val name: String,
        val age: Byte
    )

    data class Library(
        val libraryName: String,
        val books: List<Book>
    )

    data class Book(
        val title: String,
        val author: String
    )

    data class Weather(
        val location: String,
        val temperatures: Temperatures
    )

    data class Temperatures(
        val morning: Long,
        val afternoon: Long,
        val evening: Long
    )

    data class Event(
        val name: String,
        val participants: List<Participants>
    )

    data class Participants(
        val name: String,
        val age: Long
    )

    data class Author(
        val name: String,
        val books: Long,
        val genres: List<String>
    )

    data class Food(
        val name: String,
        val ingredients: List<Ingredients>,
        val time: Long
    )

    data class Ingredients(
        val ingredient :String,
        val quantity: Double
    )

    data class Order(
        val id: String,
        val customer: Custemer,
        val itemes: List<Items>,
        val status: String,
        val totalAmount: Long
    )

    data class Custemer(
        val id: String,
        val name: String,
        val email: String,
        val phone: String,
        val address: Address
    )
    
    data class Address(
        val city: String,
        val street: String,
        val zipcode: String
    )

    data class Items(
        val product: Product,
        val quantity: Int,
        val price: Double
    )

    data class Product(
        val id: String,
        val name: String,
        val category: String
    )

    data class Univercity(
        val name: String,
        val departments: List<Departments>
    )

    data class Departments(
        val name: String,
        val professors: List<Professors>,
        val students: List<Students>
    )

    data class Professors(
        val name: String,
        val subject: String
    )

    data class Students(
        val name: String,
        val id: String,
        val courses: List<Courses>
    )

    data class Courses(
        val name: String,
        val credits: Long
    )


    data class Airport(
        val airportName: String,
        val terminals: List<Terminals>
    )

    data class Terminals(
        val terminalName: String,
        val flights: List<Flights>
    )

    data class Flights(
        val flightNumber: String,
        val destination: String,
        val airline: Airline
    )

    data class Airline(
        val name: String,
        val country: String
    )


    data class Publisher(
        val publisherName: String,
        val authors: List<Authors>
    )

    data class Authors(
        val authorName: String,
        val books: List<Books>
    )

    data class Books(
        val title: String,
        val year: Long,
        val ratings: List<Ratings>
    )

    data class Ratings(
        val rating: Long,
        val comment: String
    )


    data class Agency(
        val agencyName: String,
        val customers: List<Customers>
    )

    data class Customers(
        val custemerId: String,
        val name: String,
        val email: String,
        val booking: List<Booking>
    )

    data class Booking(
        val bookingId: String,
        val packages: Package,
        val rating: Rating?
    )

    data class Package(
        val packageId: String,
        val destination: String,
        val durationDays: Long,
        val price: Long,
        val activities: List<Activityes>
    )

    data class Activityes(
        val activityName: String,
        val type: String
    )

    data class Rating(
        val scope: Long,
        val comment: String
    )

    private lateinit var welcomeButton: Button
    private lateinit var calculatorButton: Button
    private lateinit var openWearherButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        welcomeButton = findViewById(R.id.welcomeButton);
        calculatorButton = findViewById(R.id.calculatorButton);
        openWearherButton = findViewById(R.id.openWeatherButton)

        welcomeButton.setOnClickListener() {
            val intent = Intent(this, GreetingActivity::class.java);
            startActivity(intent);
        }

        calculatorButton.setOnClickListener() {
            val intent = Intent(this, CalculatorActivity::class.java);
            startActivity(intent);
        }

        openWearherButton.setOnClickListener() {
            val intent = Intent(this, WeatherActvity::class.java);
            startActivity(intent);
        }

    }
}