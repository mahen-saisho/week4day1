package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.sendKeys("Mahe");
		
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		
		String compare = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		if(compare.contains("Mahe")) {
			System.out.println("Given input is matched");
			
		}
		else {
			System.out.println("Mismatch");
			
		}
	}

}
