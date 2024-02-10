package io.github.danilopiazza.benchmark.bigdecimal;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(time = 1, timeUnit = TimeUnit.SECONDS)
public class BigDecimalVsFloatingPoint {
    @Benchmark
    public void sumBigDecimalFromDouble(Blackhole blackhole) {
        BigDecimal d1 = BigDecimal.valueOf(0.1);
        BigDecimal d2 = BigDecimal.valueOf(0.2);
        BigDecimal d3 = d1.add(d2);
        blackhole.consume(d3);
    }

    @Benchmark
    public void sumBigDecimalFromString(Blackhole blackhole) {
        BigDecimal d1 = new BigDecimal("0.1");
        BigDecimal d2 = new BigDecimal("0.2");
        BigDecimal d3 = d1.add(d2);
        blackhole.consume(d3);
    }

    @Benchmark
    public void sumBigDecimalFromLong(Blackhole blackhole) {
        BigDecimal d1 = BigDecimal.valueOf(1, 1);
        BigDecimal d2 = BigDecimal.valueOf(2, 1);
        BigDecimal d3 = d1.add(d2);
        blackhole.consume(d3);
    }

    @State(Scope.Benchmark)
    public static class DoubleInput {
        public double augend = 0.1;
        public double addend = 0.2;
    }

    @Benchmark
    public void sumDouble(Blackhole blackhole, DoubleInput input) {
        double d1 = input.augend;
        double d2 = input.addend;
        double d3 = d1 + d2;
        blackhole.consume(d3);
    }

    @State(Scope.Benchmark)
    public static class FloatInput {
        public float augend = 0.1f;
        public float addend = 0.2f;
    }

    @Benchmark
    public void sumFloat(Blackhole blackhole, FloatInput input) {
        float f1 = input.augend;
        float f2 = input.addend;
        float f3 = f1 + f2;
        blackhole.consume(f3);
    }

    @Benchmark
    public void constantDouble(Blackhole blackhole) {
        blackhole.consume(0.3);
    }

    @Benchmark
    public void constantFloat(Blackhole blackhole) {
        blackhole.consume(0.3f);
    }
}
