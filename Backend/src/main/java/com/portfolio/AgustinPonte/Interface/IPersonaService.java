/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.AgustinPonte.Interface;

import com.portfolio.AgustinPonte.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //Traer una lista persona 
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto lo buscamos por id
    public void delatePersona(Long id);
    
    //Buscar una persona por id
    public Persona findPersona(Long id);
}
