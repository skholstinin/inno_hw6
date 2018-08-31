package ru.innopolis.stc.usewait;

/**
 * Напишите программу, один поток которой каждую секунду отображает на экране данные о времени,
 * прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 5 секунд.
 * Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение,
 * потоком, отсчитывающим время. Отсчитывать время (использовать sleep) может только один поток
 * Не внося изменений в код потока-"хронометра" , добавьте еще один поток, который выводит на
 * <p>
 * экран другое сообщение каждые 7 секунд. Предполагается использование методов wait(),
 * notifyAll() по какому-то монитору, общему для всех потоков.
 * <p>
 * Бонус: Пакет Concurrent, перевод примеров на Lock  вместо синхронизации через wait-notify
 */


public class main {
    public static void main(String[] args) {
        Timer timerOneSec = new Timer(1, "Hello Innopolis", System.currentTimeMillis());
        Timer timerFiveSec = new Timer(5, "Hello Kazan", System.currentTimeMillis());
        Timer timerSevenSec = new Timer(7, "Hello Russian", System.currentTimeMillis());
        new TimerThread(timerOneSec).start();
        new MsgThread(timerOneSec).start();
        new TimerThread(timerFiveSec).start();
        new MsgThread(timerFiveSec).start();
        new TimerThread(timerSevenSec).start();
        new MsgThread(timerSevenSec).start();
    }
}
