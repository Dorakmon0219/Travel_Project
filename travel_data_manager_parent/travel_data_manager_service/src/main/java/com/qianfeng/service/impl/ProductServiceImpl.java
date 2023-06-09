package com.qianfeng.service.impl;

import com.qianfeng.dao.IProductDao;
import com.qianfeng.domain.Product;
import com.qianfeng.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private IProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void addProduct(Product product) {
        String id = UUID.randomUUID().toString();
        product.setId(id);
        productDao.addProduct(product);
    }

    @Override
    public void deleteByIds(String[] ids) {
        for (String id : ids) {
            productDao.deleteById(id);
        }
    }

    @Override
    public Product findById(String id) {
        Product product = productDao.findById(id);
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
