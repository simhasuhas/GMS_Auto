import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class signup {

	public static void signup() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:9010/Grocery_Management_System/signup.jsp");
		driver.findElement(By.name("username")).sendKeys("Rashmi");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("rao");
		Thread.sleep(2000);
		driver.findElement(By.name("confirmpassword")).sendKeys("rao");
		Thread.sleep(2000);
		driver.findElement(By.className("signupbtn")).click();
		Thread.sleep(2000);
		driver.get("http://localhost:9010/Grocery_Management_System/signup.jsp");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/form/center/a")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[1]/td[2]/input")).sendKeys("Rashmi");
		//Thread.sleep(2000);
	}

}

