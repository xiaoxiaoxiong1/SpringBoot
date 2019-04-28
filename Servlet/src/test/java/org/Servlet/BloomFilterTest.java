package org.Servlet;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.*;

/**
 * @Created by Administrator on 2019/1/26.
 * @DESC
 * @DATE 26
 */
public class BloomFilterTest {

    private static final  int capacity=100;

    private static final int key=999998;

    private static BloomFilter<Integer> bloomFilter=BloomFilter.create(Funnels.integerFunnel(),capacity);



    static {
        for (int i = 0; i < capacity; i++) {
            bloomFilter.put(i);
        }
    }

    public static void main(String[] args) {




        /*返回计算机最精确的时间，单位微妙*/
        List<Integer> list=new LinkedList<>();
        list.add(11);
        list.add(2);
        list.add(3);
        list.add(14);

        Collections.sort(list);
        long start = System.nanoTime();

        if (bloomFilter.mightContain(key)) {
            System.out.println("成功过滤到" + key);
        }
        long end = System.nanoTime();
        System.out.println("布隆过滤器消耗时间:" + (end - start));
        int sum = 0;
        for (int i = capacity + 20000; i < capacity + 30000; i++) {
            if (bloomFilter.mightContain(i)) {
                sum = sum + 1;
            }
        }
        System.out.println("错判率为:" + sum/10000.0);
    }


}
