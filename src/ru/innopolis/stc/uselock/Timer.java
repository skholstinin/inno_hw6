package ru.innopolis.stc.uselock;

import java.util.concurrent.locks.ReentrantLock;

public class Timer {
    private int count = 0;
    private int cntSec;
    private String msg;
    private long startTime;

    public Timer(int n, String msg, long startTime) {
        cntSec = n;
        this.msg = msg;
        this.startTime = startTime;
    }

    public void printMsg() {
        System.out.print(msg + cntSec + "sec" + "  " + "time from start=" + (System.currentTimeMillis() - startTime) / 1000 + "sec" + "\r\n");
    }

    public void checkTime(ReentrantLock locker) {
        count++;
        if (count % cntSec == 0) {
            if (locker.isLocked()) {
                locker.unlock();
            }
        }
    }
}