package kz.senitapqan.alki.service.impl;

import kz.senitapqan.alki.dtos.OrderCreateRequestDto;
import kz.senitapqan.alki.dtos.OrderResponseDto;
import kz.senitapqan.alki.mapper.OrderMapper;
import kz.senitapqan.alki.models.Order;
import kz.senitapqan.alki.repository.OrderRepository;
import kz.senitapqan.alki.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Long create(OrderCreateRequestDto orderCreateRequestDto) {
        Order order = orderMapper.toEntity(orderCreateRequestDto);
        System.out.println(order);
        orderRepository.save(order);
        return order.getId();
    }
    @Override
    public void updateStatus(Long id, String newStatus) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        order.setStatus(newStatus);
        orderRepository.save(order);
    }
    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderMapper.toDto(orderRepository.findAll());
    }

    @Override
    public OrderResponseDto getOrderById(Long id, Long userId) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        if (order.getUser() != userId) {
            throw new RuntimeException("You dont have permission to check this order");
        }
        return orderMapper.toDto(order);
    }
}
