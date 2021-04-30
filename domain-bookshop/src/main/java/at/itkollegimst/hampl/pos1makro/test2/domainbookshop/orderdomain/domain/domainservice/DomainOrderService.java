package at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.domainservice;

import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.adapters.OrderService;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.domain.abstractions.Order;
import at.itkollegimst.hampl.pos1makro.test2.domainbookshop.orderdomain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DomainOrderService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrder(long id) {
        return orderRepository.findById(id).get();
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
