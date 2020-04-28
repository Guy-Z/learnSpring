package love.xuqinqin.examples.repository;

import love.xuqinqin.examples.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Order JPA
 *
 * @Author FGuy
 * @Date 2020/4/27 18:27
 */
public interface OrderRepository extends CrudRepository<Order,Integer> {
}
