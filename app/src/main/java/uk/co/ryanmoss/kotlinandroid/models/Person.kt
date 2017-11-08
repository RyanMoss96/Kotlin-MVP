package uk.co.ryanmoss.kotlinandroid.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by ryanmoss on 26/10/2017.
 */
@Entity
data class Person(var firstName: String = "", var lastName: String = "", var age: Int = 0) {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}