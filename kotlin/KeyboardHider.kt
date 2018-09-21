import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.ViewGroup
import android.widget.EditText

object KeyboardHider {

    fun setupActivity(activity: Activity) {
        setListeners(activity.findViewById<ViewGroup>(android.R.id.content).getChildAt(0), activity)
    }

    private fun setListeners(view: View, activity: Activity){
        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener { _, _ ->
                hide(activity)
                false
            }
        }

        //If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
                setListeners(innerView, activity)
            }
        }
    }

    fun hide(activity: Activity) {
        val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}