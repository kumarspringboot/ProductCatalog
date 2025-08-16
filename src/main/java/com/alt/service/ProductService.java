package com.alt.service;

import com.alt.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    public ProductDTO registerProduct(ProductDTO productBean);
    public ProductDTO updateProduct(ProductDTO productBean);
    public void deleteProduct(long id);
    public ProductDTO fetchProduct(long id);
    public List<ProductDTO> fetchAllProducts();
}
