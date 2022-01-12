/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurrency;

/*
 *
 *
 * @author mike
 */
public class Concurrency {

    public static void main(String[] args) throws InterruptedException {
        int lowerLimit = 0;
        int upperLimit = 20;
        Thread upCounter;
        upCounter = new Thread(new RunnableImpl(lowerLimit, upperLimit));
        upCounter.start();
        upCounter.join();
        Thread downCounter;
        downCounter = new Thread(new RunnableImpl1(upperLimit, lowerLimit));
        downCounter.start();
        downCounter.join();
    }

    static class RunnableImpl implements Runnable {

        private final int lowerLimit;
        private final int upperLimit;

        public RunnableImpl(int lowerLimit, int upperLimit) {
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        @Override
        public void run() {
            for(int i = lowerLimit; i <= upperLimit; i++) {
                System.out.println(i);
            }
        }
    }

    static class RunnableImpl1 implements Runnable {

        private final int upperLimit;
        private final int lowerLimit;

        public RunnableImpl1(int upperLimit, int lowerLimit) {
            this.upperLimit = upperLimit;
            this.lowerLimit = lowerLimit;
        }

        @Override
        public void run() {
            for(int i = upperLimit-1; i >= lowerLimit; i--) {
                System.out.println(i);
            }
        }
    }

}