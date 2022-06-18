package Tugas;

import java.util.Scanner;
public class Graph {
    static int vertex;
    static LinkedList list[];

    public Graph(int vertex){
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for(int i=0;i<vertex;i++){
            list[i] = new LinkedList();
        }
    }

    public static void addEdge(int source, int destination){
        list[source].addFirst(destination);
        list[destination].addFirst(source);
    }

    public static void degree(int source) throws Exception{
        System.out.println("degree vertex "+source +" : "+list[source].size());

        int k, totalIn=0, totalOut=0;
        for(int i=0;i<vertex;i++){
            for(int j=0;j<list[i].size();j++){
                if(list[i].get(j)==source)
                ++totalIn;
            }
        for(k=0;k<list[source].size();k++){
            list[source].get(k);
        }
        totalOut=k;
        }
        System.out.println("Indegree dari vertex "+source+" : "+totalIn);
        System.out.println("Outdegree dari vertex "+source+" : "+totalOut);
        System.out.println("Degree vertex "+source+" : "+(totalIn+totalOut));
    }

    public static void removeEdge(int source, int destination) throws Exception{
        for(int i=0;i<vertex;i++){
            if(i==destination){
                list[source].remove(destination);
            }
        }
    }

    public void removeAllEdges(){
        for(int i=0;i<vertex;i++){
            list[i].clear();
        }
        System.out.println("Graph berhasil dikosongkan!");
    }

    public static void printGraph() throws Exception{
        for (int i=0;i<vertex;i++){
            if(list[i].size()>0){
                System.out.print("Vertex " +i+ " terhubung dengan: ");
                for(int j=0;j<list[i].size();j++){
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println("");
            }
        }
        System.out.println(" ");
    }
    
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan vertex graph : ");
        int v = sc.nextInt();
        Graph G = new Graph(v);
        System.out.print("Masukkan banyak edge : ");
        int e = sc.nextInt();
        for (int i = 0; i < e; i++) {
            System.out.print("Masukkan Source : ");
            int source = sc.nextInt();
            System.out.print("Masukkan Destination : ");
            int des = sc.nextInt();

            G.addEdge(source, des);

        }
        G.printGraph();
        Graph.addEdge(0, 1);
        Graph.addEdge(0, 4);
        Graph.addEdge(1, 2);
        Graph.addEdge(1, 3);
        Graph.addEdge(1, 4);
        Graph.addEdge(2, 3);
        Graph.addEdge(3, 4);
        Graph.addEdge(3, 0);
        Graph.removeEdge(1, 2);
        Graph.printGraph();
        Graph.degree(2);
    }
}
