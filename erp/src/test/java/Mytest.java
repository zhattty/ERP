import com.erp.web4j.bean.UnqualifyApply;
import com.erp.web4j.mapper.EmployeeMapper;
import com.erp.web4j.mapper.ProductMapper;
import com.erp.web4j.mapper.UnqualifyApplyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/4 Time 18:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mytest {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Autowired
    ProductMapper  productMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void test1(){
        String s = employeeMapper.selectByEmployeeId(002);
        System.out.println(s);
    }
    @Test
    public void test2(){
        unqualifyApplyMapper.queryUnqualifyApply(0,10);
    }
}
