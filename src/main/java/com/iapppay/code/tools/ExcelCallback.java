package com.iapppay.code.tools;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelCallback<T> {

    T doInWorkbook(Workbook book);

}