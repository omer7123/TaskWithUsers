package com.example.taskwithusers.data.remote.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class User(
    val info: Info,
    val results: List<Result>
)


data class Street(
    @ColumnInfo("name_street") val name: String?,
    val number: Int?
) : Serializable


@Entity(tableName = "result")
data class Result(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_user") var idRes: Int?,
    var cell: String?,
    @Embedded val dob: Dob?,
    var email: String?,
    var gender: String?,
    @Embedded var id: Id?,
    @Embedded var location: Location?,
    @Embedded var login: Login?,
    @Embedded var name: Name?,
    var nat: String?,
    var phone: String?,
    @Embedded var picture: Picture?,
    @Embedded val registered: Registered?
) : Serializable

data class Registered(
    @ColumnInfo(name = "age_reg") val age: Int?,
    @ColumnInfo(name = "date_reg") val date: String?
) : Serializable

data class Picture(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
) : Serializable

data class Name(
    val first: String?,
    val last: String?,
    val title: String?
) : Serializable

data class Login(
    val md5: String?,
    val password: String?,
    val salt: String?,
    val sha1: String?,
    val sha256: String?,
    val username: String?,
    val uuid: String?
) : Serializable

data class Location(
    val city: String?,
    val country: String?,
    val postcode: String?,
    val state: String?,
    @Embedded var coordinates: Coordinates?,
    @Embedded var street: Street?,
) : Serializable

data class Info(
    val page: Int?,
    val results: Int?,
    val seed: String?,
    val version: String?
) : Serializable

data class Id(
    @ColumnInfo(name = "name_id") val name: String?,
    val value: String?
)

data class Dob(
    @ColumnInfo(name = "age_dob") val age: Int?,
    @ColumnInfo(name = "date_dob") val date: String?
)

data class Coordinates(
    val latitude: String?,
    val longitude: String?
)
