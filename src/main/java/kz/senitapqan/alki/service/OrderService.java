package kz.senitapqan.alki.service;

import kz.senitapqan.alki.dtos.OrderCreateRequestDto;
import kz.senitapqan.alki.dtos.OrderResponseDto;

import java.util.List;

public interface OrderService {
    public Long create(OrderCreateRequestDto orderCreateRequestDto);
    public void updateStatus(Long id, String newStatus);
    public boolean delete(Long id);
    public List<OrderResponseDto> getAllOrders();
    public OrderResponseDto getOrderFromBotById(Long id, Long user_id);
    public OrderResponseDto getOrderById(Long id);
}
