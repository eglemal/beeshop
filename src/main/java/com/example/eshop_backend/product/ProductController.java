package com.example.eshop_backend.product;

import com.example.eshop_backend.user.User;
import com.example.eshop_backend.user.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/1.0")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    List<Product> getProducts() {
        List<Product> all = productRepository.getAll();
        return all;
    }

    @GetMapping("/product/{productName}")
    public Map<String, Object> getProductByName (@PathVariable String productName) {
        Product currentProduct = productService.getByProductName(productName);
        Map<String, Object> product = new HashMap<>();
        product.put("name", currentProduct.getProductName());
        product.put("image", currentProduct.getImage());
        product.put("image2", currentProduct.getImage2());
        product.put("image3", currentProduct.getImage3());
        product.put("price", currentProduct.getPrice());
        product.put("description", currentProduct.getDescription());
        return product;
    }

    @PostMapping("/products")
    public void setCartPrice(@RequestBody Long price) {
        productService.setTotalPrice(productService.getTotalPrice()+price);

    }
}
