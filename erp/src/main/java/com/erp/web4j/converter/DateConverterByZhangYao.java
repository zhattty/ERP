package com.erp.web4j.converter;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 16:37
 */

public class DateConverterByZhangYao implements Converter<String, Date>{

    @Override
    public Date convert(String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date parse = null;
        try {
            parse = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
