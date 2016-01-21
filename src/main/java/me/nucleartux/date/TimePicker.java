package me.nucleartux.date;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.DialogFragment;
import android.text.format.DateFormat;

import com.facebook.react.bridge.Callback;

import java.util.Calendar;

public class TimePicker extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private Callback mErrorCallback;
    private Callback mSuccessCallback;
    private boolean isCalled;

    private Calendar mInitialDate;

    public TimePicker(Calendar initialDate, Callback errorCallback, Callback successCallback)
    {
        isCalled = false;
        mErrorCallback = errorCallback;
        mSuccessCallback = successCallback;
        mInitialDate = initialDate;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int hour = mInitialDate.get(Calendar.HOUR_OF_DAY);
        int minute = mInitialDate.get(Calendar.MINUTE);

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
