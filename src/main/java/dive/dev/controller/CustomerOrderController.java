package dive.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dive.dev.model.Order;

@RestController
public class CustomerOrderController {

	List<Order> orders = new ArrayList<>();
	
	static Long orderId = 0L;
	
	@PostMapping("/place-order")
	public Order placeOrder(Order order) {
		
		System.out.println("Business Logic");
		order.setId(++orderId);
		orders.add(order);
		return order;
	}
	
	@GetMapping("/orders/{id}")
	public Order getOrder(@PathVariable("id") Long id) {
		System.out.println("Business Logic");
		return orders.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	@DeleteMapping("/orders/{id}")
	public String deleteOrder(@PathVariable("id") Long id) {
		System.out.println("Business Logic");
		orders.remove(orders.stream().filter(t -> t.getId().equals(id)).findFirst().get());
		return "Order Deleted";
	}
	
}
