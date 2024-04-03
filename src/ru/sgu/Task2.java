package ru.sgu;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class Task2 extends RecursiveTask<BigInteger> {
    private final BigInteger n;

    public Task2(BigInteger n) {
        this.n = n;
    }

    @Override
    protected BigInteger compute() {
        if (n.compareTo(BigInteger.ONE) <= 0)
            return n;
        Task2 f1 = new Task2(n.subtract(BigInteger.ONE));
        f1.fork();
        Task2 f2 = new Task2(n.subtract(BigInteger.TWO));
        return f2.compute().add(f1.join());
    }
}
