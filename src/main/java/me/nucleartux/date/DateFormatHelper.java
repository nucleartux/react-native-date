package me.nucleartux.date;

import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateFormatHelper {
  public static Calendar parseDate(String date) {
    Calendar initialDate = Calendar.getInstance();

    if (date != null && !date.equals(""))
    {
      try
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
        initialDate.setTime(sdf.parse(date));
      }
      catch (ParseException e)
      {
        return Calendar.getInstance();
      }
    }

    return initialDate;
  }

  public static Calendar parseDateInMilliseconds(long ms) {
    Calendar initialDate = Calendar.getInstance();

    if (ms > 0)
    {
      try
      {
        initialDate.setTimeInMillis(ms);
      }
      catch (Exception e)
      {
        return Calendar.getInstance();
      }
    }

    return initialDate;
  }
}
