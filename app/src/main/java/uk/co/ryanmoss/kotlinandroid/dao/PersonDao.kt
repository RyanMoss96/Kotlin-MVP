package uk.co.ryanmoss.kotlinandroid.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import uk.co.ryanmoss.kotlinandroid.models.Person




/**
 * Created by ryanmoss on 29/10/2017.
 */
@Dao
interface PersonDao {

    @Insert
    fun insert(person: Person)

    @Query("SELECT * FROM person WHERE id = :arg0")
    fun getPerson(id: Long): Person

    @Query("SELECT * FROM person")
    fun getAllPeople(): Flowable<List<Person>>
}