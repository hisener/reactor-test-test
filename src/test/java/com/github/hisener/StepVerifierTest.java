package com.github.hisener;

import java.time.Duration;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Test(groups = "unit")
public class StepVerifierTest {
    private static final Duration DELAY = Duration.ofSeconds(1);

    public void testA() {
        StepVerifier.withVirtualTime(() -> Mono.just(1).delayElement(DELAY))
                .thenAwait(DELAY)
                .expectNext(1)
                .expectComplete()
                .verify();
    }

    public void testB() {
        StepVerifier.create(Mono.just(1).delayElement(DELAY))
                .thenAwait(DELAY)
                .expectNext(1)
                .expectComplete()
                .verify();
    }
}
