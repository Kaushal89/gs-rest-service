package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
    // TODO Implement the /words/{word} endpoint
	//end point url: http://localhost:8011/words/palindrome
	@RequestMapping(method = RequestMethod.POST, value = "/words/palindrome")
	public boolean isPalindrome(String palindrome) {
		String original = palindrome, reverse = "";
		int length = original.length();

		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);

		if (original.equals(reverse))
			return true;
		else
			return false;
		

	}
	
	//End point url : http://localhost:8011/words/word
	@RequestMapping(method = RequestMethod.POST, value = "/words/word")
	public boolean is_AnagramPalindrome(String word) {
		int oddOccur = 0;
		int[] count = new int[256];

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			count[ch]++;
		}

		for (int cnt : count) {
			if (oddOccur > 1) {
				return false;
			}
			if (cnt % 2 == 1) {
				oddOccur++;
			}
		}
		return true;
	}

}
