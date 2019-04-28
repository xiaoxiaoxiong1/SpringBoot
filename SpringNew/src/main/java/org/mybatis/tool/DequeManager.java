package org.mybatis.tool;

import org.junit.Test;
import springfox.documentation.service.ApiListing;

import java.util.ArrayDeque;

/**
 * @Created by Administrator on 2019/2/2.
 * @DESC
 * @DATE 02
 */
public class DequeManager {

    @Test
    public void  deque(){
        ArrayDeque<String>arrayDeque=new ArrayDeque<>();
        arrayDeque.push("3");
        arrayDeque.push("1");
        arrayDeque.push("2");
        System.out.println(arrayDeque);
        arrayDeque.pop();
        arrayDeque.addFirst("7");
        arrayDeque.addFirst("8");
        System.out.println(arrayDeque);
    }
}
