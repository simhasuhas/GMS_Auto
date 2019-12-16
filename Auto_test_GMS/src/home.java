import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class home {

	public static int xlRows,xlCols;
	public static String[][] xData;
	public static String vUserName;
	public static String vPassWord;
	public static void home() throws Exception 
	{
	
		xlRead("E:\\LoginDetails.xls");
		
		vUserName=xData[1][0];
		vPassWord=xData[1][1];
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Jars\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:9010/Grocery_Management_System/createlogin.jsp");
		driver.findElement(By.id("userename")).sendKeys(vUserName);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(vPassWord);
		Thread.sleep(2000);
		driver.findElement(By.className("actionbtn")).click();
		Thread.sleep(2000);
		String etitle=driver.getTitle();
		if(etitle.equals("home"))
		{
			System.out.println("PASS");
			System.out.println("USER is in homepage");
			
		}
		else
		{
			System.out.println("Fail...user is not in homepage");
		}
		Thread.sleep(2000);
	
		driver.findElement(By.linkText("ADD GROCERY")).click();
		Thread.sleep(4000);
		String etitle1=driver.getTitle();
		if(etitle1.equals("Add Grocery"))
		{
			System.out.println("PASS");
			System.out.println("USER is in Add Grocery Page");
			
		}
		else
		{
			System.out.println("Fail...user has not navigated to Add grocery page");
		}
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.linkText("VIEW GROCERY")).click();
		Thread.sleep(2000);
		String etitle2=driver.getTitle();
		if(etitle2.equals("VIEW GROCERY"))
		{
			System.out.println("PASS");
			System.out.println("USER is in View Grocery Page");
			
		}
		else
		{
			System.out.println("Fail...user has not navigated to View grocery page");
		}
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.findElement(By.linkText("SEARCH GROCERY")).click();
		Thread.sleep(4000);
		String etitle3=driver.getTitle();
		if(etitle3.equals("Insert title here"))
		{
			System.out.println("PASS");
			System.out.println("USER is in Search Grocery Page");
			
		}
		else
		{
			System.out.println("Fail...user has not navigated to Search grocery page");
		}
		Thread.sleep(4000);
		driver.navigate().back();
		WebElement acc=driver.findElement(By.className("tooltip"));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(acc).build().perform();
		driver.findElement(By.linkText("LOGOUT")).click();
		Thread.sleep(4000);
		String etitle4=driver.getTitle();
		if(etitle4.equals("Login"))
		{
			System.out.println("PASS");
			System.out.println("USER has logged out & is in Login Page");
			
		}
		else
		{
			System.out.println("Fail...user has not navigated to Login page");
		}
		driver.close();
	}
	
		
		public static void xlRead(String sPath) throws Exception
		{
				File myFile=new File(sPath);
				FileInputStream myStream=new FileInputStream(myFile);
				HSSFWorkbook myworkbook=new HSSFWorkbook(myStream);
				HSSFSheet mySheet=myworkbook.getSheetAt(0);
				xlRows=mySheet.getLastRowNum()+1;
				xlCols=mySheet.getRow(0).getLastCellNum();
				xData=new String[xlRows][xlCols];
				for(int i=0;i<xlRows;i++)
				{
					HSSFRow row=mySheet.getRow(i);
					for(short j=0;j<xlCols;j++)
					{
						HSSFCell cell=row.getCell(j);
						String value=cellToString(cell);
						xData[i][j]=value;
						System.out.print("-"+xData[i][j]);
					}
					System.out.println();
				}
		}
		
		public static String cellToString(HSSFCell cell)
		{
					int type=cell.getCellType();
					Object result;
					switch(type)
					{
					case HSSFCell.CELL_TYPE_NUMERIC:
					result=cell.getNumericCellValue();
					break;
					case HSSFCell.CELL_TYPE_STRING:
					result=cell.getStringCellValue();
					break;
					case HSSFCell.CELL_TYPE_FORMULA:
					throw new RuntimeException("We cannot evaluate formula");
					case HSSFCell.CELL_TYPE_BLANK:
					result="-";
					case HSSFCell.CELL_TYPE_BOOLEAN:
					result=cell.getBooleanCellValue();
					case HSSFCell.CELL_TYPE_ERROR:
					result="This cell has some error";
					default:
					throw new RuntimeException("We do not support this cell type");
					}
					return result.toString();
					
		}
	}


