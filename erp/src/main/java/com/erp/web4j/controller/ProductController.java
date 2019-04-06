package com.erp.web4j.controller;

import com.erp.web4j.bean.Product;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 14:12
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("get_data")
    @ResponseBody
    public List<Product> getAllProductData(){
        return productService.listAllProducts();
    }

    @RequestMapping("find")
    public String findProduct(){
        return "product_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<Product> listAllProduct(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Product> products = productService.listAllProductsWithPageAndRows(page, rows);
        int records = productService.countAllRecords();
        QueryVo<Product> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(products);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }

    @RequestMapping("add")
    public String addProduct(){
        return "product_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insertProduct(Product product){
        StatusJson statusJson = new StatusJson();
        if (product == null){
            statusJson.setMsg("请输入参数");
            return statusJson;
        }
        if (product.getProductId() == null || product.getProductName()==null || product.getProductType() == null){
            statusJson.setMsg("必填项不能为空");
            return statusJson;
        }
        Boolean isPidExisit = productService.checkProductId(product.getProductId());
        if (isPidExisit){
            statusJson.setMsg("产品id重复");
            return statusJson;
        }
        int result = productService.insertProdcut(product);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("插入失败");
        }
        return statusJson;
    }

    @RequestMapping("edit")
    public String editProduct(){
        return "product_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody StatusJson updateProductById(Product product){
        StatusJson statusJson = new StatusJson();
        if (product == null){
            statusJson.setMsg("请输入参数");
            return statusJson;
        }
        if (product.getProductId() == null || product.getProductName()==null || product.getProductType() == null){
            statusJson.setMsg("必填项不能为空");
            return statusJson;
        }

        int result = productService.updateProductById(product);
        if (result == 1){
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("更新失败");
        }
        return statusJson;
    }

    @RequestMapping("delete_batch")
    @ResponseBody StatusJson deleteProductByIds(@RequestParam("ids") String[] ids){
        StatusJson statusJson = new StatusJson();
        if (ids == null || ids.length == 0){
            statusJson.setMsg("请勾选需要删除的对象");
            return statusJson;
        }
        int count = productService.deleteCustomByIds(ids);
        if (count == ids.length){
            statusJson.setStatus("200");
        }else if (count > 0 && count < ids.length){
            statusJson.setMsg("未完全删除");
        }else {
            statusJson.setMsg("删除失败");
        }
        return statusJson;
    }

    @RequestMapping("search_product_by_productId")
    @ResponseBody
    public QueryVo<Product> searchProductById(String searchValue,
                                              @RequestParam("page") Integer page,
                                              @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Product> products = productService.searchProductById(searchValue,page, rows);
        int records = productService.countRecordsById(searchValue);
        QueryVo<Product> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(products);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }

    @RequestMapping("search_product_by_productName")
    @ResponseBody
    public QueryVo<Product> searchProductByName(String searchValue,
                                              @RequestParam("page") Integer page,
                                              @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Product> products = productService.searchProductByName(searchValue,page, rows);
        int records = productService.countRecordsByName(searchValue);
        QueryVo<Product> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(products);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }
    @RequestMapping("search_product_by_productType")
    @ResponseBody
    public QueryVo<Product> searchProductByType(String searchValue,
                                              @RequestParam("page") Integer page,
                                              @RequestParam("rows") Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Product> products = productService.searchProductByType(searchValue,page, rows);
        int records = productService.countRecordsByType(searchValue);
        QueryVo<Product> customOrderQueryVo = new QueryVo<>();
        customOrderQueryVo.setRows(products);
        customOrderQueryVo.setTotal(records);
        System.out.println(customOrderQueryVo);
        return customOrderQueryVo;
    }

    @RequestMapping("get/{productId}")
    @ResponseBody
    public Product getProductById(@PathVariable String productId){
        Product product = productService.selectProductById(productId);
        return product;
    }
}
