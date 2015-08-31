package com.iapppay.code.tools;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static final String SUFFIX_XLS = ".xls";
    public static final String SUFFIX_XLSX = ".xlsx";

    public static <T> T readExcel(File file, ExcelCallback<T> excelCallback)
            throws Exception {
        Workbook book = null;
        // 构造workbook
        if (file.getName().endsWith(SUFFIX_XLS)) {
            book = new HSSFWorkbook(new FileInputStream(file));
        } else {
            book = new XSSFWorkbook(new FileInputStream(file));
        }
        // 通过workbook获取工作表
        int sheetNum = book.getNumberOfSheets();
        if (sheetNum <= 0) {
            throw new Exception("没有可用的工作表!Excel文件名为：" + file.getName());
        }
        return excelCallback.doInWorkbook(book);
    }

    public static String convert(Cell cell) {
        int cellType = cell.getCellType();
        switch (cellType) {
        case Cell.CELL_TYPE_BLANK:
            return "";
        case Cell.CELL_TYPE_BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());
        case Cell.CELL_TYPE_ERROR:
            return String.valueOf(cell.getErrorCellValue());
        case Cell.CELL_TYPE_FORMULA:
            return cell.getCellFormula();
        case Cell.CELL_TYPE_NUMERIC:
            return String.valueOf(cell.getNumericCellValue());
        case Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();
        default:
            return "";
        }
    }

    public static String getIntStr(Cell cell) {
        String value = convert(cell);
        return String.valueOf(new Double(value).intValue());
    }

    public static void createCell(Row row, int index, CellStyle style,
            String value) {
        Cell cell = row.createCell(index);
        cell.setCellStyle(style);
        cell.setCellValue(value);
    }

    public static CellStyle createCellStyle(Workbook wb, short color) {
        CellStyle style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(color);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        return style;
    }
}
