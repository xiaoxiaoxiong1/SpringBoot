package org.mybatis.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * @Created by Administrator on 2019/2/2.
 * @DESC
 * @DATE 02
 */
public class CyclicBarrierManager {


    public static void  main(String args[]){
        CyclicBarrier cyclicBarrier=new CyclicBarrier(9);
        for(int i=0;i<10;i++){
            Thread thread=new Thread(new Writer(cyclicBarrier));
            thread.start();

        }
    }

   static public class Writer  implements Runnable{
        private CyclicBarrier cyclicBarrier;
        public Writer(){}

        public Writer(CyclicBarrier cyclicBarrier){

            this.cyclicBarrier=cyclicBarrier;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p/>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println("开始执行线程");

            try{

                Thread.sleep(3000L);
            }catch (Exception e){
                e.printStackTrace();

            }
            try {
                cyclicBarrier.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("所有线程执行完毕");

        }
    }
}
