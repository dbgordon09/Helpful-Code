import android.content.Context
import com.tsongkha.spinnerdatepicker.DatePickerDialog
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder
import java.text.SimpleDateFormat
import java.util.*

class DatePicker(startYearDelta: Int, minYearDelta: Int, maxYearDelta: Int, context: Context, listener: OnDatePickerListener ) {
    private val calendar = Calendar.getInstance()
    private var dialog: DatePickerDialog

    init {
        calendar.set(calendar.get(Calendar.YEAR), 0, 1)
        dialog = SpinnerDatePickerDialogBuilder()
                .context(context)
                .callback { _, year, monthOfYear, dayOfMonth ->
                    calendar.set(year, monthOfYear, dayOfMonth)
                    listener.onDateSelection(SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(calendar.time))
                }
                .showTitle(true)
                .showDaySpinner(true)
                .maxDate(Calendar.getInstance().get(Calendar.YEAR) - maxYearDelta, 11, 31)
                .minDate(Calendar.getInstance().get(Calendar.YEAR) - minYearDelta, 0, 1)
                .defaultDate(calendar.get(Calendar.YEAR) - startYearDelta, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
                .build()
    }

    /**
     * This interface allows an interaction between the
     * callback and the activity/fragment that implements the Date Picker
     */
    interface OnDatePickerListener {
        fun onDateSelection(dateSelected: String)
    }

    fun getDialog(): DatePickerDialog {
        return dialog
    }

    fun getDate(): String {
        return SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(calendar.time)
    }
}