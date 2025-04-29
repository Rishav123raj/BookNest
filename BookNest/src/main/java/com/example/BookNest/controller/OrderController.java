@RestController
@RequestMapping("/checkout")
public class OrderController {
    @Autowired private OrderRepository orderRepo;

    @PostMapping
    public Order checkout(@RequestBody Order order) {
        order.setOrderDate(LocalDateTime.now());
        return orderRepo.save(order);
    }
}
