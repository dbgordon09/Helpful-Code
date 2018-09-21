import android.text.TextUtils
import android.widget.EditText
import java.util.regex.Pattern

object InputValidator {
    fun isValid(regex: String, toValidate: EditText, error: String): Boolean {
        if (TextUtils.isEmpty(toValidate.text.toString())) {
            //If the given input is empty set the error to required field.
            toValidate.error = "Required field"
            return false
        }
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(toValidate.text.toString())
        if (!matcher.matches()) {
            //If the passed through regex does not match the text within the input field
            //set an error to that passed through.
            toValidate.error = error
            return false
        }
        //If both of the above checks pass, return that the input is indeed valid.
        return true
    }
}