package com.pratamawijaya.blog.domain.interactor;

import com.pratamawijaya.blog.domain.executor.PostExecutionThread;
import com.pratamawijaya.blog.domain.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by pratama
 * Date : Mar - 3/23/17
 * Project Name : blogreader
 */
@RunWith(MockitoJUnitRunner.class) public class UseCaseTest {

  private UseCaseTestClass useCase;

  private TestDisposableObserver<Object> testObserver;

  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private PostExecutionThread mockPostExecutionThread;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Before public void setUp() {
    this.useCase = new UseCaseTestClass(mockThreadExecutor, mockPostExecutionThread);
    this.testObserver = new TestDisposableObserver<>();
    given(mockPostExecutionThread.getScheduler()).willReturn(new TestScheduler());
  }

  @Test public void testBuildUseCaseObservableReturnCorrectResult() {
    useCase.execute(testObserver, Params.EMPTY);

    assertThat(testObserver.valuesCount).isZero();
  }

  @Test public void testSubscriptionWhenExecutingUseCase() {
    useCase.execute(testObserver, Params.EMPTY);
    useCase.dispose();

    assertThat(testObserver.isDisposed()).isTrue();
  }

  @Test public void testShouldFailWhenExecuteWithNullObserver() {
    expectedException.expect(NullPointerException.class);
    useCase.execute(null, Params.EMPTY);
  }

  private static class UseCaseTestClass extends UseCase<Object, Params> {

    UseCaseTestClass(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
      super(threadExecutor, postExecutionThread);
    }

    @Override public Observable<Object> buildUseCaseObservable(Params params) {
      return Observable.empty();
    }

    @Override public void execute(DisposableObserver<Object> observer, Params params) {
      super.execute(observer, params);
    }
  }

  private static class TestDisposableObserver<T> extends DisposableObserver<T> {
    private int valuesCount = 0;

    @Override public void onNext(T value) {
      valuesCount++;
    }

    @Override public void onError(Throwable e) {
      // no-op by default.
    }

    @Override public void onComplete() {
      // no-op by default.
    }
  }

  private static class Params {
    private static Params EMPTY = new Params();

    private Params() {
    }
  }
}