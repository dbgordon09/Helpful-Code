package /*Your package name here :)*/;

import android.widget.EditText;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static Boolean isValid(String regex, EditText toValidate, String error) {
        if (TextUtils.isEmpty(toValidate.getText().toString())) {
            //If the given input is empty set the error to required field.
            toValidate.setError("Required field");
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(toValidate.getText().toString());
        if (!matcher.matches()) {
            //If the passed through regex does not match the text within the input field
            //set an error to that passed through.
            toValidate.setError(error);
            return false;
        }
        //If both of the above checks pass, return that the input is indeed valid.
        return true;
    }
}