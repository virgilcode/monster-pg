package easy_rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;
import org.easyrules.core.CompositeRule;

/**
 * @author Starstar Sun
 * @date 2018/9/12
 * @Description:
 **/
@Rule
public class FizzBuzzRule {

    private int input;

    @Condition  //判断是否命中规则
    public boolean isFizzBuzz() {
        return input % 7 == 0 && input % 5 == 0;
    }

    @Action  //命中规则后执行动作
    public void print() {
        System.out.printf(input + " FIZZBUZZ");
    }

    public void setInput(int input) {
        this.input = input;
    }

    @Priority
    public int getPriority() {
        return 0;
    }
}
