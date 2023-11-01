import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class main {
	public static void main (String[] args) throws IOException {
        int ch; 
        List<String> nums = new ArrayList<>();
        Scanner scnr = new Scanner(new File("C:\\\\Users\\\\UserName\\\\Desktop\\\\aids.txt"));
        
        while(scnr.hasNextLine()) {
        	nums.add(scnr.nextLine());
        }
		scnr.close();
		
		Magic mg = new Magic(nums);
		mg.run();
		
		
	}
}

class Magic{
	List<String> nums;
	String url = "URL NAME";
	
	public Magic(List<String> nums) {
		this.nums = nums;
		
	}

	public void run() {
		for(int i = 0; i < nums.size(); i++) {
			try {
				print(nums, i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void print(List<String> nums2, int i) throws IOException {
		String temp = url+nums2.get(i);
		WebDriver driver = new ChromeDriver();
		driver.get(temp);
		
		try {
		    Thread.sleep(1500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		String htmlContent = driver.getPageSource();

		driver.quit();
		
		Document fl = Jsoup.parse(htmlContent);
		Element content = fl.getElementById("caracteristicas");
		Element content1 = fl.getElementById("caracteristicas1");
		System.out.println();
		System.out.print(nums2.get(i)+ "->>");
		for(Element e: content.children()) {
			System.out.print(e.text());
			System.out.print(", ");
		}
		for(Element e: content1.children()) {
			System.out.print(e.text());
			System.out.print(", ");
		}
	}
}