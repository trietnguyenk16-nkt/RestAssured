package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import groovyjarjarantlr4.v4.parse.BlockSetTransformer.setAlt_return;

public class ExcelUtils {
    
    public static void main(String[] args) {

        getRowCount();
        getCellData();
    }

    public static void getRowCount()  {
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook("./Data/TestData.xlsx");
            XSSFSheet sheet = workbook.getSheet("MySheet");
            int rowCount = sheet.getPhysicalNumberOfRows();
    
            System.out.println("Number of Rows: " + rowCount);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

    }

    public static void getCellData() {
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook("./Data/TestData.xlsx");
            XSSFSheet sheet = workbook.getSheet("MySheet");
           
            String cellValue = sheet.getRow(1).getCell(0).getStringCellValue();

            System.out.println("Cell Value is: " + cellValue);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
