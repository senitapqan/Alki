package kz.senitapqan.alki.service;

import kz.senitapqan.alki.dtos.OrderCreateRequestDto;

public interface OrderService {
    public Long create(OrderCreateRequestDto orderCreateRequestDto);
    public void updateStatus(Long id, String newStatus);
    public boolean delete(Long id);
}
