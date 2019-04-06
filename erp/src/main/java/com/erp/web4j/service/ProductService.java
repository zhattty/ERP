package com.erp.web4j.service;

import com.erp.web4j.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 14:14
 */
public interface ProductService {
    List<Product> listAllProducts();

    List<Product> listAllProductsWithPageAndRows(Integer page, Integer rows);

    int countAllRecords();

    Boolean checkProductId(String productId);

    int insertProdcut(Product product);

    int updateProductById(Product product);

    int deleteCustomByIds(String[] ids);

    List<Product> searchProductById(String searchValue, Integer page, Integer rows);

    int countRecordsById(String searchValue);

    List<Product> searchProductByName(String searchValue, Integer page, Integer rows);

    int countRecordsByName(String searchValue);

    List<Product> searchProductByType(String searchValue, Integer page, Integer rows);

    int countRecordsByType(String searchValue);

    Product selectProductById(String productId);
}
