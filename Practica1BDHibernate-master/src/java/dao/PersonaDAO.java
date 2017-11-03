/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/**
 *
 * @author RigoBono
 */
public class PersonaDAO {
    Session session;//creamos una variable de la clase session
    
    public PersonaDAO(){
        session=HibernateUtil.getLocalSession();//guarda en la session localmente 
    }
    
    public  Persona getPersonaById(int id){//SE crea un metodo de la clase persona con la intancia getPersonaBYId retornando un valor entero
        return (Persona)session.load(Persona.class, id);//retorna un valor de tipo persona cargando a la session el tipo de persona por el id
    }
    
    public List<Persona>  getPersonaByName(String nombre){//creamos inta interfaz lista asignandole el tipo persona retornando el valor nombre  
        List<Persona> listaDePersonas=(List<Persona>)//se crea un objeto de tipo lista y se castea una session y se hace una consulta sql 
                session.createCriteria(Persona.class)//se le crea un criterio el cual devolvera el tipo de dato persona 
                .add(Restrictions.eq("Nombre", nombre));//se agrega la restriccion 
        return listaDePersonas;//retorna mi objeto lista 
    }
    
    public boolean updateById(int id,Persona persona){//se crea un metodo el cual retornara un entero id y una variable persona de la clase persona
        Persona personaAModificar=getPersonaById(id);//se crea un objeto de mi clase persona y se obtiene a persona por su  id
        try{
            Transaction transaccion=session.beginTransaction();//Se crea un objeto de tipo transaccion y de nuestra session se inicia la transaccion
            personaAModificar.setNombre(persona.getNombre());//de mi objeto persona a modificar se setea en nombre y se modifica el nombre con el id actual
            session.update(personaAModificar);//de nuestra session se actualiza de mi clase persona el valor obtenido al setear el nombre
            transaccion.commit();//mi objeto transaccion la session inicializada con la transaccion se actualiza a cada una de nuestrar sessiones con el commit
            return true;//si es verdad todo esto retornara verdadero
        }catch(Exception e){
            return false;//si no retornara falso y mandara un error
        }
    }
    
    public boolean savePersona(String nombre,String materno
        ,String paterno,String telefono,int idTipoPersona){//un metodo que retornara un boolean y se le pasan los parametros  
        Persona personaDeTanque=new Persona();//SE crea un objeto de mi clase persona 
        TipoPersona tipoDeTanque=(TipoPersona)session
                .load(TipoPersona.class, idTipoPersona);//SE crea un objeto de la clase tipo persona , se castea y se obtiene de la session cargando el id del tipo persona
        personaDeTanque.setNombre(nombre);//Se setea el nombre a mi objeto personatanque
        personaDeTanque.setMaterno(materno);//Se setea el materno a mi objeto personatanque
        personaDeTanque.setPaterno(paterno);//Se setea el paterno a mi objeto personatanque
        personaDeTanque.setTelefono(telefono);//Se setea el telefono a mi objeto personatanque
        personaDeTanque.setTipoPersona(tipoDeTanque);//Se setea el tipotanque a mi objeto personatanque
        try{
            Transaction transaccion=session.beginTransaction();//Se crea un objeto de tipo transaccion y de nuestra session se inicia la transaccion
            session.save(personaDeTanque);//a nuestra session de guarda nuestro objeto persona tanque
            transaccion.commit();//mi objeto transaccion la session inicializada con la transaccion se actualiza a cada una de nuestrar sessiones con el commit
            return true;//retorna verdadero
        }catch(Exception e){
            
        }finally{
            
        }
        return true;//retorna verdadero 
    }
    
}
