package com.mps;

public class Cliente 
{
    private String nombre, apellido1, apellido2, DNI;
    private long gastoLimpieza, gastoCongelados, gastoHigiene, gastoFrescos, gastoEmpaquetados, gastoTotal;

    public Cliente (String nom, String ap1, String ap2, String nif, long gL, long gC, long gH, long gF, long gE)
    {
        nombre = nom;
        apellido1 = ap1;
        apellido2 = ap2;
        DNI = nif;
        gastoLimpieza = gL;
        gastoCongelados = gC;
        gastoHigiene = gH;
        gastoFrescos = gF;
        gastoEmpaquetados = gE;
        gastoTotal = gastoLimpieza + gastoCongelados + gastoHigiene + gastoFrescos + gastoEmpaquetados;
    }

    public String getNombre () {return nombre;}
    public String getApellido1 () {return apellido1;}
    public String getApellido2 () {return apellido2;}
    public String getDNI () {return DNI;}
    public long getGastoLimpieza () {return gastoLimpieza;}
    public long getGastoCongelados () {return gastoCongelados;}
    public long getGastoHigiene () {return gastoHigiene;}
    public long getGastoFrescos () {return gastoFrescos;}
    public long getGastoEmpaquetados () {return gastoEmpaquetados;}
    public long getGastoTotal () {return gastoTotal;}

}
