/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

/**
 *
 * @author qrajput
 */
public class HashTable {
    int[] Table;
    
    HashTable(){
    Table =new int[10];
    }
     HashTable(int size){
    Table =new int[size+(size/3)];
    }
     
     int Hash(int key){
      return key%Table.length;
     }
     int LHash(int key){
         return (key+1)%Table.length;
     }
     int Qhash(int key, int i){
         return(key+(i*i))%Table.length;
     }
    public void insert(int key){
        int index=Hash(key);
                if(Table[index]==0){
             Table[index]=key; 
            // System.out.println("["+index+"]" +Table[index]); return;
        }else{ 
      int i=1;
        while(i<Table.length && Table[index]!=0){
             // System.out.println("collision on key "+key+"---- \n"+"["+index+"]" +Table[index]);
              index=Qhash(key,i);
              i++;
        } 
        if(i>=Table.length){
            System.out.println("Table is Full");
        }
        else{
            Table[index]=key;
            //System.out.println("["+index+"]" +Table[index]);
            
        }
        }
        
    }
    public String toString(){
        String str="";
        for (int i = 0; i < Table.length; i++) {
            str=str+"["+i+"] "+Table[i]+"\n";
        }
    return str;
    }
}
