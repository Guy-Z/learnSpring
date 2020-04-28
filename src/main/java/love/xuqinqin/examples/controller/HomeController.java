package love.xuqinqin.examples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页控制器
 *
 * @Author FGuy
 * @Date 2020/4/22 11:33
 */
@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
