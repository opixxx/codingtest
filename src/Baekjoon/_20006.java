package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _20006 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Room> rooms = new ArrayList<>();
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			boolean joined = false;

			for (Room room : rooms) {
				if (room.players.size() >= m) {
					continue;
				}
				if (Math.abs(room.baseLevel - level) > 10) {
					continue;
				}
				room.players.add(new Player(level, name));
				joined = true;
				break;
			}

			if (!joined) {
				Room newRoom = new Room(level);
				newRoom.players.add(new Player(level, name));
				rooms.add(newRoom);
			}

		}

		StringBuilder sb = new StringBuilder();
		for (Room room : rooms) {
			if (room.players.size() == m) {
				sb.append("Started!\n");
			} else {
				sb.append("Waiting!\n");
			}
			room.players.sort(Comparator.comparing(a -> a.name));

			for (Player player : room.players) {
				sb.append(player.level).append(" ").append(player.name).append("\n");
			}
		}
		System.out.print(sb);
	}

	static class Room {
		int baseLevel;
		List<Player> players = new ArrayList<>();

		public Room(int baseLevel) {
			this.baseLevel = baseLevel;
		}
	}
	static class Player {
		int level;
		String name;

		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}
	}
}
