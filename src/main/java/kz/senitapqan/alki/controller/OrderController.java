package kz.senitapqan.alki.controller;

import kz.senitapqan.alki.dtos.OrderCreateRequestDto;
import kz.senitapqan.alki.dtos.OrderResponseDto;
import kz.senitapqan.alki.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Long> addOrder(@RequestBody OrderCreateRequestDto orderCreateRequestDto) {
        Long id = orderService.create(orderCreateRequestDto);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<String> updateOrderStatus(@RequestParam("id") Long id,
                                                        @RequestParam("status") String newStatus) {
        orderService.updateStatus(id, newStatus);
        return ResponseEntity.ok("Done :)");
    }
    @GetMapping("get/all")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    @GetMapping("/get-from-bot/{id}")
    public ResponseEntity<OrderResponseDto> getOrderFromBotById(Long id, Long userId) {
        return ResponseEntity.ok(orderService.getOrderFromBotById(id, userId));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

}
