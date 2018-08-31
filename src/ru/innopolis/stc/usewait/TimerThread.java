package ru.innopolis.stc.usewait;

public class TimerThread extends Thread {
    private Timer timer;

    public TimerThread(Timer timer) {
        this.timer = timer;
    }

    public void run() {
        try {
            for (; ; ) {
                sleep(1000);
                timer.checkTime();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
