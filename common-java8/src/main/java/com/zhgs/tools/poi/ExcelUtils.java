package com.zgs.com.zgs.tools.poi;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc:
 * @Author: zhouguangsheng
 * @Date: create by 2020/5/29 10:40
 * @Modify By:
 */
public class ExcelUtils {

    private final static String SHEET_NAME1 = "问题";
    private final static String SHEET_NAME2 = "关键词";

    public static void main(String[] args) throws IOException {
//        //使用文件
//        工作簿wb = WorkbookFactory.create（new File（“ MyExcel.xls”））;;
////使用InputStream，需要更多的内存
//        工作簿wb = WorkbookFactory.create（new FileInputStream（“ MyExcel.xlsx”））;

        InputStream fileIn = Thread.currentThread().getContextClassLoader().getResourceAsStream("kb-template.xlsx");

        Workbook sheets = WorkbookFactory.create(fileIn);
        Sheet sheet = sheets.getSheet(SHEET_NAME1);
        Row row = sheet.getRow(0);
        System.out.println("title cell数量" + (row.getLastCellNum() - row.getFirstCellNum()));


        XSSFWorkbookFactory a;
    }
}
