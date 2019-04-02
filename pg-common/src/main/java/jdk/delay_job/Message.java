package jdk.delay_job;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Starstar Sun
 * @date 2018/9/12
 * @Description: 基于Delayed
 **/
public class Message implements Delayed {

    private Integer id;
    private String content;
    private long delay;//延迟时间
    private long exceptTime;//执行时间


    public Message() {
    }

    public Message(Integer id, String content, long delay) {
        this.id = id;
        this.content = content;
        this.delay = delay;
        this.exceptTime = System.nanoTime() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.exceptTime - System.nanoTime(), TimeUnit.SECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Message message = (Message) o;
        return this.exceptTime > message.getExceptTime() ? 1 : 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public long getExceptTime() {
        return exceptTime;
    }

    public void setExceptTime(long exceptTime) {
        this.exceptTime = exceptTime;
    }
}
