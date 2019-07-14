package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable{
    private Data data;

    public Sender(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        String [] packets = {
                        "First data part",
                        "Second data part",
                        "Third data part",
                        "Fourth data part",
                        "Last data part"
                    };
        for (var packet : packets ){
            data.send(packet);

            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted " + e);
            }
        }
    }
}
