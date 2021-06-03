package com.ganzhenghao.springbootwebfluxstudy;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/2 14:49
 */
public class WebFluxTest {


    /**
     * 直接just一些元素
     */
    @Test
    public void createFlux_Just() {
        Flux<String> flux = Flux.just("a", "b", "c");
        /*这里传递给subscribe()方法的lambda表达式实际上是一个java.util.Consumer，用来创建反应式流的Subscriber。在调用subscribe()之后，数据会开始流动。在这个例子中，没有中间操作，所以数据从Flux直接流向订阅者。*/
        flux.subscribe(s -> System.out.println("flux element ... " + s));

        /*
        对于给定的Flux或Mono，StepVerifier将会订阅该反应式类型，在数据流过时对数据应用断言，并在最后验证反应式流是否按预期完成。

        元素个数和顺序要一致
        */
        StepVerifier.create(flux)
                .expectNext("a")
                .expectNext("b")
                .expectNext("c")
                .verifyComplete();
    }

    /**
     * 根据数组创建通量表单
     */
    @Test
    public void createFluxFormArray() {
        String[] elements = {"a","b","c"};
        Flux<String> flux = Flux.fromArray(elements);
        flux.subscribe(s -> System.out.println("flux element ... " + s));
    }


    /**
     * 根据集合创建通量表单
     */
    @Test
    public void createFluxFormIterable() {
        List<String> list = List.of("a", "b", "c");
        Flux<String> flux = Flux.fromIterable(list);
        flux.subscribe(s -> System.out.println("flux element ... " + s));
    }

    /**
     * 根据流创建通量表单
     */
    @Test
    public void createFluxFormStream() {
        List<String> list = List.of("a", "b", "c");
        Stream<String> stream = list.stream();
        Flux<String> flux = Flux.fromStream(stream);
        flux.subscribe(s -> System.out.println("flux element ... " + s));
    }

    /**
     * 创建计数器 flux
     */
    @Test
    public void createRangeFlux() {

        Flux<Integer> flux = Flux.range(1, 3);
        flux.subscribe(s -> System.out.println("flux element ... " + s));

    }



    @Test
    public void createIntervalFlux() {
    /*
    另一个与range()方法类似的Flux创建方法是interval()。与range()方法一样，interval()方法会创建一个发布递增值的Flux。interval()的特殊之处在于，我们不是给它设置一个起始值和结束值，而是指定一个应该每隔多长时间发出值的间隔时间。
     */
        Flux<Long> flux = Flux.interval(Duration.ofSeconds(1)).take(7);

/*        通过interval()方法创建的Flux会从0开始发布值，并且后续的条目依次递增。此外，因为interval()方法没有指定最大值，所以它可能会永远运行。我们也可以使用take()方法将结果限制为前5个条目*/
        flux.subscribe(s -> System.out.println("flux element ... " + s));

    }


    @Test
    public void mergeWith() {
        /*
        假设我们有两个Flux流，并且需要据此创建一个结果Flux，
        这个形成的Flux会在任意上游Flux流有数据时产生数据。
        要将一个Flux与另一个Flux合并，可以使用mergeWith()方法，
        */

        /*通常，Flux会尽可能快地发布数据。因此，我们在创建的两个Flux流上使用delayElements()方法来减慢它们的速度——每500毫秒发布一个条目。此外，为了使食物Flux在角色名称Flux之后再开始流式传输，我们调用Flux上的delaySubscription()方法，以便它在订阅后再经过250毫秒后才开始发布数据。*/
        Flux<?> flux1 = Flux.just(1, 2, 3).delayElements(Duration.ofMillis(10));
        Flux<?> flux2 = Flux.just("a", "b", "c");

        //Flux<?> flux3 = flux1.mergeWith(flux2);


        //flux3.subscribe(s -> System.out.println("flux element ... " + s));



    }


}
