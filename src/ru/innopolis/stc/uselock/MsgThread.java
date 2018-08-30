package ru.innopolis.stc.uselock;

import java.util.concurrent.locks.ReentrantLock;

public class MsgThread extends Thread {
    private Timer timer;
    private ReentrantLock locker;

    public MsgThread(Timer s, ReentrantLock locker) {
        timer = s;
        this.locker = locker;
    }

    public void run() {
        locker.lock();

        timer.printMsg();

        locker.unlock();
    }
}