package JavaPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaPractice11_01 {

	public static void main(String[] args) throws IOException {

		File file = new File("resource/readme.txt");

		try {

			FileReader fr = new FileReader(file);

			int c = -1;
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}

			fr.close();


		} catch (FileNotFoundException e) {

			System.out.println("Can't read file.");

		}

	}

}
