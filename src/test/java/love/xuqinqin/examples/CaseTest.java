package love.xuqinqin.examples;

import love.xuqinqin.examples.mapper.ITacoMapper;
import love.xuqinqin.examples.mapper.impl.TacoMapper;
import love.xuqinqin.examples.model.Taco;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * @Author FGuy
 * @Date 2020/4/24 12:13
 */
public class CaseTest {

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ITacoMapper tacoMapper = (TacoMapper) ac.getBean("tacoMapper");
        Taco taco = new Taco();
        taco.setName("demoTaco");
        tacoMapper.save(taco);
    }

}
