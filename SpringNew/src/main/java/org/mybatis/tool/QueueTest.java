package org.mybatis.tool;

import org.junit.Test;
import org.mybatis.entity.Student;
import sun.dc.pr.PRError;

import java.util.PriorityQueue;

/**
 * @Created by Administrator on 2019/2/9.
 * @DESC
 * @DATE 09
 */
public class QueueTest {

    @Test
    public void priortest(){
        PriorityQueue<Student>  priorityQueues=new PriorityQueue<>();
        Student student=new Student();
        student.setName("xionghao");
        student.setScore(1);
        Student student2=new Student();
        student2.setName("xiongying");
        student2.setScore(3);
        priorityQueues.add(student);
        priorityQueues.offer(student2);

        while (!priorityQueues.isEmpty()){
            System.out.println(priorityQueues.poll());
        }

    }
}
