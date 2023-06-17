package Graphs;
import java.util.*;
public class KruskalsAlgo {
    static class Edge implements Comparable<Edge>{
        public int vertex1,vertex2,weight;
        public Edge(int vertex1,int vertex2,int weight){
            this.vertex1=vertex1;
            this.vertex2=vertex2;
            this.weight=weight;
        }
        public int compareTo(Edge o) {
            if(weight==o.weight){
                return 0;
            }
            if(weight>o.weight){
                return 1;
            }
            return -1;
        }
    
    }
    public static int union(int vert,int parents[]){
        int val=parents[vert];
        while(true){
            if(val==parents[val]){
                break;
            }
            val=parents[val];
        }
        return val;
    }
    public static void kruskal(Edge arr[]){
        ArrayList<Edge>ans=new ArrayList<>();
        int parents[]=new int[arr.length];
        for(int i=0;i<parents.length;i++){
            parents[i]=i;
        }
        Arrays.sort(arr);
        int count=0,val=-1,ind=0;
        while(count!=arr.length){
            if(ind==arr.length){
                break;
            }
            if(arr[ind].weight>=val){
                int vert1=union(arr[ind].vertex1,parents);
                int vert2=union(arr[ind].vertex2,parents);
                if(vert1!=vert2){
                    ans.add(arr[ind]);
                    parents[vert1]=vert2;
                    count+=1;
                    val=arr[ind].weight;
                }
            }
            ind+=1;
        }
        for(Edge it:ans){
            System.out.println(it.vertex1+" "+it.vertex2+" "+it.weight);
        }
    }
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int v=input.nextInt();
        int e=input.nextInt();
        Edge arr[]=new Edge[e];
        for(int i=0;i<arr.length;i++){
            int vertex1=input.nextInt();
            int vertex2=input.nextInt();
            int weight=input.nextInt();
            Edge inputvert=new Edge(vertex1, vertex2, weight);
            arr[i]=inputvert;
        }
        System.out.println("Printing the MST");
        kruskal(arr);
    }
}
