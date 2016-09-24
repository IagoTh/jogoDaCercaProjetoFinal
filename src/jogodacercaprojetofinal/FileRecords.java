/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodacercaprojetofinal;
import java.io.*;
/**
 *
 * @author Lucas Martins
 */

public class FileRecords {

    /**
     * @param args the command line arguments
     */
    //método que lê o arquivo de records
    public void records() {
        // TODO code application logic here
        //Criação de um diretório.
         //File file = new File ("Diretório Recordes");
         //file.mkdir();
        
        //Criação de arquivo
         //arquivo.createNewFile();
        File arquivo= new File("recordes.txt");
        try{
        FileReader ler=new FileReader("recordes.txt");
        BufferedReader lerbuff=new BufferedReader(ler);
        String linha=lerbuff.readLine();   
        while(linha!=null){
            System.out.println(linha);
             linha=lerbuff.readLine();
        }
        }
        catch(IOException ex){
                
        }
    }
    
}
