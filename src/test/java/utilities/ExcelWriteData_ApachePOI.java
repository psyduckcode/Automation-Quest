// Program to Write Excel data using Apache POI in Java

package utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteData_ApachePOI {

    public static void main(String[] args) throws IOException {

        // Sample data in a 2D array
        String[][] data = {
            {"Name", "Platform", "Rating"},
            {"FarCry", "PC", "5+"},
            {"Minecraft", "PC", "4.5"},
            {"FIFA", "Console", "4"}
        };

        // Create workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        // Loop through the data array to write to Excel
        for (int row = 0; row < data.length; row++) 
        {
        	// create new row
            XSSFRow newRow = sheet.createRow(row); 
            
            for (int col = 0; col < data[row].length; col++) 
            {
            //write cell data
                newRow.createCell(col).setCellValue(data[row][col]); 
            }
        }

        // Write workbook to file
        FileOutputStream file = new FileOutputStream("./testData/writeData.xlsx");
        workbook.write(file);
        workbook.close();

        System.out.println("Data written to Excel Sucessfully");
    }
}
