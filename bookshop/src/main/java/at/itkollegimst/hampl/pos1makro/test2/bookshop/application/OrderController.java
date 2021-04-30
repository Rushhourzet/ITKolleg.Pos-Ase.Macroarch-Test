package at.itkollegimst.hampl.pos1makro.test2.bookshop.application;

import at.itkollegimst.hampl.pos1makro.test2.bookshop.adapters.OrderService;
import at.itkollegimst.hampl.pos1makro.test2.bookshop.domain.aggregate.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Order> list() {
        return orderService.listAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id) {
        try {
            Order order = orderService.getOrder(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Long id) {
        try {
            Order existUser = orderService.getOrder(id);
            //Order.setId(id);
            orderService.saveOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        orderService.deleteOrder(id);
    }
}
