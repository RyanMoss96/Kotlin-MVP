package uk.co.ryanmoss.kotlinandroid.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import uk.co.ryanmoss.kotlinandroid.dao.PersonDao
import uk.co.ryanmoss.kotlinandroid.models.Person


/**
 * Created by ryanmoss on 29/10/2017.
 */
@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getPersonDao(): PersonDao
}