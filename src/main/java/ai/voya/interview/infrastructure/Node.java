/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.voya.interview.infrastructure;

/**
 *
 * @author User
 */
public class Node {
    private String word;
    private Node[] children;
    
    Node() {
        word = null;
        children = new Node[26];        
    }
    
    public String getWord() {
        return word;
    } 
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public Node[] getChildren() {
        return children;
    }
    
    public void setChildren(Node[] children) {
        this.children = children;
    }
}
