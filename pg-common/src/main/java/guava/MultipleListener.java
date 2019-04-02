package guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author Starstar Sun
 * @date 2018/8/22
 * @Description:
 **/
public class MultipleListener {
    public Integer lastInteger;
    public Long lastLong;

    @Subscribe
    public void listenInteger(Integer event) {
        System.out.println("listen" + event);
        lastInteger = event;
    }

    @Subscribe
    public void listenLong(Long event) {
        lastLong = event;
    }

    public Integer getLastInteger() {
        return lastInteger;
    }

    public Long getLastLong() {
        return lastLong;
    }

    public static void main(String[] args) {
        EventBus eventBus = new EventBus("bus");
        MultipleListener multipleListener = new MultipleListener();
        eventBus.register(multipleListener);

        eventBus.post(new Integer(100));

        System.out.println(multipleListener.getLastInteger());
    }
}
