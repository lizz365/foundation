import com.alibaba.fastjson.JSONObject;
import com.lizz.fundation.dto.UserDTO;
import com.lizz.fundation.pattern.Singleton;
import com.lizz.fundation.pattern.decorator.Coffee;
import com.lizz.fundation.pattern.decorator.Milk;
import com.lizz.fundation.pattern.decorator.Chocolate;
import com.lizz.fundation.pattern.observer.Apply;
import com.lizz.fundation.pattern.observer.UserScore;
import com.lizz.fundation.pattern.observer.UserWallet;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author lizz365
 */
public class JUnit {
    @Test
    public void singletonTest(){
        UserDTO userDTO = Singleton.INSTANCE.getUserDTO();
        System.out.println(JSONObject.toJSONString(userDTO));
    }
    @Test
    public void decoratorTest(){
        //创建一杯加了1份牛奶和2份巧克力的大杯咖啡，
        Map coffeeMap = new Chocolate(new Milk(new Coffee(3),1),2).make();
        System.out.println(JSONObject.toJSONString(coffeeMap));
    }

    @Test
    public void observerTest(){
        Apply apply = new Apply();
        UserScore userScore = new UserScore();
        UserWallet userWallet = new UserWallet();
        apply.addOrder(userScore);
        apply.addOrder(userWallet);

        apply.apply("1111");
        apply.refundMoney("2222");

    }
}
