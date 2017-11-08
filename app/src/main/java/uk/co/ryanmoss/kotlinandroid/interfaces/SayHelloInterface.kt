package uk.co.ryanmoss.kotlinandroid.interfaces

import uk.co.ryanmoss.kotlinandroid.models.Person

/**
 * Created by ryanmoss on 26/10/2017.
 */
interface SayHelloInterface {
    interface View {
        fun showMessage(person: List<Person>)
        fun showError(error: String)
        fun showSuccess(success: String)

    }

    interface Presenter {
        fun createPerson(firstName: String, lastName: String, age: String)
        fun loadMessage()
    }
}