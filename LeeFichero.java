/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituralecturaficheros;

import java.io.*;

/**
 *
 * @author molonino
 */
public class LeeFichero {
    
//metodo flujo de bytes

    public static String mostrarArchivo(){
        String resultado="----------------------------------------------\n" +
"\n" +
"	  Cartelera de Cinefbmoll\n" +
"\n" +
"----------------------------------------------"+"\n\n" ; 
//variable para guardar el texto
        //lista con las opciones que he de pintar en el nuevo documento
        String[] campos = {"Año: ", "Director: ", "Duración: ", "Sinopsis: ", 
            "Reparto: ", "Sesión: "};
        
        
        String path = "C:\\Users\\molonino\\Desktop\\Practica7_Programacion.txt";
        //variable para guardar la ruta del archivo        
        
        try {
            //instanciar el archivo que se va a leer
            FileInputStream archivo = new FileInputStream(path);
            //crear una variable de tipo int donde se guardara los caracteres
            int unCaracter;
            int i = 0;
            while ((unCaracter = archivo.read()) != -1){
                char c = (char)unCaracter;
                if ( c != '#' && c!='{'){
                    resultado+=c;
                }else if(c == '#'){
                    if(i==3){
                        resultado+=" minutos";  
                    }else if (i==0){
//int a = resultado.lastIndexOf("\n");
                         resultado.replaceFirst("\n","");
                    }
                    
                    resultado+="\n"+ campos[i];
                        
                     i = (i+1)%6;                      
                }else if (c == '{'){
                    resultado+="\n\n";
                }
                
            }
        }catch (IOException e){
            
        }
        
        return resultado;
    }
    

    
}
