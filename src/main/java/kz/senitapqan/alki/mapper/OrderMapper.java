package kz.senitapqan.alki.mapper;

import kz.senitapqan.alki.dtos.OrderCreateRequestDto;
import kz.senitapqan.alki.dtos.OrderResponseDto;
import kz.senitapqan.alki.models.Order;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.repository.ProductDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class OrderMapper {
    private final ProductDetailsRepository productDetailsRepository;
    public Order toEntity(OrderCreateRequestDto orderCreateRequestDto) {
        System.out.println(orderCreateRequestDto.getProductId() + " " + orderCreateRequestDto.getColor() + " "
                        + orderCreateRequestDto.getSize());
        ProductDetails productDetails = productDetailsRepository.findProductDetailsBySizeAndColor(orderCreateRequestDto.getSize(),
                orderCreateRequestDto.getColor(), orderCreateRequestDto.getProductId());

        if (productDetails == null) {
            throw new RuntimeException("There is no item with such params");
        }

        Order order = new Order();
        order.setStatus("pending");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        order.setDate(formatter.format(new Date()));
        order.setPrice(productDetails.getProduct().getPrice());
        order.setAddress(orderCreateRequestDto.getAddress());
        order.setUser(orderCreateRequestDto.getUserId());
        order.setProductDetails(productDetails);
        order.setId(orderCreateRequestDto.getId());
        order.setPhone(orderCreateRequestDto.getPhone());
        return order;
    }

    public OrderResponseDto toDto(Order order) {
        return new OrderResponseDto(order.getId(), order.getProductDetails().getProduct().getName(),
                order.getProductDetails().getColor(), order.getProductDetails().getSize(),
                order.getAddress(), order.getStatus(), order.getDate());
    }
    public List<OrderResponseDto> toDto(List<Order> ordersList) {
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        for (Order order : ordersList) {
            orderResponseDtoList.add(toDto(order));
        }
        return orderResponseDtoList;
    }

}
