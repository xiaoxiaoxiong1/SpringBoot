package org.mybatis.tool;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Created by Administrator on 2019/2/2.
 * @DESC
 * @DATE 02
 */
public class ConditionsManager {

    public static void main(String args[]){
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list);

        CopyOnWriteArraySet<String> set=new CopyOnWriteArraySet<>();
        set.add("1");
        set.add("2");

        System.out.println(set
        );
    }
}
