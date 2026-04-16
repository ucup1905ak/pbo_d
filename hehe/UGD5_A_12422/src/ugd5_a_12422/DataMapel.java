/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd5_a_12422;


import java.util.List;
import java.util.ArrayList;


public class DataMapel<T> {
    private List<T> list;
    
    public DataMapel(){
        list = new ArrayList<>();
    }
    
    public void addMapel(T data){
        list.add(data);
    }
    
    public void displayMapel(){
        
        for (T data : list){
            System.out.print(data);
        }
        
     System.out.println();
    }
}

        


