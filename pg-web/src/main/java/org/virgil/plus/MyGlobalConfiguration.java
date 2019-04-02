package org.virgil.plus;

import com.baomidou.mybatisplus.MybatisSqlSessionTemplate;
import com.baomidou.mybatisplus.entity.DefaultMetaObjectHandler;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.mapper.ISqlInjector;
import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.baomidou.mybatisplus.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.toolkit.JdbcUtils;
import com.baomidou.mybatisplus.toolkit.SqlReservedWords;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author Starstar Sun
 * @date 2018/7/3019:43
 * @Description:
 **/
public class MyGlobalConfiguration extends GlobalConfiguration implements Serializable {
    private String logicDeleteValue = null;
    private String logicNotDeleteValue = null;
    private DBType dbType;
    private IdType idType;
    private boolean dbColumnUnderline;
    private ISqlInjector sqlInjector;
    private IKeyGenerator keyGenerator;
    private MetaObjectHandler metaObjectHandler;
    private FieldStrategy fieldStrategy;
    private boolean isRefresh;
    private boolean isCapitalMode;
    private String identifierQuote;
    private SqlSessionFactory sqlSessionFactory;
    private Set<String> mapperRegistryCache;
    private SqlSession sqlSession;

    public MyGlobalConfiguration() {
        System.out.println("MyGlobalConfiguration init ******");
        this.idType = IdType.AUTO;
        this.dbColumnUnderline = false;
        this.metaObjectHandler = new DefaultMetaObjectHandler();
        this.fieldStrategy = FieldStrategy.NOT_NULL;
        this.isRefresh = false;
        this.isCapitalMode = false;
        this.mapperRegistryCache = new ConcurrentSkipListSet();
    }

    public MyGlobalConfiguration(ISqlInjector sqlInjector) {
        this.idType = IdType.AUTO;
        this.dbColumnUnderline = false;
        this.metaObjectHandler = new DefaultMetaObjectHandler();
        this.fieldStrategy = FieldStrategy.NOT_NULL;
        this.isRefresh = false;
        this.isCapitalMode = false;
        this.mapperRegistryCache = new ConcurrentSkipListSet();
        this.sqlInjector = sqlInjector;
    }

    public IKeyGenerator getKeyGenerator() {
        return this.keyGenerator;
    }

    public void setKeyGenerator(IKeyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    public String getLogicDeleteValue() {
        return this.logicDeleteValue;
    }

    public void setLogicDeleteValue(String logicDeleteValue) {
        this.logicDeleteValue = logicDeleteValue;
    }

    public String getLogicNotDeleteValue() {
        return this.logicNotDeleteValue;
    }

    public void setLogicNotDeleteValue(String logicNotDeleteValue) {
        this.logicNotDeleteValue = logicNotDeleteValue;
    }

    public DBType getDbType() {
        return this.dbType;
    }

    public void setDbTypeOfJdbcUrl(String jdbcUrl) {
        this.dbType = JdbcUtils.getDbType(jdbcUrl);
    }

    public void setDbType(String dbType) {
        this.dbType = DBType.getDBType(dbType);
    }

    public IdType getIdType() {
        return this.idType;
    }

    public void setIdType(int idType) {
        this.idType = IdType.getIdType(idType);
    }

    public boolean isDbColumnUnderline() {
        return this.dbColumnUnderline;
    }

    public void setDbColumnUnderline(boolean dbColumnUnderline) {
        this.dbColumnUnderline = dbColumnUnderline;
    }

    public ISqlInjector getSqlInjector() {
        return this.sqlInjector;
    }

    public void setSqlInjector(ISqlInjector sqlInjector) {
        this.sqlInjector = sqlInjector;
    }

    public MetaObjectHandler getMetaObjectHandler() {
        return this.metaObjectHandler;
    }

    public void setMetaObjectHandler(MetaObjectHandler metaObjectHandler) {
        this.metaObjectHandler = metaObjectHandler;
    }

    public FieldStrategy getFieldStrategy() {
        return this.fieldStrategy;
    }

    public void setFieldStrategy(int fieldStrategy) {
        this.fieldStrategy = FieldStrategy.getFieldStrategy(fieldStrategy);
    }

    public boolean isRefresh() {
        return this.isRefresh;
    }

    public void setRefresh(boolean refresh) {
        this.isRefresh = refresh;
    }

    public Set<String> getMapperRegistryCache() {
        return this.mapperRegistryCache;
    }

    public void setMapperRegistryCache(Set<String> mapperRegistryCache) {
        this.mapperRegistryCache = mapperRegistryCache;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return this.sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.sqlSession = new MybatisSqlSessionTemplate(sqlSessionFactory);
    }

    public boolean isCapitalMode() {
        return this.isCapitalMode;
    }

    public void setCapitalMode(boolean isCapitalMode) {
        this.isCapitalMode = isCapitalMode;
    }

    public String getIdentifierQuote() {
        return null == this.identifierQuote ? this.dbType.getQuote() : this.identifierQuote;
    }

    public void setIdentifierQuote(String identifierQuote) {
        this.identifierQuote = identifierQuote;
    }

    public void setSqlKeywords(String sqlKeywords) {
        if (StringUtils.isNotEmpty(sqlKeywords)) {
            SqlReservedWords.RESERVED_WORDS.addAll(StringUtils.splitWorker(sqlKeywords.toUpperCase(), ",", -1, false));
        }

    }

    public SqlSession getSqlSession() {
        return this.sqlSession;
    }

    public SqlSessionFactory signGlobalConfig(SqlSessionFactory sqlSessionFactory) {
        if (null != sqlSessionFactory) {
            GlobalConfigUtils.setGlobalConfig(sqlSessionFactory.getConfiguration(), this);
        }

        return sqlSessionFactory;
    }
}
