import com.alibaba.fastjson.JSONObject;
import com.lizz.fundation.dto.UserDTO;
import com.lizz.fundation.pattern.abstractFactory.BenzFactory;
import com.lizz.fundation.pattern.abstractFactory.CarFactory;
import com.lizz.fundation.pattern.Singleton;
import com.lizz.fundation.pattern.adapter.City;
import com.lizz.fundation.pattern.adapter.CityAdapter;
import com.lizz.fundation.pattern.adapter.CityImpl;
import com.lizz.fundation.pattern.decorator.Coffee;
import com.lizz.fundation.pattern.decorator.Milk;
import com.lizz.fundation.pattern.decorator.Chocolate;
import com.lizz.fundation.pattern.observer.Apply;
import com.lizz.fundation.pattern.observer.UserScore;
import com.lizz.fundation.pattern.observer.UserWallet;
import com.lizz.fundation.pattern.proxyFactory.ProxyFactory;
import com.lizz.fundation.pattern.proxyFactory.ReadDB;
import com.lizz.fundation.pattern.proxyFactory.ReadDBImpl;
import org.junit.Test;

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


    @Test
    public void adapterTest(){
        City city1= new CityImpl();
        CityAdapter cityAdapter = new CityAdapter(city1);
        System.out.println(cityAdapter.getCityByCode("1"));
    }
    @Test
    public void factoryTest(){
        CarFactory carFactory= new BenzFactory();
        System.out.println(carFactory.newCar().make());
    }

    @Test
    public void PorxyTest(){
        ReadDB readDB = new ReadDBImpl();
        ReadDB readDB1 = (ReadDB)new ProxyFactory(readDB).getProxy();
        System.out.println(readDB1.select());
    }
}
