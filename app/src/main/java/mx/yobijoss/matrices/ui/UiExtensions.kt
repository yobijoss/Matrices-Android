package mx.yobijoss.matrices.ui

import android.widget.EditText
import java.lang.NumberFormatException

fun EditText.double(): Double {
    var value = 0.0

    text?.run {
        try {
            value = text.toString().toDouble()
        } catch (ignored: NumberFormatException) {
        }
    }

    return value
}