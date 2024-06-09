package com.mps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Main {
    public static void main(String[] args) throws Exception
    {
        File f = new File ("Clientes.xlsx");
        InputStream inp = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
    }
}