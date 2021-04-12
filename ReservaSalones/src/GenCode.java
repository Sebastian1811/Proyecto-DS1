/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    import java.io.*;
/**
 *
 * @author eljho
 */
public class GenCode {
    
    
     public  String getCode(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String direccionFile = "F:\\Universidad\\Desarrollo\\Proyecto\\Codigos_reservas.txt";
        String resultado="";
        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (direccionFile);
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;
           
           while((linea=br.readLine())!=null){
                resultado = linea;
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
         
        return resultado;
    }
    
    public void AddCode(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        String direccionFile = "F:\\Universidad\\Desarrollo\\Proyecto\\Codigos_reservas.txt";
        int newAdd = Integer.parseInt(getCode())+1;
        try
        {
            fichero = new FileWriter(direccionFile);
            pw = new PrintWriter(fichero);
            pw.println(newAdd);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
}

