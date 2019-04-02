package org.virgil.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Starstar Sun
 * @date 2018/7/3115:51
 * @Description:
 **/
public class MultiDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> sourceKey = new ThreadLocal<>();

    public static void setDataSourceKey(String key) {
        sourceKey.set(key);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return sourceKey.get();
    }
}
