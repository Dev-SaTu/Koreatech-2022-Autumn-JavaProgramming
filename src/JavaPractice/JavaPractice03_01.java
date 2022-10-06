package JavaPractice;

public class JavaPractice03_01 {

	public static void main(String[] arg) {

		Song mySong = new Song("Nessun Dorma");
		Song yourSong = new Song("���ִ� �� �� �̷��");
		System.out.println("�� �뷡�� " + mySong.getTitle());
		System.out.println("�� �뷡�� "+ yourSong.getTitle());

	}

}

class Song {

	String title;

	public Song(String title) {

		this.title = title;

	}

	public String getTitle() {

		return title;

	}

}