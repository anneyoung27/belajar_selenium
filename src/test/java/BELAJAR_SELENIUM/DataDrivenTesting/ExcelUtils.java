package BELAJAR_SELENIUM.DataDrivenTesting;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    /*
        Data Driven Testing steps:
        1) Functionality (Test case)
        2) Prepare test data in Excel
        3) Develop automation script
     */
    public static FileInputStream fileInputStream;
    public static FileOutputStream fileOutputStream;
    public static XSSFWorkbook xssfWorkbook;
    public static XSSFSheet xssfSheet;
    public static XSSFRow xssfRow;
    public static XSSFCell xssfCell;
    public static CellStyle cellStyle;

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        fileInputStream = new FileInputStream(xlFile);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet(xlSheet);

        int rowCount = xssfSheet.getLastRowNum();
        xssfWorkbook.close();;
        fileInputStream.close();

        return rowCount;
    }

    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
        fileInputStream = new FileInputStream(xlFile);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet(xlSheet);
        xssfRow = xssfSheet.getRow(rowNum);

        int cellCount = xssfRow.getLastCellNum();
        xssfWorkbook.close();
        fileInputStream.close();

        return cellCount;
    }

    public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fileInputStream = new FileInputStream(xlFile);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet(xlSheet);
        xssfRow = xssfSheet.getRow(rowNum);
        xssfCell = xssfRow.getCell(colNum);

        String data;
        try{
            //data = cell.toString();
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(xssfCell);
        }catch (Exception e){
            data = "";
        }

        xssfWorkbook.close();
        fileInputStream.close();

        return data;
    }

    public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
        fileInputStream = new FileInputStream(xlFile);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet(xlSheet);
        xssfRow = xssfSheet.getRow(rowNum);
        xssfCell = xssfRow.createCell(colNum);
        xssfCell.setCellValue(data);
        fileOutputStream = new FileOutputStream(xlFile);

        xssfWorkbook.write(fileOutputStream);
        xssfWorkbook.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void fillGreenColor(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fileInputStream = new FileInputStream(xlFile);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet(xlSheet);
        xssfRow = xssfSheet.getRow(rowNum);
        xssfCell = xssfRow.getCell(colNum);

        cellStyle = xssfWorkbook.createCellStyle();

        // coloring
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        xssfCell.setCellStyle(cellStyle);
        fileOutputStream = new FileOutputStream(xlFile);
        xssfWorkbook.write(fileOutputStream);
        xssfWorkbook.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void fillRedColor(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fileInputStream = new FileInputStream(xlFile);
        xssfWorkbook = new XSSFWorkbook(fileInputStream);
        xssfSheet = xssfWorkbook.getSheet(xlSheet);
        xssfRow = xssfSheet.getRow(rowNum);
        xssfCell = xssfRow.getCell(colNum);

        cellStyle = xssfWorkbook.createCellStyle();

        // coloring
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        xssfCell.setCellStyle(cellStyle);
        fileOutputStream = new FileOutputStream(xlFile);
        xssfWorkbook.write(fileOutputStream);
        xssfWorkbook.close();
        fileInputStream.close();
        fileOutputStream.close();
    }



    
}
