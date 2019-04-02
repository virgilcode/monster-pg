package jdk.delay_job;

/**
 * @author Starstar Sun
 * @date 2018/9/12
 * @Description:
 **/
public interface ExpirationListener<E> {
    void expired(E expiredObject);
}
