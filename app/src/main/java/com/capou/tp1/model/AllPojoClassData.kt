package com.capou.tp1.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

sealed class MyObjectForRecyclerView()

//creation du data pour le header
data class UserDataHeader(
    val header: String
) : MyObjectForRecyclerView()


//creation du data pour footer
data class UserDataFooter(
    val footer: String
) : MyObjectForRecyclerView()


data class UserData(
    val name:String,
    val firstname:String,
    val gender:String
):MyObjectForRecyclerView()



// creata a roomm for Weather

@Entity(tableName = "weather")
data class WeatherRoom(

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName( "consolidated_weather")
    @Embedded
    val consolidated_weather: ConsolidatedWeather
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}


data class ConsolidatedWeather(
    @Expose
    @SerializedName(value = "default", alternate = ["Aatrox","Bard"])
    @Embedded
    val weatherDetails : WeatherDetails
)

data class  WeatherDetails(
    @Expose
    @SerializedName("weather_state_name")
    val key: String,


    @Expose
    @SerializedName("min_temp")
    val min_temp: Float,


    @Expose
    @SerializedName("max_temp")
    val max_temp: Float,


    @Expose
    @SerializedName("the_temp")
    val the_temp: Float,

    @Expose
    @SerializedName("humidity")
    val humidity: Float,

)

//Design UI
data class WeatherUi(
    val title: String,
    val consolidated_weather: ConsolidatedWeather
)


//Retrofit
data class WeatherRetrofit(
    @Expose
    @SerializedName("title")
    val title: String,


    @Expose
    @SerializedName("consolidated_weather")
    val consolidated_weather: ConsolidatedWeather
)

