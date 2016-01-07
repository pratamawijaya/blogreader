package com.pratamawijaya.blog.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import timber.log.Timber;

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 1/7/16
 * Project : PratamaBlog
 */
public class GsonDateDeSerializer implements JsonDeserializer<DateTime> {
  private DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    try {
      String jsonString = json.getAsJsonPrimitive().getAsString();
      return parseDate(jsonString);
    } catch (Exception e) {
      Timber.e("deserialize(): jsonparseexception " + e.getLocalizedMessage());
      throw new JsonParseException(e.getLocalizedMessage(), e);
    }
  }

  private DateTime parseDate(String dateString) {
    if (dateString != null && dateString.trim().length() > 0) {
      try {
        return format.parseDateTime(dateString);
      } catch (Exception e) {
        Timber.e("parseDate(): cant format date " + e.getLocalizedMessage());
      }
    }
    return null;
  }
}