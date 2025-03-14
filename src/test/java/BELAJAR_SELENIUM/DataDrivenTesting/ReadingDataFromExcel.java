package BELAJAR_SELENIUM.DataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingDataFromExcel {
    /*
        langkah2 pemrosesan data excel:
        Excel File -> Workbook -> Sheets -> Rows -> Cells

        FileInputStream = Reading file
        FileOutputStream = Writing file

        XSSFWorkbook = Workbook
        XSSFSheet = sheet
        XSSFRow = Row
        XSSFCell = Cell
     */
    public static void main(String[] args) throws IOException {
        // 1. Reading Data from Excel
        // Excel File
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\BookStore.xlsx");
        // Workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        // Sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        // Rows
        int totalRows = sheet.getLastRowNum();
        int totalCells = sheet.getRow(1).getLastCellNum();

        System.out.println("Number of rows:" + totalRows);
        System.out.println("Number of total cells:" + totalCells);


        for(int row = 0; row <= totalRows; row++){
            XSSFRow currentRow = sheet.getRow(row);
            for(int cell = 0; cell < totalCells; cell++){
                XSSFCell cells = currentRow.getCell(cell);
                System.out.print(cells.toString()+"\t");
            }
            System.out.println();
        }

        // perlu diexit
        workbook.close();
        file.close();



    }

}
