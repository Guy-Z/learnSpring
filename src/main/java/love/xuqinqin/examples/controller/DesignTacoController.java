package love.xuqinqin.examples.controller;

import lombok.extern.slf4j.Slf4j;
import love.xuqinqin.examples.ThymeleafUtil;
import love.xuqinqin.examples.model.Ingredient;
import love.xuqinqin.examples.model.Order;
import love.xuqinqin.examples.model.Taco;
import love.xuqinqin.examples.repository.TacoRepository;
import love.xuqinqin.examples.service.IIngredientService;
import love.xuqinqin.examples.service.ITacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Taco控制器
 *
 * @Author FGuy
 * @Date 2020/4/22 12:35
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    @Autowired
    private IIngredientService ingredientService;

    @Autowired
    private ITacoService tacoService;

    @Autowired
    private ThymeleafUtil thymeleafUtil;

    @Autowired
    private TacoRepository tacoRepository;

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = ingredientService.getIngredients();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), this.filterByType(ingredients, type));
        }
        model.addAttribute("TU", thymeleafUtil);
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, BindingResult bindingResult, Model model, @ModelAttribute Order order, HttpSession session) {
        if (bindingResult.hasErrors()) {
            List<Ingredient> ingredients = ingredientService.getIngredients();
            Ingredient.Type[] types = Ingredient.Type.values();
            for (Ingredient.Type type : types) {
                model.addAttribute(type.toString().toLowerCase(), this.filterByType(ingredients, type));
            }
            model.addAttribute("TU", thymeleafUtil);
            model.addAttribute("taco", taco);
            return "design";
        }
        Taco savedTaco = tacoService.save(taco);
        order.addTaco(savedTaco);
        log.info("处理设计:" + savedTaco);
        Iterator<Taco> iterator = tacoRepository.findAll().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
