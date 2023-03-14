package Runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BaseClass.BaseClass1;

public class Nykaa_Runner extends BaseClass1{
	//public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		browserLaunch("chrome" );
		maximize();
		threadsleep(1000);
		geturl("https://www.nykaa.com/");
		refresh();
		navigate("https://www.nykaa.com/giftcard/list");
		//back("https://www.nykaa.com/");
		threadsleep(1000);
		//SEARCH ITEM
		sendkeys(driver.findElement(By.xpath("//input[@placeholder='Search on Nykaa']")), "facemask-orange\n");
		click(driver.findElement(By.xpath("//div[text()='Nat Habit Fresh Daily Ubtan Face Pack - Sweet Orange (Pack O...']")));
		threadsleep(1000);
		//ADD TO BAG
		singlemultiple();
		multiplewindowhandle("//div[@class='css-vp18r8']");
		click(driver.findElement(By.xpath("//div[@class='css-vp18r8']")));
		threadsleep(1000);
		//CLICK THE BAG
		click(driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']")));
		threadsleep(1000);

		WebElement element =(driver.findElement(By.xpath("//iframe[@class='css-acpm4k']")));
		driver.switchTo().frame(element);
		//dropdown("value",driver.findElement(By.xpath("//iframe[@class='css-acpm4k']")),"3");
		//iframe(driver.findElement(By.xpath("//iframe[@class='css-acpm4k']")));
		threadsleep(1000);
		
		//PROCEED TO LOGIN
		click(driver.findElement(By.xpath("(//button[@class='css-guysem e8tshxd0'])[2]")));
		
		//LOGIN
		click(driver.findElement(By.xpath("//button[@class='css-v61n2j e8tshxd0']")));
		click(driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number or Email']")));
		
		//ENTER MAIL-ID
		threadsleep(2000);
		sendkeys(driver.findElement(By.xpath("//input[@name='emailMobile']")),"suganyaj09@gmail.com");
		click(driver.findElement(By.xpath("//div[@class='button-separator']")));
		threadsleep(2000);
		
		//PASSWORD
		sendkeys(driver.findElement(By.xpath("//input[@name='password']")),"SUPERSTAR123!@#");
		threadsleep(1000);
		click(driver.findElement(By.xpath("(//button[@type='button'])[2]")));
		threadsleep(1000);
		click(driver.findElement(By.xpath("//button[@class=\"css-n7wnfc e8tshxd0\"]")));//DELIVERclass="css-n7wnfc e8tshxd0"
		threadsleep(1000);
		click(driver.findElement(By.xpath("//span[@class='css-abbvp6 ehes2bo0']")));
		//COD
		click(driver.findElement(By.xpath("(//div[@class=\"leftSelector css-1xck50t e87w9871\"])[4]")));
		

	}


}
