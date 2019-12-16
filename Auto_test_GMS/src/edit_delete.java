

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class edit_delete {

	public static void edit() throws Exception {
		int i=0;
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:9010/Grocery_Management_System/view_grocery.jsp");
		Thread.sleep(1000);
		String s=driver.getTitle();
		System.out.println(s);
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[6]/button")).click();
	     driver.findElement(By.name("Pname")).clear();
	     driver.findElement(By.name("Pname")).sendKeys("Mango");
	     Thread.sleep(3000);
	     driver.findElement(By.name("Pweight")).clear();
	     driver.findElement(By.name("Pweight")).sendKeys("3");
	     Thread.sleep(3000);
	     driver.findElement(By.name("Pprice")).clear();
	     driver.findElement(By.name("Pprice")).sendKeys("180");
	     Thread.sleep(4000);
	       
	      driver.findElement(By.xpath("/html/body/div/form/button")).click();
	       System.out.println("The item details has been successfully edited and viewed");
	       
			
	     driver.get("http://localhost:9010/Grocery_Management_System/view_grocery.jsp");
	     Thread.sleep(4000);
	 	driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[7]/button")).click();
	 	driver.close();
	}

}

