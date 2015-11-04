package me.nucleartux.date;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import com.facebook.react.bridge.Callback;

public class DatePicker extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private Callback mErrorCallback;
    private Callback mSuccessCallback;
    private boolean isCalled;

    public DatePicker(Callback errorCallback, Callback successCallback)
    {
        isCalled = false;
        mErrorCallback = errorCallback;
        mSuccessCallback = successCallback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Dialog picker = new DatePickerDialog(getActivity(), this,
                year, month, day);
        picker.getDatePicker().setCalendarViewShown(false);
        // picker.setTitle(getResources().getString(R.string.choose_date));

        return picker;
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year,
            int month, int day) {
        if(!isCalled) {
            mSuccessCallback.invoke(year, month, day);
        }
        isCalled = true;
    }
}