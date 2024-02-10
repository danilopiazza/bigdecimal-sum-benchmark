package io.github.danilopiazza.benchmark.bigdecimal;

import java.math.BigDecimal;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class BigDecimalVsFloatingPoint {
    @Benchmark
    public void sumBigDecimals(Blackhole blackhole) {
        BigDecimal d1 = BigDecimal.valueOf(0.1);
        BigDecimal d2 = BigDecimal.valueOf(0.2);
        BigDecimal d3 = d1.add(d2);
        blackhole.consume(d3);
    }

    @Benchmark
    public void sumDoubles(Blackhole blackhole) {
        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = d1 + d2;
        blackhole.consume(d3);
    }

    @Benchmark
    public void sumFloats(Blackhole blackhole) {
        float d1 = 0.1f;
        float d2 = 0.2f;
        float d3 = d1 + d2;
        blackhole.consume(d3);
    }
}
