# reactor-test-test

## TestNG

Configuration:

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.2</version>
    <configuration>
        <groups>unit</groups>
        <includes>
            <include>**/*Test.java</include>
        </includes>
        <parallel>methods</parallel>
        <threadCount>2</threadCount>
        <trimStackTrace>false</trimStackTrace>
    </configuration>
</plugin>
```

`mvn -T 1C clean test`

```
[INFO] Running com.github.hisener.StepVerifierTest
[ERROR] Tests run: 2, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 5.254 s <<< FAILURE! - in com.github.hisener.StepVerifierTest
[ERROR] testB(com.github.hisener.StepVerifierTest)  Time elapsed: 0.039 s  <<< FAILURE!
java.lang.NullPointerException: timedScheduler
	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
	at reactor.core.publisher.MonoDelayElement.<init>(MonoDelayElement.java:50)
	at reactor.core.publisher.Mono.delayElement(Mono.java:1847)
	at reactor.core.publisher.Mono.delayElement(Mono.java:1827)
	at com.github.hisener.StepVerifierTest.testB(StepVerifierTest.java:21)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:124)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:583)
	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:719)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:989)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:834)

[ERROR] testA(com.github.hisener.StepVerifierTest)  Time elapsed: 0.042 s  <<< FAILURE!
reactor.core.Exceptions$ReactorRejectedExecutionException: Scheduler unavailable
	at reactor.core.Exceptions.failWithRejected(Exceptions.java:249)
	at reactor.core.publisher.Operators.onRejectedExecution(Operators.java:807)
	at reactor.core.publisher.MonoDelayElement$DelayElementSubscriber.onNext(MonoDelayElement.java:126)
	at reactor.core.publisher.Operators$ScalarSubscription.request(Operators.java:2071)
	at reactor.core.publisher.MonoDelayElement$DelayElementSubscriber.onSubscribe(MonoDelayElement.java:111)
	at reactor.core.publisher.MonoJust.subscribe(MonoJust.java:54)
	at reactor.core.publisher.MonoDelayElement.subscribe(MonoDelayElement.java:55)
	at reactor.core.publisher.Mono.subscribe(Mono.java:3852)
	at reactor.test.DefaultStepVerifierBuilder$DefaultStepVerifier.verify(DefaultStepVerifierBuilder.java:801)
	at reactor.test.DefaultStepVerifierBuilder$DefaultStepVerifier.verify(DefaultStepVerifierBuilder.java:772)
	at com.github.hisener.StepVerifierTest.testA(StepVerifierTest.java:17)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:124)
	at org.testng.internal.Invoker.invokeMethod(Invoker.java:583)
	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:719)
	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:989)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:834)
Caused by: java.util.concurrent.RejectedExecutionException: Scheduler unavailable
	at reactor.core.Exceptions.<clinit>(Exceptions.java:502)
	at reactor.test.scheduler.VirtualTimeScheduler.schedule(VirtualTimeScheduler.java:257)
	at reactor.core.scheduler.Schedulers$CachedScheduler.schedule(Schedulers.java:783)
	at reactor.core.publisher.MonoDelayElement$DelayElementSubscriber.onNext(MonoDelayElement.java:123)
	... 21 more

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Failures: 
[ERROR]   StepVerifierTest.testA:17 » ReactorRejectedExecution Scheduler unavailable
[ERROR]   StepVerifierTest.testB:21 » NullPointer timedScheduler
[INFO] 
[ERROR] Tests run: 2, Failures: 2, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
```

## Junit 5

Configuration:

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.22.2</version>
    <configuration>
        <properties>
            <configurationParameters>
                junit.jupiter.execution.parallel.enabled = true
                junit.jupiter.execution.parallel.mode.default = concurrent
            </configurationParameters>
        </properties>
        <trimStackTrace>false</trimStackTrace>
    </configuration>
</plugin>
```

`mvn -T 1C clean test`

```
[INFO] Running com.github.hisener.StepVerifierTest
[ERROR] Tests run: 2, Failures: 0, Errors: 2, Skipped: 0, Time elapsed: 0.059 s <<< FAILURE! - in com.github.hisener.StepVerifierTest
[ERROR] testA  Time elapsed: 0.051 s  <<< ERROR!
java.lang.NullPointerException: timedScheduler
	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
	at reactor.core.publisher.MonoDelayElement.<init>(MonoDelayElement.java:50)
	at reactor.core.publisher.Mono.delayElement(Mono.java:1847)
	at reactor.core.publisher.Mono.delayElement(Mono.java:1827)
	at com.github.hisener.StepVerifierTest.lambda$testA$0(StepVerifierTest.java:13)
	at reactor.test.DefaultStepVerifierBuilder$DefaultStepVerifier.verify(DefaultStepVerifierBuilder.java:788)
	at reactor.test.DefaultStepVerifierBuilder$DefaultStepVerifier.verify(DefaultStepVerifierBuilder.java:772)
	at com.github.hisener.StepVerifierTest.testA(StepVerifierTest.java:17)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:675)
	at org.junit.jupiter.engine.execution.MethodInvocation.proceed(MethodInvocation.java:60)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:125)
	at org.junit.jupiter.engine.extension.TimeoutExtension.intercept(TimeoutExtension.java:132)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestableMethod(TimeoutExtension.java:124)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestMethod(TimeoutExtension.java:74)
	at org.junit.jupiter.engine.execution.ExecutableInvoker$ReflectiveInterceptorCall.lambda$ofVoidMethod$0(ExecutableInvoker.java:115)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.lambda$invoke$0(ExecutableInvoker.java:105)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:104)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.proceed(InvocationInterceptorChain.java:62)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.chainAndInvoke(InvocationInterceptorChain.java:43)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.invoke(InvocationInterceptorChain.java:35)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:104)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:98)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$6(TestMethodTestDescriptor.java:202)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:198)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:135)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:69)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:135)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at org.junit.platform.engine.support.hierarchical.ForkJoinPoolHierarchicalTestExecutorService$ExclusiveTask.compute(ForkJoinPoolHierarchicalTestExecutorService.java:171)
	at java.base/java.util.concurrent.RecursiveAction.exec(RecursiveAction.java:189)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:177)

[ERROR] testB  Time elapsed: 0.052 s  <<< ERROR!
reactor.core.Exceptions$ReactorRejectedExecutionException: Scheduler unavailable
	at reactor.core.Exceptions.failWithRejected(Exceptions.java:249)
	at reactor.core.publisher.Operators.onRejectedExecution(Operators.java:807)
	at reactor.core.publisher.MonoDelayElement$DelayElementSubscriber.onNext(MonoDelayElement.java:126)
	at reactor.core.publisher.Operators$ScalarSubscription.request(Operators.java:2071)
	at reactor.core.publisher.MonoDelayElement$DelayElementSubscriber.onSubscribe(MonoDelayElement.java:111)
	at reactor.core.publisher.MonoJust.subscribe(MonoJust.java:54)
	at reactor.core.publisher.MonoDelayElement.subscribe(MonoDelayElement.java:55)
	at reactor.core.publisher.Mono.subscribe(Mono.java:3852)
	at reactor.test.DefaultStepVerifierBuilder$DefaultStepVerifier.verify(DefaultStepVerifierBuilder.java:801)
	at reactor.test.DefaultStepVerifierBuilder$DefaultStepVerifier.verify(DefaultStepVerifierBuilder.java:772)
	at com.github.hisener.StepVerifierTest.testB(StepVerifierTest.java:26)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:675)
	at org.junit.jupiter.engine.execution.MethodInvocation.proceed(MethodInvocation.java:60)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:125)
	at org.junit.jupiter.engine.extension.TimeoutExtension.intercept(TimeoutExtension.java:132)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestableMethod(TimeoutExtension.java:124)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestMethod(TimeoutExtension.java:74)
	at org.junit.jupiter.engine.execution.ExecutableInvoker$ReflectiveInterceptorCall.lambda$ofVoidMethod$0(ExecutableInvoker.java:115)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.lambda$invoke$0(ExecutableInvoker.java:105)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:104)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.proceed(InvocationInterceptorChain.java:62)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.chainAndInvoke(InvocationInterceptorChain.java:43)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.invoke(InvocationInterceptorChain.java:35)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:104)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:98)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$6(TestMethodTestDescriptor.java:202)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:198)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:135)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:69)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:135)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at org.junit.platform.engine.support.hierarchical.ForkJoinPoolHierarchicalTestExecutorService$ExclusiveTask.compute(ForkJoinPoolHierarchicalTestExecutorService.java:171)
	at java.base/java.util.concurrent.RecursiveAction.exec(RecursiveAction.java:189)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:290)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1020)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1656)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1594)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:177)
Caused by: java.util.concurrent.RejectedExecutionException: Scheduler unavailable
	at reactor.core.Exceptions.<clinit>(Exceptions.java:502)
	at reactor.test.scheduler.VirtualTimeScheduler.schedule(VirtualTimeScheduler.java:257)
	at reactor.core.scheduler.Schedulers$CachedScheduler.schedule(Schedulers.java:783)
	at reactor.core.publisher.MonoDelayElement$DelayElementSubscriber.onNext(MonoDelayElement.java:123)
	... 46 more

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   StepVerifierTest.testA:17->lambda$testA$0:13 » NullPointer timedScheduler
[ERROR]   StepVerifierTest.testB:26 » ReactorRejectedExecution Scheduler unavailable
[INFO] 
[ERROR] Tests run: 2, Failures: 0, Errors: 2, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
```
