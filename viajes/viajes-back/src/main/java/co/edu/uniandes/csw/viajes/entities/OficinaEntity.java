/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;


/**
 *
 * @author m.rodriguez21
 */
public class OficinaEntity extends BaseEntity implements Serializable
{
    private String nombreLugar;
    private String nombreEncargado;
    
    
    public String getNombreLugar()
    {
        return nombreLugar;
    }
    
    public void setNombreLugar(String nombreLugar)
    {
        this.nombreLugar = nombreLugar;
    }
    
    public String getNombreEncargado()
    {
        return nombreEncargado;
    }
    
    public void setNombreEncargado(String nombreEncargado)
    {
        this.nombreEncargado = nombreEncargado;
    }
    
}
