package uk.co.ryanmoss.kotlinandroid.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import io.reactivex.Flowable
import org.w3c.dom.Text
import uk.co.ryanmoss.kotlinandroid.R
import uk.co.ryanmoss.kotlinandroid.interfaces.SayHelloInterface
import uk.co.ryanmoss.kotlinandroid.models.Person
import uk.co.ryanmoss.kotlinandroid.presenters.SayHelloPresenter

class MainActivity : AppCompatActivity(), SayHelloInterface.View, View.OnClickListener {

    lateinit private var presenter: SayHelloInterface.Presenter

    lateinit private var messageView: TextView
    lateinit private var firstNameView: EditText
    lateinit private var lastNameView: EditText
    lateinit private var ageView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        presenter = SayHelloPresenter(this, this)
    }

    private fun init() {
        messageView = findViewById<TextView>(R.id.message)
        firstNameView = findViewById<EditText>(R.id.firstName)
        lastNameView = findViewById<EditText>(R.id.lastName)
        ageView = findViewById<EditText>(R.id.age)

        findViewById<Button>(R.id.showMessage).setOnClickListener(this)
        findViewById<Button>(R.id.update).setOnClickListener(this)
    }

    override fun showMessage(people: List<Person>) {
        Log.e("People: ", people.toString())
        for(person in people) {
            messageView.text = person.firstName;
        }
    }

    override fun showError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show();
    }

    override fun showSuccess(success: String) {
        Toast.makeText(applicationContext, success, Toast.LENGTH_SHORT).show();
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.update -> presenter.createPerson(firstNameView.text.toString(), lastNameView.text.toString(), ageView.text.toString())
            R.id.showMessage -> presenter.loadMessage()
        }
    }
}
