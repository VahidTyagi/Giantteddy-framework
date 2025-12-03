//package com.giantteddy.utilities;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestDataUtil {
//
//    private static Workbook workbook;
//
//    // Load Excel file
//    public static void loadExcelFile(String filePath) {
//        try {
//            FileInputStream fis = new FileInputStream(filePath);
//            workbook = new XSSFWorkbook(fis);
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load Excel file: " + filePath);
//        }
//    }
//
//    // Get sheet data as list of string arrays
//    public static List<String[]> getSheetData(String sheetName) {
//        if (workbook == null) {
//            throw new RuntimeException("Excel file not loaded. Call loadExcelFile() first.");
//        }
//
//        List<String[]> data = new ArrayList<>();
//        Sheet sheet = workbook.getSheet(sheetName);
//        DataFormatter formatter = new DataFormatter();
//
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // skip header row
//            Row row = sheet.getRow(i);
//            if (row != null) {
//                String[] rowData = new String[row.getLastCellNum()];
//                for (int j = 0; j < row.getLastCellNum(); j++) {
//                    rowData[j] = formatter.formatCellValue(row.getCell(j));
//                }
//                data.add(rowData);
//            }
//        }
//        return data;
//    }
//
//    // Close workbook
//    public static void closeWorkbook() {
//        try {
//            if (workbook != null) {
//                workbook.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
