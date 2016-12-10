package com.pratamawijaya.blog.domain.executor;

import java.util.concurrent.Executor;

/**
 * Created by pratama on 9/30/16.
 */

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * {@link UseCase} out of the UI thread.
 */
public interface ThreadExecutor extends Executor {
}
