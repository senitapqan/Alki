package kz.senitapqan.alki.mapped;

import kz.senitapqan.alki.dtos.OrderCreateRequestDto;
import kz.senitapqan.alki.models.Order;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.repository.OrderRepository;
import kz.senitapqan.alki.repository.ProductDetailsRepository;
import kz.senitapqan.alki.service.ProductDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OrderMapper {
    private final ProductDetailsRepository productDetailsRepository;
    public Order toEntity(OrderCreateRequestDto orderCreateRequestDto) {
        ProductDetails productDetails = productDetailsRepository.findProductDetailsBySizeAndColor(orderCreateRequestDto.getSize(),
                orderCreateRequestDto.getColor(), orderCreateRequestDto.getQid());

        if (productDetails == null) {
            throw new RuntimeException("There is no item with such params");
        }

        Order order = new Order();
        order.setStatus("pending");
        order.setPrice(productDetails.getProduct().getPrice());
        order.setAddress(orderCreateRequestDto.getAddress());
        order.setUser(orderCreateRequestDto.getUserId());
        order.setProductDetails(productDetails);
        return order;
    }

}
