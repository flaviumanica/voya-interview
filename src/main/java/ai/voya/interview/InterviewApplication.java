package ai.voya.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ai.voya.interview.service.DictionaryService;

@SpringBootApplication
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
                DictionaryService ds = new DictionaryService();
                ds.insertWord("temp");
                ds.insertWord("hemps");
                ds.insertWord("help");
                ds.insertWord("helps");
                ds.insertWord("hep");
                ds.insertWord("ehmp");
                ds.insertWord("me");
                System.out.println("Help exists in dictionary = " + ds.wordExistsInDictionary("help"));
                System.out.println("Hemp exists in dictionary = " + ds.wordExistsInDictionary("hemp"));
                System.out.println("Suggested words for hemp: " + ds.findWithFuzzyMatch("hemp"));
	}
}
