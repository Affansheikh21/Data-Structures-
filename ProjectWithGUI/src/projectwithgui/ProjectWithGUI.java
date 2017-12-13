package projectwithgui;

import java.util.*;

// Hospitals LinkedList
class Node {

    String name;
    String address;
    double rating;
    double distance;

    Node prev;
    Node next;

    Node(String d, String a, double r, double b) {
        name = d;
        address = a;
        rating = r;
        distance = b;

    }

    public String getData() {
        return "Name: " + name + "\n" + " Address: " + address + "\n" + " Rating: " + rating + "\n" + " Distance: "
                + distance + "\n" + "\n";
    }
}

class List<T extends Comparable<T>> {

    Node Head;
    Node Tail;

    public void insert(String d, String a, double e, double q) {

        Node N = new Node(d, a, e, q);

        if (Head == null) {
            Head = N;
            Tail = N;
        } else {
            N.prev = Tail;
            Tail.next = N;
            Tail = N;
        }
    }

    public void InsertInOrder(String d, String a, double e, double q) {

        Node N = new Node(d, a, e, q);
        Node temp = Head;
        Node previous = Head;
        if (Head == null) {
            Head = N;
            Tail = N;
        } else {
            while (temp != null && (N.rating > temp.rating)) {
                previous = temp;
                temp = temp.next;
            }
            // first
            if (temp == Head) {
                N.next = temp;
                temp.prev = N;
                Head = N;
            } // last
            else if (temp == null) {
                N.prev = Tail;
                Tail.next = N;
                Tail = N;
            } // Middle case
            else {
                previous.next = N;
                temp.prev = N;
                N.next = temp;
                N.prev = previous;
            }
        }
    }

    public void InsertInOrderdistance(String d, String a, double e, double q) {

        Node N = new Node(d, a, e, q);
        Node temp = Head;
        Node previous = Head;
        if (Head == null) {
            Head = N;
            Tail = N;
        } else {
            while (temp != null && (N.distance < temp.distance)) {
                previous = temp;
                temp = temp.next;
            }
            // first
            if (temp == Head) {
                N.next = temp;
                temp.prev = N;
                Head = N;
            } // last
            else if (temp == null) {
                N.prev = Tail;
                Tail.next = N;
                Tail = N;
            } // Middle case
            else {
                previous.next = N;
                temp.prev = N;
                N.next = temp;
                N.prev = previous;
            }
        }
    }

    public Node Find(String v) {
        Node temp = Head;
        while (temp.next != null && v.compareTo(temp.name) != 0) {
            temp = temp.next;
        }
        if (temp.getData().equals(v)) {
            return temp;
        } else {
            return null;
        }
    }

    public void delete(String v) {
        Node temp = Find(v);
        if (temp == null) {
            System.out.println("data not found");
        } else if (temp == Head) {
            Head = Head.next;
            Head.prev = null;
        } else {
            temp.prev.next = temp.next;
        }

    }

    public void clearList() {
        Head = null;
        Tail = null;

    }

    public String toString() {
        String str = "";
        Node Temp = Head;
        while (Temp != null) {
            str = str + Temp.name + "---Addresss:  " + Temp.address + "---Rating:  " + Temp.rating + "\n" + "\n";
            Temp = Temp.next;
        }

        return str;
    }

}

// Graph
class vertex {

    String name;
    String address;
    double rating;
    double distance;
    LinkedList<vertex> L;

    vertex(String d, String a, double r, double b) {
        name = d;
        address = a;
        rating = r;
        distance = b;
        L = new LinkedList();

    }
}

class Graph {

    int count;

    ArrayList<vertex> AdjList;

    Graph(int s) {
        AdjList = new ArrayList(s);
        count = 0;
    }

    public void AddVertex(vertex v) {
        AdjList.add(v);
        count++;
    }

