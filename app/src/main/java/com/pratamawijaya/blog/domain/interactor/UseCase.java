package com.pratamawijaya.blog.domain.interactor;

import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by pratama on 9/26/16.
 */

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link Subscriber}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class UseCase {

  private final ThreadExecutor threadExecutor;
  private final PostExecutionThread postExecutionThread;

  private Subscription subscription = Subscriptions.empty();

  protected UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    this.threadExecutor = threadExecutor;
    this.postExecutionThread = postExecutionThread;
  }

  /**
   * Executes the current use case.
   *
   * @param useCaseSubscriber The guy who will be listen to the observable build
   * with {@link #buildObservableUseCase()}
   */
  @SuppressWarnings("unchecked") public void execute(Subscriber useCaseSubscriber) {
    this.subscription = this.buildObservableUseCase()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler())
        .subscribe(useCaseSubscriber);
  }

  /**
   * Unsubscribes from current {@link Subscription}.
   */
  public void unsubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }

  /**
   * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
   */
  protected abstract Observable buildObservableUseCase();
}
