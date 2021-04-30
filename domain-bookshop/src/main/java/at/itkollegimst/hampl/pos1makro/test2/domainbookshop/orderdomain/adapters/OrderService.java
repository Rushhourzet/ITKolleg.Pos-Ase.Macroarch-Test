package at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.adapters;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.repository.OrderRepository;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.abstractions.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface OrderService {
    @Autowired
    OrderRepository orderRepository = null;

    public List<Order> listAllOrders();

    public void saveOrder(Order order);

    public Order getOrder(long id) ;

    public void deleteOrder(long id) ;
}
