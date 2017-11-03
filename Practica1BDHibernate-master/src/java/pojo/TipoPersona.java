/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  #Pray4Tanque
 * @author RigoBono
 */
@Entity//el renglon de una tabla
@Table(name="TipoPersona", catalog="generationHibernate")//se selecciona la tabla con el nombre y el catalogo que seria el nombre del esquema
public class TipoPersona {//clase tipo persona
    
    @Id @GeneratedValue//se le asigna una primary key y se le genera un auto incremento 
    @Column(name="idTipoPersona")//para asignar la columna el identificador
    private int idTipoPersona;//variable tipo int 
    
     @Column(name="TipoPersonacol")//se le asigna a ala columna el identidicador de esta
    private String TipoPersona;
     
     public TipoPersona(){//constructor vacio de mi clase
         
     }
     

    /**
     * @return the idTipoPersona
     */
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() {
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) {
        this.TipoPersona = TipoPersona;
    }
     
     
     
     
    
}
