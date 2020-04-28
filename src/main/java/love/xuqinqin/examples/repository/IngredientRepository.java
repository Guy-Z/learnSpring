package love.xuqinqin.examples.repository;

import love.xuqinqin.examples.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * Ingredient JPA
 *
 * @Author FGuy
 * @Date 2020/4/27 18:24
 */
public interface IngredientRepository extends CrudRepository<Ingredient,String> {
}
