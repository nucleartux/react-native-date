package me.nucleartux.date;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import com.facebook.react.bridge.Callback;

import android.text.format.DateFormat;

public class TimePicker extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private Callback mErrorCallback;
    private Callback mSuccessCallback;
    private boolean isCalled;

    public TimePicker(Callback errorCallback, Callback successCallback)
    {
        isCalled = false;
        mErrorCallback = errorCallback;
        mSuccessCallback = successCallback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker datePicker, int hour, int minute) {
        if(!isCalled) {
            mSuccessCallback.invoke(hour, minute);
        }
        isCalled = true;
    }
}