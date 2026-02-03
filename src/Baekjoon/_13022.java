package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _13022 {
	public static void main(String[] args) throws IOException {
		Set<String> set = new HashSet<>();

		set.add("wolf");
		set.add("wwoollff");
		set.add("wwwooolllfff");
		set.add("wwwwoooollllffff");
		set.add("wwwwwooooolllllfffff");
		set.add("wwwwwwoooooollllllffffff");
		set.add("wwwwwwwooooooolllllllfffffff");
		set.add("wwwwwwwwoooooooollllllllffffffff");
		set.add("wwwwwwwwwooooooooolllllllllfffffffff");
		set.add("wwwwwwwwwwoooooooooollllllllllffffffffff");
		set.add("wwwwwwwwwwwooooooooooolllllllllllfffffffffff");
		set.add("wwwwwwwwwwwwoooooooooooollllllllllllffffffffffff");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		List<String> list = new ArrayList<>();

		String tmp = "";

		for (int i = 0; i < input.length(); i++) {
			if (i == input.length() - 1) {
				tmp += input.charAt(i);
				list.add(tmp);
			} else if (input.charAt(i) == 'f') {
				if (input.charAt(i + 1) != 'f') {
					tmp += input.charAt(i);
					list.add(tmp);
					tmp = "";
				}

				if (input.charAt(i + 1) == 'f') {
					tmp += input.charAt(i);
				}
			} else if (input.charAt(i) != 'f') {
				tmp += input.charAt(i);
			}
		}

		int answer = 1;
		for (String a : list) {
			if (!set.contains(a)) {
				answer = 0;
			}
		}

		System.out.println(answer);

	}
}
