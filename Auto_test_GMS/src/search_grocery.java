import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class search_grocery {

	public static void search() throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:9010/Grocery_Management_System/search_grocery.jsp");
		String title=driver.getTitle();
		if(title.equals("Search Grocery"))
		{
			System.out.println("Pass... user is in search grocery page");
		}
		else
		{
			System.out.println("Fail....user has not navigated to search grocery page");
		}
		Thread.sleep(2000);
		driver.findElement(By.name("Pid")).sendKeys("p001");
		driver.findElement(By.className("actionBtn")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("actionBtn")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
