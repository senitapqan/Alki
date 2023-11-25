package kz.senitapqan.alki.repository;

import kz.senitapqan.alki.models.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
    @Query("select pd from ProductDetails pd where pd.size = :size and pd.color = :color and pd.product.qid = :id")
    ProductDetails findProductDetailsBySizeAndColor(@Param("size") String size, @Param("color") String color, @Param("id") Long id);
}
