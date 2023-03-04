import java.util.Scanner;

public class MusicAlbum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] albums = new String[100]; // Array to store the album names
		String[][] songs = new String[100][100]; // 2D array to store the songs in each album
		int[] songCount = new int[100]; // Array to store the number of songs in each album
		int albumCount = 0; // Counter to keep track of the number of albums

		while (true) {
			System.out.println("Menu:");
			System.out.println("1. Add Album");
			System.out.println("2. Add Music");
			System.out.println("3. Show Music");
			System.out.println("4. Show Album & Music");
			System.out.println("5. Exit");

			System.out.print("Enter option: ");
			int choice = input.nextInt();

			if (choice == 1) {
				System.out.print("Enter the name of the music album: ");
				input.nextLine(); // Consume the newline character
				String album = input.nextLine();

				albums[albumCount] = album;
				songCount[albumCount] = 0;
				albumCount++;

				System.out.println("The music album has been added.");
			} else if (choice == 2) {
				if (albumCount == 0) {
					System.out.println("Please add an album first.");
				} else {
					System.out.println("Select an album to add songs to:");
					for (int i = 0; i < albumCount; i++) {
						System.out.println((i + 1) + ". " + albums[i]);
					}
					int albumIndex = input.nextInt();
					input.nextLine(); // Consume the newline character
			
					if (albumIndex < 1 || albumIndex > albumCount) {
						System.out.println("Invalid album selected.");
					} else {
						System.out.println("Enter the name(s) of the song(s), separated by commas:");
						String[] songNames = input.nextLine().split(",");
						int numSongs = songNames.length;
			
						for (int i = 0; i < numSongs; i++) {
							String song = songNames[i].trim();
							songs[albumIndex - 1][songCount[albumIndex - 1]] = song;
							songCount[albumIndex - 1]++;
						}
			
						System.out.println("The song(s) have been added to the music album.");
					}
				}
			}
			
			else if (choice == 3) {
				if (albumCount == 0) {
					System.out.println("No albums available. Please add an album first.");
				} else {
					System.out.println("Select an album to display its songs:");
					for (int i = 0; i < albumCount; i++) {
						System.out.println((i+1) + ". " + albums[i]);
					}
			
					System.out.print("Enter album number: ");
					int albumNumber = input.nextInt();
			
					if (albumNumber < 1 || albumNumber > albumCount) {
						System.out.println("Invalid album number. Please try again.");
					} else {
						int albumIndex = albumNumber - 1;
						System.out.println("Songs in " + albums[albumIndex] + ":");
						if (songCount[albumIndex] == 0) {
							System.out.println("No songs available in this album.");
						} else {
							System.out.print("[");
							for (int i = 0; i < songCount[albumIndex] - 1; i++) {
								System.out.print(songs[albumIndex][i] + ", ");
							}
							System.out.println(songs[albumIndex][songCount[albumIndex]-1] + "]");
						}
					}
				}
			}
			  else if (choice == 4) {
				System.out.println("List of available music albums and songs:");
				for (int i = 0; i < albumCount; i++) {
					System.out.println((i+1) + ". " + albums[i]);
					System.out.print("   Songs: [");
					for (int j = 0; j < songCount[i]; j++) {
						System.out.print(songs[i][j]);
						if (j != songCount[i] - 1) {
							System.out.print(", ");
						}
					}
					System.out.println("]");
				}
			}
			 else if (choice == 5) {
				System.out.println("Exiting program. Goodbye!");
				break;
			} else {
				System.out.println("Invalid choice. Please enter a number between 1 and 5.");
			}
		}

		input.close(); // close the scanner object to avoid resource leak
	}
}
