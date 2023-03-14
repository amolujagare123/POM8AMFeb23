package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {


    public static String convertDate(String dbDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);
        return  new SimpleDateFormat("MM/dd/yyyy").format(date);
    }

    public static String getGender(String genderId)
    {
        String gender = "";

        switch (genderId)
        {
            case "0" : gender ="Male";break;
            case "1" : gender ="Female";break;
            case "2" : gender ="Other";break;
        }
        return gender;
    }

    public static String convertCountry(String countryShort) // IN
    {
        String convertedCountry ="";

        switch (countryShort)
        {
            case "IN" : convertedCountry="India";break;
            case "HU" : convertedCountry="Hungary";break;
            case "MG" : convertedCountry="Madagascar";break;
            case "MY" : convertedCountry="Malaysia";break;
            case "MX" : convertedCountry="Mexico";break;

        }
        return  convertedCountry;
    }
}
