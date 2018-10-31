package testDao;

public class DontAskTest {
public static void main(String[] args) {
	String upload_file = "C:\\fakepath\\1539851774109.jpg";
	String [] get = upload_file.split("\\\\");
	System.out.println(get.length);
	System.out.println("C:\\temp\\"+get[2]);
}
}
