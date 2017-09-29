package InterviewQuestions;
/**
 * Given a input string, return the longest substring with no repeat character
 * 
 * @author ysu1
 *
 */
public class LongestUnrepeatedSubstring {
	public static void main(String[] args) {
		String input1 = "abcadcefe";
		String input = "abcsabcdefghabcdefghijklmnocad";
		String output = findLongestUnrepeatedSubString(input);
		System.out.println(output);
	}

	private static String findLongestUnrepeatedSubString(String input) {
		if (input == null || input.length() == 0) {
			return null;
		}
		int len = input.length();
		int start = 0;
		int maxLen = 1;
		int maxStart = 0;
		boolean[] used = new boolean[26];
		for (int i = 0; i < len; i++) {
			char c = input.charAt(i);
			if (used[c - 'a'] == false) {
				used[c - 'a'] = true;
			} else {
				while (used[c - 'a'] == true && start <= i) {
					used[input.charAt(start) - 'a'] = false;
					start++;
				}
				used[c - 'a'] = true;
			}
			if (maxLen < i - start + 1) {
				maxLen = i - start + 1;
				maxStart = start;
				System.out.println("maxLen:" + maxLen + "; maxStart:" + maxStart + "; subString: " + input.substring(maxStart, maxStart + maxLen));
				for (boolean b : used) {
					System.out.print(b == true ? "t " : "f ");
				}
				System.out.println();
			}			
		}
		return input.substring(maxStart, maxStart + maxLen);
	}
}