    public void AddEdge(vertex v1, vertex v2) {
        int index2 = -1;
        int index1 = -1;
        if (AdjList.contains(v1)) {
            index1 = AdjList.indexOf(v1);
        }
        if (AdjList.contains(v2)) {
            index2 = AdjList.indexOf(v2);
        }
        if (index1 == -1 || index2 == -1) {
            System.out.println("Edge cannot insert vertex does not exist");
        } else {
            AdjList.get(index1).L.add(v2);
            AdjList.get(index2).L.add(v1);
        }
    }

    public void BFS() {
        // This method display all vertices in wise manner
        boolean[] visit = new boolean[AdjList.size()];
        Queue<vertex> Q = new ArrayDeque();

        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == false) {
                LinkedList<vertex> l = AdjList.get(i).L;
                visit[i] = true;
                Q.add(AdjList.get(i));
                System.out.println(AdjList.get(i).name);
                vertex v;

                while (!Q.isEmpty()) {
                    v = Q.remove();
                    for (int j = 0; j < v.L.size(); j++) {
                        int ind = AdjList.indexOf(l.get(j));
                        if (visit[ind] == false) {
                            Q.add(AdjList.get(j));
                            visit[ind] = true;
                            System.out.println(l.get(j).name);
                        }
                    }

                }
            }
        }

    }

   public void ShortPathDist(vertex v1, vertex v2){
    // exactly same as in BFS just match the taget if match then stop
     boolean[] visit = new boolean[AdjList.size()];
        Queue<vertex> Q = new ArrayDeque();
        int sourseIndex=-1;
        int cost=0;
        
        if(AdjList.contains(v1)){
          sourseIndex=AdjList.indexOf(v1);
        }
        System.out.println("Shortest Path distance");
            
        if(sourseIndex!=-1){
        for (int i = sourseIndex; i < visit.length; i++) {
            if(visit[i]==false){
            visit[i] = true;
                System.out.println(AdjList.get(i).name + " - ");
            Q.add(AdjList.get(i));
      
            vertex v;
            while (!Q.isEmpty()) {
                v = Q.remove();
                for (int j = 0; j < v.L.size(); j++) {
                   if(v.L.contains(v2)){
                       
                       System.out.println("cost="+cost);
                       return;
                   }
                   else{
                     int ind=AdjList.indexOf(v.L.get(j));
                    if (visit[ind] == false) {
                        Q.add(AdjList.get(j));
                        visit[ind] = true;
                        System.out.println(AdjList.get(ind).name + " - ");
                        cost++;
                    } 
                    }
                }
            }
            }
            }
        }
    
    }

  
  
  
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  
  
  
  
    public void DisplayGraph() {
        LinkedList<vertex> l;
        for (int i = 0; i < AdjList.size(); i++) {
            l = AdjList.get(i).L;
            System.out.print(AdjList.get(i).name + "--> ");
            for (int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j).name + ", ");
            }
            System.out.println();
        }

    }

    public String display() {
        String s = " ";
        LinkedList<vertex> l;
        for (int i = 0; i < AdjList.size(); i++) {
            l = AdjList.get(i).L;
            System.out.print(AdjList.get(i).name + "--> ");
            for (int j = 0; j < l.size(); j++) {
                s = s + l.get(j).name + "\n";
            }

        }
        return s;
    }

    public void CC_DFS() {
        boolean[] visit = new boolean[count];
        int[] ccomp = new int[count];
        int cc = 0;
        int j = 0;
        Stack<vertex> stk;
        stk = new Stack();

        while (j <= visit.length) {
            if (j == visit.length) {
                break;
            } else if (visit[j] == true) {
                j++;
                continue;
            } else {
                cc++;
                stk.push(AdjList.get(j));
                visit[j] = true;
                System.out.println(" " + AdjList.get(j).name);
                ccomp[j] = cc;
                int i;
                while (!stk.empty()) {
                    LinkedList<vertex> l = stk.peek().L;

                    for (i = 0; i < l.size() && visit[AdjList.indexOf(l.get(i))] != false;) {
                        i++;
                    }
                    if (i < l.size() && visit[AdjList.indexOf(l.get(i))] == false) {
                        visit[AdjList.indexOf(l.get(i))] = true;
                        stk.push(l.get(i));
                        ccomp[AdjList.indexOf(l.get(i))] = cc;
                        System.out.println(" " + l.get(i).name);
                    } else {
                        stk.pop();
                    }
                }

            }
            j++;
        }
        System.out.println("total connected component=" + cc);

    }
}

