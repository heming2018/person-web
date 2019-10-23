package cn.heming.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author heming
 * @date 2019/10/15 13:49
 * @description TODO
 */
public class DateConverter implements Converter<String, Date> {
    private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);


    @Override
    public Date convert(String source) {
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        datetimeFormat.setLenient(false);
        Date date = null;
        try {
            date = datetimeFormat.parse(source);
        } catch (ParseException e) {
            logger.error("Failed covert date from: {}", source, e);
        }
        return date;
    }
}