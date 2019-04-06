package com.erp.web4j.mapper;

import com.erp.web4j.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String PrimaryKey);

    List<Product> listAllProducts();

    List<Product> listAllProductsWithOffsetAndLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    Integer countAllRecords();

    Integer countProductById(String productId);

    Integer updateProductById(Product product);

    int deleteByIds(@Param("ids") String[] ids);

    List<Product> searchProductById(@Param("productId") String productId,
                                    @Param("offset") Integer offset,
                                    @Param("limit") Integer limit);

    int countRecordsById(String searchValue);

    List<Product> searchProductByName(@Param("productName") String productName,
                                      @Param("offset") Integer offset,
                                      @Param("limit") Integer limit);

    int countRecordsByName(String s);

    List<Product> searchProductByType(@Param("productType") String productType,
                                      @Param("offset") Integer offset,
                                      @Param("limit") Integer limit);

    int countRecordsByType(String s);
}
