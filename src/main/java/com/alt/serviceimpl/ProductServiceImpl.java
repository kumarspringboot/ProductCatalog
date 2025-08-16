package com.alt.serviceimpl;
import com.alt.entity.ProductEntity;
import com.alt.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alt.dto.ProductDTO;
import com.alt.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO registerProduct(ProductDTO product) {

        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);

        ProductEntity save = productRepository.save(productEntity);
        BeanUtils.copyProperties(product, save);

        return product;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product) {

        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);

        ProductEntity save = productRepository.save(productEntity);
        BeanUtils.copyProperties(product, save);

        return product;

    }

    @Override
    public void deleteProduct(long id) {
    productRepository.deleteById(id);
    }

    @Override
    public ProductDTO fetchProduct(long id) {
        ProductDTO dto= new ProductDTO();

        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isPresent()) {
        BeanUtils.copyProperties(product.get(), dto);
        }
        return dto;
    }

    @Override
    public List<ProductDTO> fetchAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        List<ProductEntity> all = productRepository.findAll();
        all.forEach(data -> {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(data, productDTO);
            products.add(productDTO);
        });
        return products;
    }
}
