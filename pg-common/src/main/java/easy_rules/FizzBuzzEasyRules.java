package easy_rules;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;

/**
 * @author Starstar Sun
 * @date 2018/9/12
 * @Description:
 **/
public class FizzBuzzEasyRules {
    public static void main(String[] args) {
        RulesEngine fizzBuzzEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSkipOnFirstAppliedRule(true)
                .withSilentMode(true)
                .build();
        // create rules
        FizzRule fizzRule = new FizzRule();
        BuzzRule buzzRule = new BuzzRule();
        FizzBuzzRule fizzBuzzRule = new FizzBuzzRule();
        NonFizzBuzzRule nonFizzBuzzRule = new NonFizzBuzzRule();
        // register rules 注册规则
        fizzBuzzEngine.registerRule(fizzBuzzRule);
        fizzBuzzEngine.registerRule(fizzRule);
        fizzBuzzEngine.registerRule(buzzRule);
        fizzBuzzEngine.registerRule(nonFizzBuzzRule);
        // fire rules
        for (int i = 1; i <= 40; i++) {
            //设置入参
            fizzRule.setInput(i);
            buzzRule.setInput(i);
            nonFizzBuzzRule.setInput(i);
            fizzBuzzRule.setInput(i);
            fizzBuzzEngine.fireRules();
            System.out.println();
        }
    }
}
