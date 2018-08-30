package ru.innopolis.stc.usewait;

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

    public synchronized void printMsg() throws InterruptedException {
        wait();
        System.out.print(msg + cntSec + "sec" + "  " + "time from start=" + (System.currentTimeMillis() - startTime) / 1000 + "sec" + "\r\n");
    }

    public synchronized void checkTime() {
        count++;
        if (count % cntSec == 0) {
            notifyAll();
        }
    }
}