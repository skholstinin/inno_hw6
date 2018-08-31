package ru.innopolis.stc.usewait;

public class MsgThread extends Thread {
    private Timer timer;

    public MsgThread(Timer timer) {
        this.timer = timer;
    }

    public void run() {
        try {
            for (; ; ) {
                timer.printMsg();
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}