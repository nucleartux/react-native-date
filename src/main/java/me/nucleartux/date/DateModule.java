package me.nucleartux.date;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import android.support.v4.app.DialogFragment;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;

public class DateModule extends ReactContextBaseJavaModule {
  private FragmentActivity mActivity = null;

  public DateModule(ReactApplicationContext reactContext, FragmentActivity activity) {
    super(reactContext);
    mActivity = activity;
  }

  @Override
  public String getName() {
    return "DateAndroid";
  }

  @ReactMethod
  public void showDatepicker(Callback errorCallback, Callback successCallback) {
    this.showDatepickerWithInitialDate(null, errorCallback, successCallback);
  }

  @ReactMethod
  public void showDatepickerWithInitialDate(String initialDateString, Callback errorCallback, Callback successCallback) {
    DialogFragment dateDialog = new DatePicker(parseDate(initialDateString), errorCallback, successCallback);
    dateDialog.show(mActivity.getSupportFragmentManager(), "datePicker");
  }

  @ReactMethod
  public void showTimepicker(Callback errorCallback, Callback successCallback) {
    this.showTimepickerWithInitialDate(null, errorCallback, successCallback);
  }

  @ReactMethod
  public void showTimepickerWithInitialDate(String initialDateString, Callback errorCallback, Callback successCallback) {
    DialogFragment dateDialog = new TimePicker(parseDate(initialDateString), errorCallback, successCallback);
    dateDialog.show(mActivity.getSupportFragmentManager(), "timePicker");
  }

  private Calendar parseDate(String date)
  {
    Calendar initialDate = null;

    if (date != null && date != "")
    {
      SimpleDateFormat df = new SimpleDateFormat();

      try
      {
        initialDate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        initialDate.setTime(sdf.parse(date));
      }
      catch (ParseException e)
      {
        return null;
      }
    }

    return initialDate;
  }
}
