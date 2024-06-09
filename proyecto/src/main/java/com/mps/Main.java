package com.mps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
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

        long GastoTotalGeneral = 0, gastoTotalLimpieza = 0, gastoTotalCongelados = 0, gastoTotalHigiene = 0, gastoTotalFrescos = 0, gastoTotalEmpaquetados = 0;

        String nombre, ap1, ap2, dni;
        long pL, pC, pH, pF, pE;

        int numfilas = 1;
        Row comp = sheet.getRow(numfilas);
        while (comp!=null) {comp = sheet.getRow(numfilas); numfilas++;}

        Cliente [] clientes = new Cliente[numfilas-2];
        int rownum = 1;
        Row row = sheet.getRow(rownum);
        while (row != null)
        {
            Cell cell = row.getCell(0);
            nombre = cell.getStringCellValue();
            cell = row.getCell(1);
            ap1 = cell.getStringCellValue();
            cell = row.getCell(2);
            ap2 = cell.getStringCellValue();
            cell = row.getCell(3);
            dni = cell.getStringCellValue();
            cell = row.getCell(4);
            pL = (long) cell.getNumericCellValue();
            cell = row.getCell(5);
            pC = (long) cell.getNumericCellValue();
            cell = row.getCell(6);
            pH = (long) cell.getNumericCellValue();
            cell = row.getCell(7);
            pF = (long) cell.getNumericCellValue();
            cell = row.getCell(8);
            pE = (long) cell.getNumericCellValue();

            clientes [rownum-1] = new Cliente(nombre, ap1, ap2, dni, pL, pC, pH, pF, pE);
            rownum++;
            row = sheet.getRow(rownum);
        }
        
        for (int i = 0; i < clientes.length -1; i++) 
        {
            gastoTotalLimpieza += clientes[i].getGastoLimpieza();
            gastoTotalCongelados += clientes[i].getGastoCongelados();
            GastoTotalGeneral += clientes[i].getGastoTotal();
            gastoTotalHigiene += clientes[i].getGastoHigiene();
            gastoTotalFrescos += clientes[i].getGastoFrescos();
            gastoTotalEmpaquetados += clientes[i].getGastoEmpaquetados();
        }







        Workbook result = new XSSFWorkbook();
        final String archivovolcado = "GastosTotales.xlsx";
        Sheet hoja = result.createSheet ("Hoja 1");
        Row fila = hoja.createRow(0);
        Cell Celda = fila.createCell(0);
        Celda.setCellValue("GASTO TOTAL LIMPIEZA");
        Celda = fila.createCell(1);
        String pase = (gastoTotalLimpieza / 100 + "." + Math.abs(gastoTotalLimpieza%100));
        double pasar = Double.parseDouble(pase);
        Celda.setCellValue(pasar);

        fila = hoja.createRow(1);
        Celda = fila.createCell(0);
        Celda.setCellValue("GASTO TOTAL CONGELADOS");
        Celda = fila.createCell(1);
        pase = (gastoTotalCongelados / 100 + "." + Math.abs(gastoTotalCongelados%100));
        pasar = Double.parseDouble(pase);
        Celda.setCellValue(pasar);

        fila = hoja.createRow(2);
        Celda = fila.createCell(0);
        Celda.setCellValue("GASTO TOTAL HIGIENE");
        Celda = fila.createCell(1);
        pase = (gastoTotalHigiene / 100 + "." + Math.abs(gastoTotalHigiene%100));
        pasar = Double.parseDouble(pase);
        Celda.setCellValue(pasar);


        fila = hoja.createRow(3);
        Celda = fila.createCell(0);
        Celda.setCellValue("GASTO TOTAL FRESCOS");
        Celda = fila.createCell(1);
        pase = (gastoTotalFrescos / 100 + "." + Math.abs(gastoTotalFrescos%100));
        pasar = Double.parseDouble(pase);
        Celda.setCellValue(pasar);


        fila = hoja.createRow(4);
        Celda = fila.createCell(0);
        Celda.setCellValue("GASTO TOTAL EMPAQUETADOS");
        Celda = fila.createCell(1);
        pase = (gastoTotalEmpaquetados / 100 + "." + Math.abs(gastoTotalEmpaquetados%100));
        pasar = Double.parseDouble(pase);
        Celda.setCellValue(pasar);


        fila = hoja.createRow(5);
        Celda = fila.createCell(0);
        Celda.setCellValue("GASTO TOTAL");
        Celda = fila.createCell(1);
        pase = (GastoTotalGeneral / 100 + "." + Math.abs(GastoTotalGeneral%100));
        pasar = Double.parseDouble(pase);
        Celda.setCellValue(pasar);


        String [] encabezados = {"NOMBRE", "APELLIDO 1", "APELLIDO 2", "DNI", "GASTO TOTAL"};
        int numfila = 7;
        fila = hoja.createRow(numfila);
        for (int i = 0; i < encabezados.length; i++)
        {
            Celda = fila.createCell(i);
            Celda.setCellValue(encabezados[i]);
        }
        numfila++;
        for (int i = 0; i < clientes.length; i++)
        {
            fila = hoja.createRow(numfila);
            Celda = fila.createCell(0);
            Celda.setCellValue(clientes[i].getNombre());
            Celda = fila.createCell(1);
            Celda.setCellValue(clientes[i].getApellido1());
            Celda = fila.createCell(2);
            Celda.setCellValue(clientes[i].getApellido2());
            Celda = fila.createCell(3);
            Celda.setCellValue(clientes[i].getDNI());
            Celda = fila.createCell(4);
            pase = (clientes[i].getGastoTotal() / 100 + "." + Math.abs(clientes[i].getGastoTotal()%100));
            pasar = Double.parseDouble(pase);
            Celda.setCellValue(pasar);
            numfila++;
        }
        
        
        File directorioActual = new File(".");
        String ubicacion = directorioActual.getAbsolutePath();
        String ubicacionArchivoSalida = ubicacion.substring(0, ubicacion.length() - 1) + archivovolcado;
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(ubicacionArchivoSalida);
            result.write(outputStream);
            result.close();
            System.out.println("Libro guardado correctamente");
        } catch (FileNotFoundException ex) {
            System.out.println("Error de filenotfound");
        } catch (IOException ex) {
            System.out.println("Error de IOException");
        }
    }
}