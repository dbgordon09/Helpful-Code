import android.widget.Spinner
import android.widget.TextView

object HintSpinnerValidator {
    fun isItemSelected(toValidate: Spinner): Boolean {
        toValidate.let {
            if (it.selectedItemPosition == it.count) {
                //If the given spinner has the last item in the array selected
                if (it.count > 0)
                    (it.selectedView as TextView).error = ""
                return false
            }
            return true
        }
    }
}