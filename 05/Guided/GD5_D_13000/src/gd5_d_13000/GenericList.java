/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd5_d_13000;

/**
 *
 * @author farel
 */
import java.util.ArrayList;
import java.util.List;

public class GenericList <T> {
    private List<T> list;

    public GenericList(){
        list = new ArrayList<>();
    }

    public void add(T data){
        list.add(data);
    }

    public void remove(int index){
        list.remove(index);
    }

    public int getIndex(T data){
        return list.indexOf(data);
    }

    public void update(int index, T data){
        list.set(index, data);
    }

    public boolean isFound(T data){
        return list.contains(data);
    }

    public void print(){
        for(T data : list){
            System.out.print(data);
        }
        System.out.println();
    }
}