package utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProvider {
    public static String makeIntegerWithoutDecimal(String number)
    {
        String convertedNumber=number;

        try
        {
            int i = Integer.parseInt(number);
            convertedNumber = ""+i;
        }
        catch (Exception e)
        {

        }


        return  convertedNumber;
    }

    public static Object[][] getMyData(String filepath,String sheetName) throws IOException {
        // 1. read file
        FileInputStream fis = new FileInputStream(filepath);
        //2. convert file object into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //3. choose sheet
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        for (int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for (int j=0;j<colCount ;j++) {

                XSSFCell cell = row.getCell(j);
                if(cell==null)
                    data[i][j] = "";
                else{
                    cell.setCellType(CellType.STRING);
                    data[i][j] = makeIntegerWithoutDecimal(cell.toString().trim());
                }
            }
        }

        return data;
    }
}
