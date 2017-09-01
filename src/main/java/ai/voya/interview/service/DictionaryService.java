package ai.voya.interview.service;

import ai.voya.interview.infrastructure.Dictionary;
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
    public boolean wordExistsInDictionary(String word) {
        return false;
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
        return new ArrayList<>();
    }

}
