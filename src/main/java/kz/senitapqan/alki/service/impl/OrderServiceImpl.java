package kz.senitapqan.alki.service.impl;

import kz.senitapqan.alki.dtos.OrderCreateRequestDto;
import kz.senitapqan.alki.mapped.OrderMapper;
import kz.senitapqan.alki.models.Order;
import kz.senitapqan.alki.repository.OrderRepository;
import kz.senitapqan.alki.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Long create(OrderCreateRequestDto orderCreateRequestDto) {
        Order order = orderMapper.toEntity(orderCreateRequestDto);
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
}
