package uk.co.ryanmoss.kotlinandroid.presenters

import uk.co.ryanmoss.kotlinandroid.interfaces.SayHelloInterface
import uk.co.ryanmoss.kotlinandroid.models.Person

/**
 * Created by ryanmoss on 26/10/2017.
 */
class SayHelloPresenter: SayHelloInterface.Presenter {

    private var person: Person? = null
    private var view: SayHelloInterface.View? = null

    constructor(view: SayHelloInterface.View) {
        this.view = view
    }

    override fun createPerson(firstName: String, lastName: String, age: String) {
        if(!age.isNullOrEmpty() && !firstName.isNullOrEmpty() && !lastName.isNullOrEmpty()) {
            person = Person(firstName, lastName, age.toInt())
            view?.showSuccess("Person successfully created")
        }
        else {
            view?.showError("Please complete all details")
        }
           
    }

    override fun loadMessage() {
        if(person?.firstName is String)
            view?.showMessage("Hi ${person?.firstName}")
        else
            view?.showError("No Person exists")
    }
}