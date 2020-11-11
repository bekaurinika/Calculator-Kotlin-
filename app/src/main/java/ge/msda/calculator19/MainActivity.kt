package ge.msda.calculator19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var fOperand: Double = 0.0
    private var sOperand: Double = 0.0
    private var operation: String = ""
    private var opIsUsed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        findViewById<TextView>(R.id.clearButton).setOnClickListener {
            fOperand = 0.0
            operation = ""
            resultTextView.text = ""
        }

    }

    fun numberClick(view: View) {

        if (view is TextView) {

            var result: String = resultTextView.text.toString()
            val number: String = view.text.toString()

            if (result == "0") {
                result = ""

                resultTextView.text = result + number
            } else if (number == ".") {
                if (!resultTextView.text.toString().contains('.')) {
                    resultTextView.text = result + number
                }
            } else {
                resultTextView.text = result + number
            }
        }
    }

    fun operationClick(view: View) {

        if (view is TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {
                fOperand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()

        }
    }

    fun equalsClick(view: View) {

        val secOperandText: String = resultTextView.text.toString()

        if (!TextUtils.isEmpty(secOperandText) && opIsUsed) {
            sOperand = secOperandText.toDouble()
        } else {
            fOperand = resultTextView.text.toString().toDouble()
        }

//        Log.i("UserDebug", operation.toString())

        when (operation) {
            "+" -> resultTextView.text = (fOperand + sOperand).toString()
            "-" -> resultTextView.text = (fOperand - sOperand).toString()
            "*" -> resultTextView.text = (fOperand * sOperand).toString()
            "/" -> resultTextView.text = (fOperand / sOperand).toString()
        }

        opIsUsed = false
    }
}