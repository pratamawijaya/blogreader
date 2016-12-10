package com.pratamawijaya.blog.data.exception;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/18/16
 * Project Name : MoviesInfoKotlin
 */

public class NetworkConnectionException extends Exception {

  public NetworkConnectionException() {
    super();
  }

  public NetworkConnectionException(final String message) {
    super(message);
  }

  public NetworkConnectionException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public NetworkConnectionException(final Throwable cause) {
    super(cause);
  }
}
