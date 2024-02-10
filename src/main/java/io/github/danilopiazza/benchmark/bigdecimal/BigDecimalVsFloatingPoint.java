package io.github.danilopiazza.benchmark.bigdecimal;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
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

    @Benchmark
    public void sumDouble(Blackhole blackhole) {
        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = d1 + d2;
        blackhole.consume(d3);
    }

    @Benchmark
    public void sumFloat(Blackhole blackhole) {
        float f1 = 0.1f;
        float f2 = 0.2f;
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
