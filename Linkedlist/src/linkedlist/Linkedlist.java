
package linkedlist;
import java.util.*;
class Node<T> {
T data;
Node next;
Node prev;
Node(){}
Node(T data){
this.data=data;
next=null;
prev=null;
}
}

class List<T>{
Node head;
Node tail;
List(){
head=null;
tail=null;
        }

void insert(T data){
Node temp;
Node n = new Node(data);
    if (head==null) {
       n.next=head;
       head=n;
    }
    else { temp=head;
    while(temp.next!=null){
    temp=temp.next;
    }
        if (temp.next==null) {
            temp.next=n;
            n.next=null;
            tail=n;
        }
        else {
   n.next=temp.next;
   temp.next=n; }
    }
}   
void Display(){
Node temp = head;
    if (head==null) {
        System.out.print(" List is empty ");
    }
    else {
    while(temp!=null){
        System.out.print(temp.data + " ");
        temp=temp.next;
    }
    }
}
}
public class Linkedlist {

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
   
    }
    
}
