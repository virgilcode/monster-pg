package drools;



import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.util.Collection;

/**
 * @author Starstar Sun
 * @date 2019/1/28
 * @Description:
 **/
public class DroolsMain {

    public static void main(String[] args){
        new DroolsMain().test2();
    }

    private void test(){
        // 构建KieServices
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        // 获取kmodule.xml中配置中名称为ksession-rule的session，默认为有状态的。
        KieSession kSession = kc.newKieSession("ksession1");

        Product fan = new Product("电扇", 280);
        Product washer = new Product("洗衣机",2200);
        Product phone = new Product("手机", 998);
        kSession.insert(fan);
        kSession.insert(washer);
        kSession.insert(phone);
        kSession.fireAllRules();
        kSession.dispose();
    }

    /**
     * 不使用 drools 7.x 配置文件
     */
    private void test2(){
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/product.drl"), ResourceType.DRL);

        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }


        // 注释掉的是 drools 6.x API
//        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
//        StatefulKnowledgeSession kieSession = kbase.newStatefulKnowledgeSession();

        // drools 7.x API
        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        Collection<KiePackage> pkgs = kbuilder.getKnowledgePackages();
        kbase.addPackages(pkgs);
        KieSession kieSession = kbase.newKieSession();
        Product fan = new Product("电扇", 280);
        Product washer = new Product("洗衣机",2200);
        Product phone = new Product("手机", 998);
        kieSession.insert(fan);
        kieSession.insert(washer);
        kieSession.insert(phone);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
