package springframework.services;

import springframework.commands.ProductForm;
import springframework.domain.Product;

import java.util.List;


public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    Product saveOrUpdateProductForm(ProductForm productForm);
}
