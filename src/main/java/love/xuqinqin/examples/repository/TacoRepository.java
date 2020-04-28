package love.xuqinqin.examples.repository;

import love.xuqinqin.examples.model.Taco;
import org.springframework.data.repository.CrudRepository;

/**
 * Taco JPA
 *
 * @Author FGuy
 * @Date 2020/4/27 18:25
 */
public interface TacoRepository extends CrudRepository<Taco,Integer> {
}
