package uk.co.ryanmoss.kotlinandroid.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import uk.co.ryanmoss.kotlinandroid.R
import uk.co.ryanmoss.kotlinandroid.interfaces.SayHelloInterface
import uk.co.ryanmoss.kotlinandroid.presenters.SayHelloPresenter

class MainActivity : AppCompatActivity(), SayHelloInterface.View, View.OnClickListener {

    private var presenter: SayHelloInterface.Presenter? = null

    var messageView: TextView? = null
    var firstNameView: EditText? = null
    var lastNameView: EditText? = null
    var ageView: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        presenter = SayHelloPresenter(this)
    }

    fun init() {
        messageView = findViewById<TextView>(R.id.message)
        firstNameView = findViewById<EditText>(R.id.firstName)
        lastNameView = findViewById<EditText>(R.id.lastName)
        ageView = findViewById<EditText>(R.id.age)

        findViewById<Button>(R.id.showMessage).setOnClickListener(this)
        findViewById<Button>(R.id.update).setOnClickListener(this)

    }

    override fun showMessage(message: String) {
        messageView?.text = message
    }

    override fun showError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show();
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.update -> presenter?.createPerson(firstNameView?.text.toString(), lastNameView?.text.toString(), ageView?.text.toString())
            R.id.showMessage -> presenter?.loadMessage()
        }
    }

}
