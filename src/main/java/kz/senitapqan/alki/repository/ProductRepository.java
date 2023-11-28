package kz.senitapqan.alki.repository;


import kz.senitapqan.alki.models.Category;
import kz.senitapqan.alki.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.name = :name and p.category.name = :category")
    Product getProductsByNameAndCategory(String name, String category);

    Product getProductsByName(String name);
}
