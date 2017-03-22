package com.pratamawijaya.blog.domain.interactor;

import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pratama on 9/26/16.
 */

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link
 * DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
public abstract class UseCase<T, Params> {

  private final ThreadExecutor threadExecutor;
  private final PostExecutionThread postExecutionThread;
  private final CompositeDisposable disposables;

  public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    this.threadExecutor = threadExecutor;
    this.postExecutionThread = postExecutionThread;
    this.disposables = new CompositeDisposable();
  }

  /**
   * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
   */
  public abstract Observable<T> buildUseCaseObservable(Params params);

  /**
   * Executes the current use case.
   *
   * @param observer {@link DisposableObserver} which will be listening to the observable build
   * by {@link #buildUseCaseObservable(Params)} ()} method.
   * @param params Parameters (Optional) used to build/execute this use case.
   */
  public void execute(DisposableObserver<T> observer, Params params) {
    Preconditions.checkNotNull(observer);
    final Observable<T> observable = this.buildUseCaseObservable(params)
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler());
    addDisposable(observable.subscribeWith(observer));
  }

  /**
   * Dispose from current {@link CompositeDisposable}.
   */
  public void dispose() {
    if (!disposables.isDisposed()) {
      disposables.dispose();
    }
  }

  /**
   * Dispose from current {@link CompositeDisposable}.
   */
  private void addDisposable(Disposable disposable) {
    Preconditions.checkNotNull(disposable);
    Preconditions.checkNotNull(disposables);
    disposables.add(disposable);
  }
}