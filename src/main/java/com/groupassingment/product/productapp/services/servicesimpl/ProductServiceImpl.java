package com.groupassingment.product.productapp.services.servicesimpl;

import com.groupassingment.product.productapp.dtos.ProductDto;
import com.groupassingment.product.productapp.exceptions.ProductAppException;
import com.groupassingment.product.productapp.exceptions.exceptionmodels.ProductException;
import com.groupassingment.product.productapp.models.ProductModel;
import com.groupassingment.product.productapp.repository.ProductRepository;
import com.groupassingment.product.productapp.services.ProductService;
import com.groupassingment.product.productapp.util.ActiveUser;
import com.groupassingment.product.productapp.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private ActiveUser activeUser;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        productDto.setOwnerId(activeUser.getId());
        productRepository.save(mapper.productDtoToProductModel(productDto));
        return productDto;
    }

    @Override
    public Float addDiscount(ProductDto productDto) {
        Optional<ProductModel> productModelOptional = productRepository.findById(productDto.getId());
        if(productModelOptional.isPresent()) {
            ProductModel productModel = productModelOptional.get();
            productModel.setDiscount(productDto.getDiscount());
            productModel.setNetPrice(productModel.getPrice() - productDto.getDiscount());
            productRepository.save(productModel);
            return productDto.getDiscount();
        }else {
            throw new ProductAppException(ProductException.PRODUCT_NOT_FOUND);
        }
    }

    @Override
    public List<ProductDto> getProductsByUser() {
        return productRepository.findAllByOwnerId(activeUser.getId()).stream().map(productModel -> mapper.productModelToProductDto(new ProductDto(),productModel)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteProduct(String productId) {
        productRepository.deleteById(productId);
        return true;
    }
}
