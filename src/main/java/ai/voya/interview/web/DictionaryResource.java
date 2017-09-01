package ai.voya.interview.web;

import ai.voya.interview.service.DictionaryService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by ionutradu on 01/09/2017.
 */
@RestController
@RequestMapping("/api/dictionary")
public class DictionaryResource {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/exists", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isWordInDictionary(@RequestParam("word") String word) {
        return ResponseEntity.ok(dictionaryService.wordExistsInDictionary(word));
    }

    @RequestMapping(value = "/fuzzyMatch", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findWordWithFuzzyMatch(@RequestParam("word") String word) {
        return ResponseEntity.ok(dictionaryService.findWithFuzzyMatch(word));
    }

}
