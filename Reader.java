/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joshg
 */
public class Reader {

    
   String[] array = new String[50];
    public String[] read(String path) throws IOException{
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            int k = 0;
            while((line = reader.readLine()) != null){
                array[k] = line;
                k++;
            }
                
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
}
