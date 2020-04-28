package love.xuqinqin.examples.controller;

import lombok.extern.slf4j.Slf4j;
import love.xuqinqin.examples.model.Order;
import love.xuqinqin.examples.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Order控制器
 *
 * @Author FGuy
 * @Date 2020/4/22 14:48
 */
@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("order",new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "orderForm";
        }
        order.setTacos(((Order)session.getAttribute("order")).getTacos());
        orderService.save(order);
        session.removeAttribute("order");
        log.info("账单提交:" + order);
        return "redirect:/";
    }

}
