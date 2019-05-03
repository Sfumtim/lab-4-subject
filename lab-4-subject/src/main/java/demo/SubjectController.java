package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
	private static Logger log = LoggerFactory.getLogger(SubjectController.class);
	@Value("${words}") String words;
	  
	  @GetMapping("/")
	  public @ResponseBody String getWord() {
	    String[] wordArray = words.split(",");
	    int i = (int)Math.round(Math.random() * (wordArray.length - 1));
	    return wordArray[i];
	  }
	  @RequestMapping(value = "/greeting")
	  public String greet() {
	    log.info("Access /greeting");

	    List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
	    Random rand = new Random();

	    int randomNum = rand.nextInt(greetings.size());
	    return greetings.get(randomNum);
	  }

	  @RequestMapping(value = "/hi")
	  public String home() {
	    log.info("Access /");
	    return "Hi!";
	  }
}
