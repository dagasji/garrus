package org.garrus.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTimeMapper {

    public String asString(Date date) {
        return date != null ? new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" )
            .format( date ) : null;
    }

    public Date asDate(String date) {
        try {
        	Date ret = date != null ? new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" ).parse( date ) : null;
            return ret;
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
    }
    
    @Test
    public void test() {
    	String date = "2018-10-01T12:14:23";
    	System.out.print(asDate(date));
    }
}