/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem_29
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Greedy_BFS {
       
        //print the path of the target node.
        public static List<Node> GreedyprintPath(Node target){
                List<Node> path = new ArrayList<Node>();
        
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
            
        }

        Collections.reverse(path);

        return path;
        }
        
        
        //Greedy search implementation
        public static void Greedy_BFS(Node source, Node goal){

                Set<Node> explored = new HashSet<Node>();

                PriorityQueue<Node> queue = new PriorityQueue<Node>(20, 
                        new Comparator<Node>(){
                                 //override compare method
                 public int compare(Node i, Node j){
                    if(i.h_scores > j.h_scores){
                        return 1;
                    }

                    else if (i.h_scores < j.h_scores){
                        return -1;
                    }

                    else{
                        return 0;
                    }
                 }

                        }
                        );

                //cost from start
                source.g_scores = 0;

                Node current=source;

                boolean found = false;

                while(!found){

                        //the node in having the lowest f_score value
                        Node next=current;

                        explored.add(current);

                        //goal found
                        if(current.value.equals(goal.value)){
                            
                                found = true;
                        }
                          double temp_h_scores=999;
                        //check every child of current node
                        for(Edge e : current.adjacencies){
                            
                                Node child = e.target;
                                double cost = e.cost;
                                 
                                /*if child node has been evaluated and 
                                the newer f_score is higher, skip*/
                                
                                if(temp_h_scores >= child.h_scores){
                                     temp_h_scores= child.h_scores;
                                       next=child;       
                                }

                                /*else if child node is not in queue or 
                                newer f_score is lower*/
                                
                                else if((!queue.contains(child)) || 
                                        (temp_h_scores < child.h_scores)){
                                    
                                         continue; 
                                }
                        }
                        
                        next.parent=current;
                        current = next;
                        
                        if(current.value.equals(goal.value)){
                             
                                found = true;
                        }

                }

        }
        
}