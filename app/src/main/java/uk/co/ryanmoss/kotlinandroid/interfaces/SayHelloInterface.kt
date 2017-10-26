package uk.co.ryanmoss.kotlinandroid.interfaces

/**
 * Created by ryanmoss on 26/10/2017.
 */
interface SayHelloInterface {
    interface View {
        fun showMessage(message:String)
        fun showError(error: String)
    }

    interface Presenter {
        fun createPerson(firstName: String, lastName: String, age: String)
        fun loadMessage()
    }
}