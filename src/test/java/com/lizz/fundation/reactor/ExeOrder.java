package com.lizz.fundation.reactor;

import io.reactivex.Observable;
import org.junit.Test;

/**
 * @description: doOnNext doFinally doAfterTerminate顺序
 * 离subscribe近的优先执行
 * @author: lizz
 * @date: 2020/11/17 17:56
 */
public class ExeOrder {
    @Test
    public void orderTester() {
        Observable.just("Hello Tester1")
                .doOnNext(s -> System.out.println("doOnNext：" + s))
                .doFinally(() -> System.out.println("doFinally1"))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate1"))
                .doFinally(() -> System.out.println("doFinally2"))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate2"))
                .subscribe(
                        s -> System.out.println("onNext：" + s),
                        throwable -> System.out.println("onError" + throwable),
                        () -> System.out.println("onComplete"));
        System.out.println("*******调整顺序**********");
        //调整顺序
        Observable.just("Hello Tester2")
                .doAfterTerminate(() -> System.out.println("doAfterTerminate1"))
                .doFinally(() -> System.out.println("doFinally1"))
                .doOnNext(s -> System.out.println("doOnNext：" + s))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate2"))
                .doFinally(() -> System.out.println("doFinally2"))
                .subscribe(
                        s -> System.out.println("onNext：" + s),
                        throwable -> System.out.println("onError" + throwable),
                        () -> System.out.println("onComplete"));
    }
}
