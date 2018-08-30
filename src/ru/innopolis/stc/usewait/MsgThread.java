package ru.innopolis.stc.usewait;

public class MsgThread extends Thread {
    private Timer t;

    public MsgThread(Timer s) {
        t = s;
    }

    public void run() {
        try {
            for (; ; ) {
                t.printMsg();
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}