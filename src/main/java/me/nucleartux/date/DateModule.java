package me.nucleartux.date;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.util.Map;
import java.util.HashMap;

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
    DialogFragment dateDialog = new DatePicker(errorCallback, successCallback);
    dateDialog.show(mActivity.getSupportFragmentManager(), "datePicker");
  }

  @ReactMethod
  public void showTimepicker(Callback errorCallback, Callback successCallback) {
    DialogFragment dateDialog = new TimePicker(errorCallback, successCallback);
    dateDialog.show(mActivity.getSupportFragmentManager(), "timePicker");
  }
}