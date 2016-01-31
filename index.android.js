/**
 * @providesModule DateAndroid
 */

'use strict';

/**
 * This exposes the native DatePicker module as a JS module. This has the static functions:
 *
 * showDatepicker(Callback errorCallback, Callback successCallback)
 * showDatepickerWithInitialDate(String initialDateString, Callback errorCallback, Callback successCallback)
 * showDatepickerWithInitialDateInMilliseconds(String initialDateString, Callback errorCallback, Callback successCallback)
 * showDatepickerWithInitialMinMaxDate(String initialDateString, String minDateString, String maxDateString, Callback errorCallback, Callback successCallback)
 *
 * showTimepicker(Callback errorCallback, Callback successCallback)
 * showTimepickerWithInitialTime(String initialDateString, Callback errorCallback, Callback successCallback)
 *
 * The DatePicker invokes the successCallback with: mSuccessCallback.invoke(year, month, day);
 * [The month comes from the `java.util.Calendar`, so it is going from 0-11]
 * The TimePicker invokes the successCallback with: mSuccessCallback.invoke(hour, minute);
 *
 */
var { NativeModules } = require('react-native');
module.exports = NativeModules.DateAndroid;
