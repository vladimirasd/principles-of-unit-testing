package testing;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static volatile boolean runningConsumer = false,
                                    runningProducer = false;

    private static final TransferQueue<String> queue = new LinkedTransferQueue<>();

    private static final int MAX_PROD_TIME = 5*1000,
                      MAX_CONS_TIME = 7*1000,
                      TIME_OUT = MAX_CONS_TIME + 1000;

    private static final Random rnd = new Random();

    static class Producer implements Runnable{

        private static AtomicInteger cnt = new AtomicInteger(0);

        @Override
        public void run(){
            System.out.println("Начало работы продюсера");
            while (runningProducer){
                try {
                    String bulb = "" + cnt.addAndGet(1);
                    boolean trans = queue.tryTransfer(bulb, TIME_OUT, TimeUnit.MILLISECONDS);
                    if(trans){
                        System.out.println("Проверена : " + bulb);
                    }
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println("Исключение : " + e.getLocalizedMessage());
                    break;
                }
            }
        }
    }

    static class Consumer implements Runnable{
        @Override
        public void run(){
            System.out.println("Начало работы консумера");
            while (runningConsumer){
                try {
                    String bulb = queue.poll(MAX_PROD_TIME, TimeUnit.MILLISECONDS);
                    if(bulb != null){
                        Thread.sleep(2000);
                        System.out.println("Упакована : " + bulb );
                    }

                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println("Исключение : " + e.getLocalizedMessage());
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if(runningConsumer || runningProducer){
            System.out.println("Конвеер уже запущен");
        }

        System.out.println("Запуск конвеера");

        runningProducer = true;
        var producer = Executors.newSingleThreadExecutor();
        producer.execute(new Producer());
        runningConsumer = true;
        var consumer = Executors.newSingleThreadExecutor();
        consumer.execute(new Consumer());
        while (true){
            if(scanner.hasNext()){
                if(scanner.next().equals("stop")){
                    producer.shutdown();
                    System.exit(0);}
            }
        }

    }
}