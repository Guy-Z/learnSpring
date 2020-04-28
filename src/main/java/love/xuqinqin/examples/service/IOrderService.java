package love.xuqinqin.examples.service;

import love.xuqinqin.examples.model.Order;

/**
 * Order业务层接口
 *
 * @Author FGuy
 * @Date 2020/4/26 18:06
 */
public interface IOrderService {

    /**
     * 保存账单
     *
     * @param order
     * @return
     */
    Order save(Order order);

}
