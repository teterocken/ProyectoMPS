package com.mps;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

public class TestMain 
{
    @Test
    public void TestLecturaCorrecta () throws Exception
    {
        File f = new File ("Clientes.xlsx");
        InputStream inp = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(0);

        assertEquals ("Manuel", cell.getStringCellValue());
        
    }

    @Test
    public void TestEscrituraCorrecta () throws Exception
    {
        File f = new File ("GastosTotales.xlsx");
        InputStream inp = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        
        Row row = sheet.getRow(8);
        Cell cell = row.getCell(3);

        assertEquals ("12341353J", cell.getStringCellValue());
        
    }
}
