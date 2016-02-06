package me.nucleartux.date;

import android.app.Activity;
import android.app.DialogFragment;

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
    this.showDatepickerWithInitialDate(null, errorCallback, successCallback);
  }

  @ReactMethod
  public void showDatepickerWithInitialDate(String initialDateString, Callback errorCallback,
                                            Callback successCallback) {
    DialogFragment dateDialog = new DatePicker(DateFormatHelper.parseDate(initialDateString),
            errorCallback, successCallback);
    Activity activity = getCurrentActivity();
    if (activity != null) {
      dateDialog.show(activity.getFragmentManager(), "datePicker");
    }
  }

  @ReactMethod
  public void showDatepickerWithInitialDateInMilliseconds(String initialDateString, Callback errorCallback,
                                            Callback successCallback) {
    DialogFragment dateDialog = new DatePicker(DateFormatHelper.parseDateInMilliseconds(Long.parseLong(initialDateString)),
            errorCallback, successCallback);
    Activity activity = getCurrentActivity();
    if (activity != null) {
      dateDialog.show(activity.getFragmentManager(), "datePicker");
    }
  }

  @ReactMethod
  public void showDatepickerWithInitialMinMaxDate(String initialDateString,
            String minDateString, String maxDateString, Callback errorCallback,
            Callback successCallback) {
    DialogFragment dateDialog = new DatePicker(DateFormatHelper.parseDate(initialDateString),
            DateFormatHelper.parseDate(minDateString),
            DateFormatHelper.parseDate(maxDateString),
            errorCallback, successCallback);
    Activity activity = getCurrentActivity();
    if (activity != null) {
      dateDialog.show(activity.getFragmentManager(), "datePicker");
    }
  }

  @ReactMethod
  public void showTimepicker(Callback errorCallback, Callback successCallback) {
    this.showTimepickerWithInitialTime(null, errorCallback, successCallback);
  }

  @ReactMethod
  public void showTimepickerWithInitialTime(String initialDateString, Callback errorCallback,
                                            Callback successCallback) {
    DialogFragment dateDialog = new TimePicker(DateFormatHelper.parseDate(initialDateString),
            errorCallback, successCallback);
    Activity activity = getCurrentActivity();
    if (activity != null) {
      dateDialog.show(activity.getFragmentManager(), "timePicker");
    }
  }

    @ReactMethod
    public void showTimepickerWithInitialDateInMilliseconds(String initialDateString, Callback errorCallback,
                                              Callback successCallback) {
        DialogFragment dateDialog = new TimePicker(DateFormatHelper.parseDateInMilliseconds(Long.parseLong(initialDateString)),
                errorCallback, successCallback);
        dateDialog.show(mActivity.getFragmentManager(), "timePicker");
    }
}
