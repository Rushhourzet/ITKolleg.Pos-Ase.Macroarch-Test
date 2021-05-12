package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.api.RESTController;

import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.Order;
import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
    public ResponseEntity<?> add(@RequestBody Order order) {
        return saveOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Long id) {
        return saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }


    private ResponseEntity<HttpStatus> saveOrder(Order order){
        try{
            orderService.saveOrder(order);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch(Throwable t){
            return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }
    }

}
