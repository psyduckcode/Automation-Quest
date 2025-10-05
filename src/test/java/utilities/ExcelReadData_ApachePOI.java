// Program to Read Excel data using Apache POI in Java

package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReadData_ApachePOI {

    public static void main(String[] args) throws IOException {

        // Load the Excel file
        FileInputStream file = new FileInputStream("./testData/readData.xlsx");

        // Create workbook instance for XLSX file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Get Sheet
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Find total rows and columns
        int totalRows = sheet.getLastRowNum();
        int totalCol = sheet.getRow(0).getLastCellNum();

        System.out.println("Total Rows: " + totalRows);
        System.out.println("Total Columns: " + totalCol);

        // Loop through rows and columns
        for (int r = 0; r <= totalRows; r++) {
            XSSFRow currentRow = sheet.getRow(r);

            for (int c = 0; c < totalCol; c++) 
            {
                // Handle null cells safely
                if (currentRow.getCell(c) != null) {
                    String currentCell = currentRow.getCell(c).toString();
                    System.out.print(currentCell + "\t");
            } else 
              {
                    System.out.print("No Data in Cell");
              }
            }
            System.out.println();
        }

        // Close resources
        workbook.close();
        file.close();
    }
}
