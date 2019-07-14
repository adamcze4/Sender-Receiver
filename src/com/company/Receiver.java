package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Data data;

    public Receiver(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        // receive packets until last one occurs
        for(var receivedMessage = data.receive(); !"Last data part".equals(receivedMessage); receivedMessage = data.receive()){
            System.out.println("Received " + receivedMessage);

            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted " + e);
            }
        }
    }
}
