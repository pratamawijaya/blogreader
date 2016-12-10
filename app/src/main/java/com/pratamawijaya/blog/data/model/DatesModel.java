package com.pratamawijaya.blog.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public class DatesModel {
  @SerializedName("maximum") @Expose private Date maximum;
  @SerializedName("minimum") @Expose private Date minimum;

  public Date getMaximum() {
    return maximum;
  }

  public void setMaximum(Date maximum) {
    this.maximum = maximum;
  }

  public Date getMinimum() {
    return minimum;
  }

  public void setMinimum(Date minimum) {
    this.minimum = minimum;
  }
}
