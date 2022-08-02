/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem_29
 */
class Edge{
        public final double cost;
        public final Node target;

        public Edge(Node targetNode, double costVal){
                target = targetNode;
                cost = costVal;
        }
}