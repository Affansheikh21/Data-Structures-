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
import java.util.Random;

public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    HashTable HT=new HashTable(6);
    
   Random R=new Random();
    int key;
   /*     for (int i = 0; i < 20; i++) {
            data=R.nextInt(80);
            System.out.println("data= "+data+"\n");
                  HT.insert(data);
        }*/
   HT.insert(230);
    HT.insert(213);
    HT.insert(223);
    HT.insert(22);
    HT.insert(234);
    HT.insert(231);
    HT.insert(235);
    HT.insert(237);
    HT.insert(239);
    
    
    
    
        System.out.println(HT);
    
    }
    
}
