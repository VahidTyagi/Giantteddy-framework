//package com.giantteddy.utilities;
//
//
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class ExcelUtils {
//
//    private Workbook workbook;
//    private Sheet sheet;
//
//    // Load Excel file and select sheet
//    public void loadExcel(String filePath, String sheetName) {
//        try {
//            FileInputStream fis = new FileInputStream(filePath);
//            workbook = new XSSFWorkbook(fis);
//            sheet = workbook.getSheet(sheetName);
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load Excel file: " + filePath);
//        }
//    }
//
//    // Get cell data
//    public String getCellData(int rowNum, int colNum) {
//        DataFormatter formatter = new DataFormatter();
//        Row row = sheet.getRow(rowNum);
//        if (row != null) {
//            Cell cell = row.getCell(colNum);
//            return cell != null ? formatter.formatCellValue(cell) : "";
//        }
//        return "";
//    }
//
//    // Set cell data and save file
//    public void setCellData(int rowNum, int colNum, String value, String filePath) {
//        try {
//            Row row = sheet.getRow(rowNum);
//            if (row == null) {
//                row = sheet.createRow(rowNum);
//            }
//            Cell cell = row.getCell(colNum);
//            if (cell == null) {
//                cell = row.createCell(colNum);
//            }
//            cell.setCellValue(value);
//
//            FileOutputStream fos = new FileOutputStream(filePath);
//            workbook.write(fos);
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to write to Excel file: " + filePath);
//        }
//    }
//
//    // Get number of rows
//    public int getRowCount() {
//        return sheet.getLastRowNum() + 1;
//    }
//
//    // Get number of columns in a row
//    public int getColumnCount(int rowNum) {
//        Row row = sheet.getRow(rowNum);
//        return row != null ? row.getLastCellNum() : 0;
//    }
//
//    // Close workbook
//    public void closeWorkbook() {
//        try {
//            if (workbook != null) {
//                workbook.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
