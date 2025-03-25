package LeetCode.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();

		String s = "pwwkew";
		System.out.println(sol.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {

		Set<Character> set = new HashSet<>();
		int lt =0;
		int rt = 0;
		int res = 0;

		while (rt < s.length()) {
			char cur = s.charAt(rt);
			if (!set.contains(cur)) {
				set.add(cur);
				rt++;
				res = Math.max(res, set.size());
			} else {
				set.remove(s.charAt(lt));
				lt++;
			}
		}

		return res;

	}
}
