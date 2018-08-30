package ru.innopolis.stc.usewait;

public class TimerThread extends Thread {
    private Timer t;

    public TimerThread(Timer s) {
        t = s;
    }

    public void run() {
        try {
            for (; ; ) {
                t.checkTime();
                sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
