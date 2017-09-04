package ai.voya.interview.service;

import ai.voya.interview.infrastructure.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ionutradu on 01/09/2017.
 */
@Service
public class DictionaryService {

    private Dictionary dictionary = new Dictionary();

    /**
     * @param word  the word we are looking for
     * @return      if the value exists in the dictionary
     *
     * Note: this method should perform the search as fast as possible
     * Hint: trie
     */
    public void insertWord(String word) {
        dictionary.insertWord(word);
    }
    
    public boolean wordExistsInDictionary(String word) {
        Node current = dictionary.getRoot();
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (current.getChildren()[c-'a'] == null) return false; 
            current = current.getChildren()[c-'a'];
        }
        if (current.getWord()==null) return false;
        return true;
    }

    /**
     * @param word  the word we are looking for but with a grammar mistake (e.g. looking for `programming`,
     *              but the user requests `programing` (single `m`) or `programmng` (missing `i`)
     * @return      a list of words that are fuzzy matched
     *
     * Note: only 1 letter is missing or it's wrong
     * Hint: edit distance
     */
    public List<String> findWithFuzzyMatch(String word) {
        int[] current = new int[word.length()+1];
        for (int i=0; i<current.length; i++)
            current[i] = i;
        List<String> results = new ArrayList<String>();        
        Node root = dictionary.getRoot();
        for (int i=0; i<root.getChildren().length; i++)
            if(root.getChildren()[i] != null) 
                recursiveSearch(root.getChildren()[i], i, word, current, results);
        return results;
    }
    
    private void recursiveSearch(Node node, int letter, String word, int[] previous, List<String> results) {
        int[] current = new int[word.length()+1];
        current[0] = previous[0] + 1;
        for (int i=1; i<=word.length(); i++) {
            int insert = current[i-1] + 1;
            int delete = previous[i] + 1;
            int replace;
            if (word.charAt(i-1)-'a' != letter) replace = previous[i-1] + 1;
            else replace = previous[i-1];
            if (insert <= delete && insert <= replace) current[i] = insert;
            else if (replace <= delete) current[i] = replace;
            else current[i] = delete;
        }
        if (current[current.length-1] <= 1 && node.getWord() != null) results.add(node.getWord());
        int min = current[0];
        for (int i=1; i<current.length; i++)
            if (current[i] < min) min = current[i];
        if (min <= 1)
            for (int i=0; i<node.getChildren().length; i++)
                if(node.getChildren()[i] != null) 
                    recursiveSearch(node.getChildren()[i], i, word, current, results);
    }

}
