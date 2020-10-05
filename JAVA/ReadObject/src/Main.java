import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Main {

	public static void main(String[] args) {
		InputStream is = null;
		ObjectInputStream ois = null;
		try {
			is = new FileInputStream("E:\\test.bin");
			ois = new ObjectInputStream(is);
			ButLong but = (ButLong) ois.readObject();
			System.out.println(but.isHetMucChua());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
