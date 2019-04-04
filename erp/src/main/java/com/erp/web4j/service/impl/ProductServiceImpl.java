package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Product;
import com.erp.web4j.mapper.ProductMapper;
import com.erp.web4j.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 14:16
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;


    @Override
    public List<Product> listAllProducts() {
        return productMapper.listAllProducts();
    }

    @Override
    public List<Product> listAllProductsWithPageAndRows(Integer page, Integer rows) {
        return productMapper.listAllProductsWithOffsetAndLimit((page-1)*rows,rows);
    }

    @Override
    public int countAllRecords() {
        return productMapper.countAllRecords();
    }

    @Override
    public Boolean checkProductId(String productId) {
        return productMapper.countProductById(productId) > 0;
    }

    @Override
    public int insertProdcut(Product product) {
        return productMapper.insertSelective(product);
    }

    @Override
    public int updateProductById(Product product) {
        return productMapper.updateProductById(product);
    }

    @Override
    public int deleteCustomByIds(String[] ids) {
        return productMapper.deleteByIds(ids);
    }

    @Override
    public List<Product> searchProductById(String searchValue, Integer page, Integer rows) {
        return productMapper.searchProductById("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public int countRecordsById(String searchValue) {
        return productMapper.countRecordsById("%"+searchValue+"%");
    }

    @Override
    public List<Product> searchProductByName(String searchValue, Integer page, Integer rows) {
        return productMapper.searchProductByName("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public int countRecordsByName(String searchValue) {
        return productMapper.countRecordsByName("%"+searchValue+"%");
    }

    @Override
    public List<Product> searchProductByType(String searchValue, Integer page, Integer rows) {
        return  productMapper.searchProductByType("%"+searchValue+"%", (page-1)*rows, rows);
    }

    @Override
    public int countRecordsByType(String searchValue) {
        return productMapper.countRecordsByType("%"+searchValue+"%");
    }
}
