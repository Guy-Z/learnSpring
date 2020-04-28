package love.xuqinqin.examples.service.impl;

import love.xuqinqin.examples.mapper.IOrderMapper;
import love.xuqinqin.examples.model.Order;
import love.xuqinqin.examples.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Order业务层实现类
 *
 * @Author FGuy
 * @Date 2020/4/26 18:07
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderMapper orderMapper;

    @Override
    public Order save(Order order) {
        orderMapper.save(order);
        return order;
    }
}
