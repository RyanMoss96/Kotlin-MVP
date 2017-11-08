package uk.co.ryanmoss.kotlinandroid.presenters

import uk.co.ryanmoss.kotlinandroid.database.AppDatabase
import uk.co.ryanmoss.kotlinandroid.interfaces.SayHelloInterface
import uk.co.ryanmoss.kotlinandroid.models.Person
import android.arch.persistence.room.Room
import android.content.Context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by ryanmoss on 26/10/2017.
 */
class SayHelloPresenter: SayHelloInterface.Presenter {

    lateinit private var person: Person
    private var view: SayHelloInterface.View
    private var db: AppDatabase
    private var context: Context


    constructor(view: SayHelloInterface.View, context: Context) {
        this.view = view
        this.context = context
        this.db = Room.databaseBuilder(this.context,
                AppDatabase::class.java, "test-db").build();
    }

    override fun createPerson(firstName: String, lastName: String, age: String) {
        if(!age.isNullOrEmpty() && !firstName.isNullOrEmpty() && !lastName.isNullOrEmpty()) {
            person = Person(firstName, lastName, age.toInt())

            Observable.just(person)
                    .observeOn(Schedulers.io())
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe({ item ->
                        db.getPersonDao().insert(item)
                    }, { throwable -> view.showError(throwable.localizedMessage) })

            view.showSuccess("Person successfully created")
        }
        else {
            view.showError("Please complete all details")
        }

    }

    override fun loadMessage() {
        db.getPersonDao().getAllPeople()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showMessage)

    }
}