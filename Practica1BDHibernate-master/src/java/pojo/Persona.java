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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 */

@Entity//el renglon de una tabla
@Table(name="Persona",catalog="generationHibernate")//se selecciona la tabla con el nombre y el catalogo que seria el nombre del esquema
public class Persona {//clase publica de persona
    
    @Id @GeneratedValue//se le asigna una primary key y se le genera un auto incremento 
    @Column(name="idPersona")//para asignar la columna el identificador
    private int idPersona;//variable entera id persona
    
    @Column(name="Nombre",nullable=true)//se asigna la columna y de ponen las condiciones en este jemplo que sea null
    private String Nombre;//variable string nombre
    
    @Column(name="Paterno")//se le asigna a ala columna el identidicador de esta
    private String Paterno;//variable string paterno
    
     @Column(name="Materno")//se le asigna a ala columna el identidicador de est
    private String Materno;//variable string materno
     
     @Column(name="Telefono")//se le asigna a ala columna el identidicador de est
    private String Telefono;//variable string telefono
    
     @ManyToOne//La relacion que existira entre tablas
     @JoinColumn(name="idTipoPersona")//se crea la llave foranea con la que se relacionaran las tablas atravez del identificador idtipopersona
    private TipoPersona tipoPersona;//se le asigna una variable a mi clase de tipo persona

    /**
     * @return the idPersona
     */
    public int getIdPersona() {//getter de cada variable 
        return idPersona;//el tipo de retorno
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {//setter de cada variable
        this.idPersona = idPersona;//se asigna a mi variable el parametro haciendome yo como referencia 
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {//getter de cada variabl
        return Nombre;//el tipo de retorno
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {//setter de cada variable
        this.Nombre = Nombre;//se asigna a mi variable el parametro haciendome yo como referencia
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {//getter de cada variabl
        return Paterno;//el tipo de retorno
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {//setter de cada variable
        this.Paterno = Paterno;//se asigna a mi variable el parametro haciendome yo como referencia
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {//getter de cada variabl
        return Materno;//el tipo de retorno
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {//setter de cada variable
        this.Materno = Materno;//se asigna a mi variable el parametro haciendome yo como referencia
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {//getter de cada variabl
        return Telefono;//el tipo de retorno
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {//setter de cada variable
        this.Telefono = Telefono;//se asigna a mi variable el parametro haciendome yo como referencia
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {//getter de cada variabl
        return tipoPersona;//el tipo de retorno
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {//setter de cada variable
        this.tipoPersona = tipoPersona;//se asigna a mi variable el parametro haciendome yo como referencia
    }
     
     
    
}
