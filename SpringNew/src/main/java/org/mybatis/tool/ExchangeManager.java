package org.mybatis.tool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Created by Administrator on 2019/2/2.
 * @DESC
 * @DATE 02
 */
public class ExchangeManager {
    private static volatile boolean isDone = false;


    public static void main(String args[]){

        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<Integer> exchanger = new Exchanger<Integer>();
        ExchangerProduct producer = new ExchangerProduct(exchanger);
        ConsumerChanager consumer = new ConsumerChanager(exchanger);
        exec.execute(producer);
        exec.execute(consumer);

        exec.shutdown();
    }



    static class ExchangerProduct implements Runnable{

        private Exchanger<Integer> exchanger;
        public ExchangerProduct( Exchanger<Integer> exchanger){
            this.exchanger=exchanger;

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
            TimeUnit.SECONDS.toSeconds(1);
            int data=0;
            for(int i=0;i<3;i++) {
                try {
                    data = exchanger.exchange(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isDone=true;
            System.out.println("producer after: " + data);
        }
    }


    static class ConsumerChanager implements Runnable{
        private Exchanger<Integer>  exchanger;

        public ConsumerChanager(Exchanger exchanger){
            this.exchanger=exchanger;
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
            TimeUnit.SECONDS.toSeconds(1);
            int data=0;


            System.out.println("comsume after: " + data);
            while (!Thread.interrupted() && !isDone) {
                data = 0;
                System.out.println("consumer before : " + data);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    data = exchanger.exchange(data);
                } catch (InterruptedException e) {

                }
                System.out.println("consumer after : " + data);
            }
        }
    }
}
