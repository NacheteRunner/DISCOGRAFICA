
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marin
 */
public class AccesoADatos {
    
    static String ruta = "src/ficheros/fichero.txt";
    
    public static ArrayList<String> leerDatosFichero(){
        
        ArrayList<String> datos = new ArrayList<>();
        
        try {
            // Necesito un FileReader
            FileReader fr = new FileReader(ruta);
            // Bufer de lectura
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine())!=null){
                datos.add(linea);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoADatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoADatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    public static boolean escribirDatosFichero(ArrayList<String> datos){
        
        File fileABorrar = new File(ruta); 
        fileABorrar.delete(); //Borramos fichero cada vez que cerramos la aplicacion
        
        File file = new File(ruta);
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try
        {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);

            for(String linea : datos){
                pw.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fw)
               fw.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        return true;
    }
    
}