class AreaArray {

    ArrayList areaarr = new ArrayList();

    void AddData(String n, List l, Graph g) {
        AreaNode newnode = new AreaNode(n, l, g);
        areaarr.add(newnode);
    }

    void displayListAreas() {
        for (int i = 0; i < areaarr.size(); i++) {
            System.out.println(areaarr.get(i).toString());
        }
    }

    void display(int i) {
        System.out.println(areaarr.get(i).toString());

    }

}

class AreaNode {

    String name;
    List list;
    Graph graph;

    AreaNode(String n, List l, Graph g) {
        name = n;
        list = l;
        graph = g;
    }

    public String toString() {
        String s = " ";
        s = list.toString();
        String g = graph.display();
        return " Name :" + name + "\n" + " List of Hospitals" + s + "\n" + g;

    }
}

public class ProjectWithGUI {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Home h = new Home();
        h.setVisible(true);
        
        List list = new List();

        list.InsertInOrderdistance("Patel Hospital", "ST-18, Block-4, Gulshan-e-Iqbal,Karachi - 75300, Pakistan.، Karachi, Pakistan", 3.6, 5.8);
        list.InsertInOrderdistance("Ibn-Sina Hospital", "St-22-B,, University Rd, Block 6, Gulshan-e-Iqbal, Sindh، Karachi, Pakistan", 3.8, 4.2);
        list.InsertInOrderdistance("Samdani Hospital", "a 560 block, Street No 5, Karachi, Pakistan", 2.3, 5.3);
        list.InsertInOrderdistance("AL Mustafa Medical", "ST-1 Block 13-C Gulshan-e-Iqbal، University Road، Karachi, Pakistan", 4.1, 17);
        list.InsertInOrderdistance("Haji Rang Elahi Hospital", "St 4B, Block-4, Gulshan E Iqbal, Karachi, Karachi, Pakistan", 4.6, 5.4);
        list.InsertInOrderdistance("NIBD Hospital", "Gulshan-e-Iqbal, Karachi, Pakistan", 4.2, 7.5);
        list.InsertInOrderdistance("T.O Clinic Hospital", "no, Street 1, Karachi, Pakistan", 3.1, 5.4);

        AreaArray arr = new AreaArray();

        Graph g = new Graph(20);
        g.AddVertex(new vertex("Patel Hospital", "ST-18, Block-4, Gulshan-e-Iqbal,Karachi - 75300, Pakistan.، Karachi, Pakistan", 3.6, 5.8)); // v0
        g.AddVertex(new vertex("Ibn-Sina Hospital", "St-22-B,, University Rd, Block 6, Gulshan-e-Iqbal, Sindh، Karachi, Pakistan", 3.8, 4.2)); // v1
        g.AddVertex(new vertex("Samdani Hospital", "a 560 block, Street No 5, Karachi, Pakistan", 2.3, 5.3)); // v2
        g.AddVertex(new vertex("AL Mustafa Medical", "ST-1 Block 13-C Gulshan-e-Iqbal، University Road، Karachi, Pakistan", 4.1, 17)); // v3
        g.AddVertex(new vertex("Haji Rang Elahi Hospital", "St 4B, Block-4, Gulshan E Iqbal, Karachi, Karachi, Pakistan", 4.6, 5.4)); // v4
        g.AddVertex(new vertex("NIBD Hospital", "Gulshan-e-Iqbal, Karachi, Pakistan", 4.2, 7.5));// v5
        g.AddVertex(new vertex("T.O Clinic Hospital", "no, Street 1, Karachi, Pakistan", 3.1, 5.4));// v5

