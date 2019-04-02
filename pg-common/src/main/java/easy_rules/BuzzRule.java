package easy_rules;

import org.easyrules.annotation.*;
import org.easyrules.annotation.Rule;

/**
 * @author Starstar Sun
 * @date 2018/9/12
 * @Description:
 **/
@Rule
public class BuzzRule {
    private int input;

    @Condition  //判断是否命中规则
    public boolean isBuzz() {
        return input % 7 == 0;
    }

    @Action  //命中规则后执行动作
    public void printBuzz() {
        System.out.printf(input+" buzz");
    }

    public void setInput(int input) {
        this.input = input;
    }

    @Priority  //优先级 0/1/2/3.....  越小优先级越高
    public int getPriority() {
        return 2;
    }
}
