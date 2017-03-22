package com.pratamawijaya.blog.utils;

import java.util.Collection;

/**
 * Created by pratama
 * Date : Mar - 3/22/17
 * Project Name : blogreader
 */

public final class Lists {
  public static <T> boolean isEmptyOrNull(Collection<T> list) {
    return list == null || list.isEmpty();
  }
}