        g.AddEdge(g.AdjList.get(0), g.AdjList.get(1));
        g.AddEdge(g.AdjList.get(0), g.AdjList.get(2));
        g.AddEdge(g.AdjList.get(0), g.AdjList.get(3));
        g.AddEdge(g.AdjList.get(0), g.AdjList.get(4));
        g.AddEdge(g.AdjList.get(0), g.AdjList.get(5));
        g.AddEdge(g.AdjList.get(1), g.AdjList.get(0));
        g.AddEdge(g.AdjList.get(1), g.AdjList.get(2));
        g.AddEdge(g.AdjList.get(2), g.AdjList.get(3));
        g.AddEdge(g.AdjList.get(3), g.AdjList.get(5));
        g.AddEdge(g.AdjList.get(3), g.AdjList.get(4));
        g.AddEdge(g.AdjList.get(4), g.AdjList.get(0));
        g.AddEdge(g.AdjList.get(4), g.AdjList.get(3));
        g.AddEdge(g.AdjList.get(4), g.AdjList.get(5));
        g.AddEdge(g.AdjList.get(5), g.AdjList.get(0));
        g.AddEdge(g.AdjList.get(5), g.AdjList.get(4));
       

        arr.AddData("Gulshan", list, g);

        List PECHSlist = new List();
        PECHSlist.InsertInOrderdistance("Shehroz Medical Centre", "NOT ENTERED", 3.6, 5.8);
        PECHSlist.InsertInOrderdistance("Karim Clinic", "NOT ENTERED", 4.5, 3.2);
        PECHSlist.InsertInOrderdistance("Gupta Memorial Hospital", "NOT ENTERED", 3.8, 7.2);
        PECHSlist.InsertInOrderdistance("Aisha's Dental Clinic", "NOT ENTERED", 4.1, 1.9);
        PECHSlist.InsertInOrderdistance("Asghar National Hospital", "NOT ENTERED", 3.2, 4.2);

        Graph PECHSgraph = new Graph(15);
        PECHSgraph.AddVertex(new vertex("Shehroz Medical Centre", "NOT ENTERED", 3.6, 5.8));//v0
        PECHSgraph.AddVertex(new vertex("Karim Clinic", "NOT ENTERED", 4.5, 3.7));//v1
        PECHSgraph.AddVertex(new vertex("Gupta Memorial Hospital", "NOT ENTERED", 3.8, 7.2)); //v2
        PECHSgraph.AddVertex(new vertex("Aisha's Dental Clinic", "NOT ENTERED", 4.1, 1.9)); //v3
        PECHSgraph.AddVertex(new vertex("Asghar National Hospital", "NOT ENTERED", 3.2, 4.2)); //v4

        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(0), PECHSgraph.AdjList.get(1));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(0), PECHSgraph.AdjList.get(3));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(1), PECHSgraph.AdjList.get(1));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(1), PECHSgraph.AdjList.get(2));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(1), PECHSgraph.AdjList.get(4));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(2), PECHSgraph.AdjList.get(3));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(2), PECHSgraph.AdjList.get(1));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(3), PECHSgraph.AdjList.get(4));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(4), PECHSgraph.AdjList.get(2));
        PECHSgraph.AddEdge(PECHSgraph.AdjList.get(4), PECHSgraph.AdjList.get(3));

        arr.AddData("PECHS", PECHSlist, PECHSgraph);
        //System.out.println(PECHSlist.toString());

        //PECHSgraph.DisplayGraph();
        //arr.display(1);
        //	PECHSgraph.CC_DFS();
        //PECHSgraph.ShortPathDist(PECHSgraph.AdjList.get(0), PECHSgraph.AdjList.get(1));
        //	System.out.println(list.toString()); 
        //g.BFS();
        System.out.println();
        // g.CC_DFS();
        System.out.println();
        //	g.ShortPathDist(g.AdjList.get(0), g.AdjList.get(4));
        //System.out.println();
        //System.out.println("Nearest Hospital(central location IBA)" + " " + list.Head.name);
       // System.out.println("Distance:" + list.Head.distance);
        //System.out.println(g.AdjList.get(3).name);
      //  g.ShortPathDist(g.AdjList.get(0), g.AdjList.get(3));
    }

}
