import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void login() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//---------------------------------------valid login----------------------------------------------------
		driver.get("http://localhost:9010/Grocery_Management_System/createlogin.jsp");
		driver.findElement(By.id("userename")).sendKeys("Rashmi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[2]/td[2]/input")).sendKeys("rao");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(4000);
		//-------------------------------------invalid login-----------------------------------------------------
		driver.navigate().to("http://localhost:9010/Grocery_Management_System/createlogin.jsp");
		driver.findElement(By.id("userename")).sendKeys("Rashmi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/a")).click();

	}

}

