
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// here i using a hash map for building a graph 
// then i create a function they take 3 parameters one is vertex one is edge another is Boolean so 
// if ther is no vertex i want to add a vertex and it is the same case of edge 
public class Graph {
    
    Map<Integer,List <Integer>> map = new HashMap<>();
    
    public void addvertex(Integer data){
        map.put(data, new ArrayList<>());
    }
    public void insert(Integer vertex , Integer edge ,boolean isBidirectional){
        if(!map.containsKey(vertex)){
            addvertex(vertex);
        }
        if(!map.containsKey(edge)){
            addvertex(edge);
        }
        map.get(vertex).add(edge);
        if(isBidirectional){
            map.get(edge).add(vertex);
        }
    }
    public void display(){
        for(Integer x : map.keySet()){
            System.out.print(x + " : ");
            for(Integer y : map.get(x)){
                System.out.print(y +"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph gr = new Graph();
        gr.insert(2, 3, true);
        gr.insert(3, 4, false);
        gr.insert(4, 5, true);

        gr.display();
    }
}
