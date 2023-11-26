package kz.senitapqan.alki.controller;

import kz.senitapqan.alki.dtos.OrderCreateRequestDto;
import kz.senitapqan.alki.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<HttpStatus> updateOrderStatus(@RequestParam("id") Long id,
                                                        @RequestParam("status") String newStatus) {
        orderService.updateStatus(id, newStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
