package com.github.hisener;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class StepVerifierTest {
    private static final Duration DELAY = Duration.ofSeconds(1);

    @Test
    void testA() {
        StepVerifier.withVirtualTime(() -> Mono.just(1).delayElement(DELAY))
                .thenAwait(DELAY)
                .expectNext(1)
                .expectComplete()
                .verify();
    }

    @Test
    void testB() {
        StepVerifier.create(Mono.just(1).delayElement(DELAY))
                .thenAwait(DELAY)
                .expectNext(1)
                .expectComplete()
                .verify();
    }
}
