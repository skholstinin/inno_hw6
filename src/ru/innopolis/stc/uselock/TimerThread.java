package ru.innopolis.stc.uselock;

import java.util.concurrent.locks.ReentrantLock;

public class TimerThread extends Thread {
    private Timer timer;
    private ReentrantLock locker;

    public TimerThread(Timer timer, ReentrantLock locker) {
        this.timer = timer;
        this.locker = locker;
    }

    public void run() {
        locker.lock();

        timer.checkTime(locker);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locker.isLocked()) {
                locker.unlock();
            }
        }
    }
}
