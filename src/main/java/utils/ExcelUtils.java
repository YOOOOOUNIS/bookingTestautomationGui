package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int colCount = sheet.getRow(0).getLastCellNum();

        // Use a dynamic list so we can stop early
        List<Object[]> rowDataList = new ArrayList<>();

        // Start from 1 to skip header
        for (int i = 1; ; i++) {
            Row row = sheet.getRow(i);

            // If the row is null or completely empty → stop reading
            if (row == null || isRowEmpty(row)) {
                break;
            }

            Object[] rowData = new Object[colCount];
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                rowData[j] = (cell != null) ? cell.toString() : "";
            }
            rowDataList.add(rowData);
        }

        workbook.close();
        fis.close();

        return rowDataList.toArray(new Object[0][0]);
    }

    // Helper to check if row is empty
    private static boolean isRowEmpty(Row row) {
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }
}
