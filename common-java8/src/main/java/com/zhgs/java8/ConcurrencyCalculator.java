package com.zhgs.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;

/**
 * 功能描述：
 *
 * @Auther: zhouguangsheng
 * @Date: 2020/3/5 10:41
 */
public class ConcurrencyCalculator extends RecursiveTask<Integer>

{
    private final int start;
    private final int end;
    private final static int THRESHOLD = 6;

    public ConcurrencyCalculator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if ((end - start) < THRESHOLD) {
            for (int x = start; x < end; x++) {
                result += x;
            }
        } else {
            int middle = (start + end) / 2;
            ConcurrencyCalculator leftCalculator = new ConcurrencyCalculator(start, middle);
            ConcurrencyCalculator rightCalculator = new ConcurrencyCalculator(middle, end);
            leftCalculator.fork();
            rightCalculator.fork();
            result += (leftCalculator.join() + rightCalculator.join());
        }
        return result;
    }

    public static void main(String[] args) {
        Consumer<Object> consumer = System.out::print;
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        int result = 0;
        for(Integer v : list){
            result +=v;
        }
        consumer.accept(result);
        consumer.accept("-------------->");

        ConcurrencyCalculator calculator = new ConcurrencyCalculator(0,10);
        consumer.accept(calculator.compute()+"->");
    }

}
