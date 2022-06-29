package advanced.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {

	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		try (FileInputStream fis = new FileInputStream("src/advanced.resources/photo.jpg");
				FileOutputStream fos = new FileOutputStream("src/advanced.resources/photoCopy.jpg")
		) {
			while (fis.read(buffer) != -1) {
				fos.write(buffer);
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
