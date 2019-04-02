package rx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Starstar Sun
 * @date 2019/1/20
 * @Description:
 **/
@Slf4j
public class RxDemo {

    @Test
    public void test1() {
        Observable<String> novel = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        });

        Observer<String> reader = new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                log.info( "onSubscribe");
            }

            @Override
            public void onNext(String value) {
                if ("2".equals(value)) {
                    return;
                }
                log.info("onNext:" + value);
            }

            @Override
            public void onError(Throwable e) {
                log.info( "onError=" + e.getMessage());
            }

            @Override
            public void onComplete() {
                log.info("onComplete()");
            }
        };

        Observer<String> reader2 = new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                log.info( "onSubscribe on reader2");
            }

            @Override
            public void onNext(String value) {
                if ("2".equals(value)) {
                    return;
                }
                log.info("onNext  on reader2:" + value);
            }

            @Override
            public void onError(Throwable e) {
                log.info( "onError  on reader2 =" + e.getMessage());
            }

            @Override
            public void onComplete() {
                log.info("onComplete()  on reader2");
            }
        };

        novel.subscribe(reader);
        novel.subscribe(reader2);
    }

}
