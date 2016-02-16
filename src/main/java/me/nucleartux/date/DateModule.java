package me.nucleartux.date;

import android.app.DialogFragment;
import android.app.Activity;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class DateModule extends ReactContextBaseJavaModule {

  public DateModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "DateAndroid";
  }

  @ReactMethod
  public void showDatepicker(Callback errorCallback, Callback successCallback) {
    this.showDatepickerWithInitialDate(null, null, errorCallback, successCallback);
  }

  @ReactMethod
  public void showDatepickerWithInitialDate(String dateTimeFormat, String initialDateString, Callback errorCallback,
                                            Callback successCallback) {
    DialogFragment dateDialog = new DatePicker(DateFormatHelper.parseDate(initialDateString, dateTimeFormat),
            errorCallback, successCallback);
    Activity activity = getCurrentActivity();
    if (activity != null) {
      dateDialog.show(activity.getFragmentManager(), "datePicker");
    }
  }

  @ReactMethod
  public void showDatepickerWithInitialMinMaxDate(String dateTimeFormat, String initialDateString,
            String minDateString, String maxDateString, Callback errorCallback,
            Callback successCallback) {
    DialogFragment dateDialog = new DatePicker(DateFormatHelper.parseDate(initialDateString, dateTimeFormat),
            DateFormatHelper.parseDate(minDateString, dateTimeFormat),
            DateFormatHelper.parseDate(maxDateString, dateTimeFormat),
            errorCallback, successCallback);
    Activity activity = getCurrentActivity();
    if (activity != null) {
      dateDialog.show(activity.getFragmentManager(), "datePicker");
    }
  }

  @ReactMethod
  public void showTimepicker(Callback errorCallback, Callback successCallback) {
    this.showTimepickerWithInitialTime(null, null, errorCallback, successCallback);
  }

  @ReactMethod
  public void showTimepickerWithInitialTime(String dateTimeFormat, String initialDateString, Callback errorCallback,
                                            Callback successCallback) {
    DialogFragment dateDialog = new TimePicker(DateFormatHelper.parseDate(initialDateString, dateTimeFormat),
            errorCallback, successCallback);
    Activity activity = getCurrentActivity();
    if (activity != null) {
      dateDialog.show(activity.getFragmentManager(), "datePicker");
    }
  }
}
