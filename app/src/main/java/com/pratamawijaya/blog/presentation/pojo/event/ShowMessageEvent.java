package com.pratamawijaya.blog.presentation.pojo.event;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class ShowMessageEvent {
  public String message;

  private ShowMessageEvent(Builder builder) {
    message = builder.message;
  }

  public static final class Builder {
    private String message;

    public Builder() {
    }

    public Builder message(String val) {
      message = val;
      return this;
    }

    public ShowMessageEvent build() {
      return new ShowMessageEvent(this);
    }
  }
}
