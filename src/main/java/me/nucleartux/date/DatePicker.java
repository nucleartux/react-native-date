package me.nucleartux.date;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.DialogFragment;

import com.facebook.react.bridge.Callback;

import java.util.Calendar;

public class DatePicker extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private Callback mErrorCallback;
    private Callback mSuccessCallback;
    private boolean isCalled;
    private Calendar mInitialDate;
    private Calendar mMinDate;
    private Calendar mMaxDate;

    public DatePicker(Calendar initialDate, Callback errorCallback, Callback successCallback) {
        isCalled = false;
        mErrorCallback = errorCallback;
        mSuccessCallback = successCallback;
        mInitialDate = initialDate;
    }

    public DatePicker(Calendar initialDate, Calendar minDate, Calendar maxDate,
                      Callback errorCallback, Callback successCallback) {
        isCalled = false;
        mErrorCallback = errorCallback;
        mSuccessCallback = successCallback;
        mInitialDate = initialDate;
        mMinDate = minDate;
        mMaxDate = maxDate;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year = mInitialDate.get(Calendar.YEAR);
        int month = mInitialDate.get(Calendar.MONTH);
        int day = mInitialDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog picker = new DatePickerDialog(getActivity(), this, year, month, day);

        if (mMinDate != null) {
            picker.getDatePicker().setMinDate(mMinDate.getTimeInMillis());
        }

        if (mMaxDate != null) {
            picker.getDatePicker().setMaxDate(mMaxDate.getTimeInMillis());
        }

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
