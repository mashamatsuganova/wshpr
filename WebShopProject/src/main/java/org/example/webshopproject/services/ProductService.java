package org.example.webshopproject.services;
import org.example.webshopproject.entities.Product;
import org.example.webshopproject.repositories.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    private ProdRepository prodRepository;

    @Autowired
    public void setProdRepository(ProdRepository prodRepository) {
        this.prodRepository = prodRepository;
    }

    public Iterable<Product> getAllProducts() {
        return prodRepository.findAll();
    }

    public Product getProductById(Long id) {
        return prodRepository.findById(id).get();
    }

    public Product getProductByTitle(String title) {
        return prodRepository.findOneByTitle(title);
    }

    public void deleteProductById(Long id) {
        prodRepository.deleteById(id);
    }
}
