package Graph;
import java.util.*;
import java.io.*;
public class Graph {
 
     public static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src , int nbr , int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
  
    //kthLargestPath
    public static void kthLargestPath() {
        
    }

    //Ceil and Floor
    public static void cielAndFloor() {
        
    }

    //shortestPath and largest path(based on weightage)
    static String spath="";
    static int spathWeight=INT_MAX;
    static String lpath="";
    static int lpathWeight=INT_MIN;
    public static void shortestAndLongestPathInGraph(ArrayList<Edge>[] graph,int src, int dest, String psf ,  int wsf, boolean[] visited) {
        if(src==dest){
            if(spathWeight<wsf){
                spath=psf;
                spathWeight=wsf;
            }

            if(lpathWeight<wsf){
                lpath= psf;
                lpathWeight= wsf;
            }
            psf="";
            wsf="";
            return;
        }
            visited[src]=true;

            for(Edge e:graph[src]){
                if(visited[e.nbr]!=true)
                shortestAndLongestPathInGraph(graph,e.nbr , dest, psf, wsf,visited);
            }
            visited[src]=false;
            
        }
       
    //displayAllPaths
    public static void displayAllPaths(ArrayList<Edge>[] graph , int src , int dest , boolean[] visited,String asf) {
        if(src==dest){
            System.out.println(asf);
            return;
        }

            visited[src]=true;
            for(Edge e: graph[src]){
                if(visited[e.nbr]==false){
                    displayAllPaths(graph, e.nbr, dest, visited, asf+ e.nbr);
                }
                
            }
            visited[src]=false;
        
    }
    //haspath
    public static boolean haspath(ArrayList<Edge>[] graph,int src , int dest,boolean[] visited) {
                if(src==dest) return true;

                visited[src] =true;
        for(Edge e:graph[src]){
            if(visited[e.nbr]!=true){
                boolean hasNbrpath = haspath(graph, e.nbr, dest,visited);
                if(hasNbrpath)return true;
        }
    }
        return false;
    }
    //display-graph
    public static void displayGraph(ArrayList<Edge>[] graph) {
        for(int i=0;i<graph.length;i++){
            for(Edge e : graph[i]){
                System.out.println(e.src+" --> "+ e.src+" - "+e.nbr+" @ "+e.wt);
            }
            System.out.println();
        }
    }
    //add Edge
    public static void addEdge(ArrayList<Edge>[] graph , int src , int nbr  , int wt){

        for(int i=0;i<graph.length;i++){
            graph[src].add(new Edge(src, nbr, wt));
            graph[nbr].add(new Edge(nbr, src, wt));
        }
        
    }
    public static void main(String[] args) throws Exception {
        int vt=7;
       
        ArrayList<Edge>[] graph = new ArrayList[vt];
        for(int i=0;i<vt;i++){
            graph[i]=new ArrayList<>();
        }

        int arr[][]={
            {0,1,10},
            {1,2,10},
            {2,3,10},
            {0,3,40},
            {3,4,8},
            {4,5,6},
            {5,6,3},
            {6,4,7}
        };

        for(int i=0;i<arr.length;i++){
            int v1 = arr[i][0];
            int v2 =arr[i][1];
            int wt = arr[i][2];
            graph[v1].add(new Edge(v1, v2,wt));
            graph[v2].add(new Edge(v2, v1, wt));
        
        }

        // displayGraph(graph);
        boolean visited[] = new boolean[vt];
        // System.out.println(haspath(graph, 0, 7 , visited));
        // displayAllPaths(graph,0,6,visited,0+"");
        shortestAndLongestPathInGraph(graph, 0, 6, "", 0,visited);
        System.out.println("Shortest PATH : "+spath+" with weight "+spathWeight);
        System.out.println("Longest Path "+lpath+" with weight "+lpathWeight);
    
}
}