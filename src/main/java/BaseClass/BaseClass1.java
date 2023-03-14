package BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import javax.print.DocFlavor.STRING;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class BaseClass1 {
	public static WebDriver driver;
	public static  void browserLaunch(String browser )
	{if (browser.equalsIgnoreCase("chrome"))

	{System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Chromedriver\\chromedriver.exe");
	driver=new ChromeDriver();
	}

	else if (browser.equalsIgnoreCase("firefox"))

	{System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Geckodriver\\geckodriver.exe");
	driver=new FirefoxDriver();
	}

	else {
		System.out.println("Invalid Driver");
	}
	return;
	}
	public static void maximize()
	{
		driver.manage().window().maximize();
	}
	public static void geturl(String value)
	{
		driver.get(value);


	}
	public static void close() {
		driver.close();

	}
	public static void quit() {
		driver.quit();

	}
	public static void refresh() {
		driver.navigate().refresh();

	}
	public static void navigate(String value) {
		driver.navigate();
	}
	public static void back(String value) {
		driver.navigate().back();

	}
	public static void forward() {
		driver.navigate().forward();

	}

	public static void sendkeys(WebElement element, String value) {
		element.sendKeys(value);
	}
	public static  void click(WebElement element) {
		element.click();


	}
	public  static void iframe(WebElement element) {
		driver.switchTo().frame(element);
	}
	public static void dropdown(String name, WebElement element,String value) 
	{
		Select s=new Select(element);
		if(name.equalsIgnoreCase("text"))

		{s.selectByVisibleText(value);
		}
		else if (name.equalsIgnoreCase("value"))
		{
			s.selectByValue(value);
		}

		else if (name.equalsIgnoreCase("index")) 
		{
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		}
		else if (name.equalsIgnoreCase("deselecttext"))
		{
			s.deselectByVisibleText(value);

		}
		else if (name.equalsIgnoreCase("deselectvalue")) 
		{
			s.deselectByValue(value);

		}
		else if (name.equalsIgnoreCase("deselectindex"))
		{
			int parseInt = Integer.parseInt(value);
			s.deselectByIndex(parseInt);
		}
		else if (name.equalsIgnoreCase("deselectall"))
		{
			s.deselectAll();

		}
		else 
		{
			System.out.println("invalid select");
		}


	}

	public static void singlemultiple() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}		
	public static void multiplewindowhandle(String windowname) {
		Set<String> windowHandles = driver.getWindowHandles();

		for (String string : windowHandles) {
			String title = driver.switchTo().window(string).getTitle();
			if (windowname.equals(title)) {
				break;

			}
		}

	}
	public static void timeout() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	public static void threadsleep(int a)throws InterruptedException {
		Thread.sleep(a);

	}
	public static void screenshot( String name)throws IOException {
		TakesScreenshot s= (TakesScreenshot)driver;
		File src=s.getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\suganya\\Selenium_Project\\ScreenShots\\img1.png");
		FileHandler.copy(src,des);		

	}
	public static void gettext(WebElement element) {

		System.out.println(element.getText());

	}

	public static  boolean elementisdisplay(WebElement element) {

		boolean displayed=true;
		displayed=element.isDisplayed();
		return displayed;

	}

	public static void movetoelement(WebElement element,String name) {

		Actions ac=new Actions(driver);
		if (name.equalsIgnoreCase("click")) {
			ac.click(element).build().perform();
		}else if (name.equalsIgnoreCase("double click")) {
			ac.doubleClick(element).build().perform();
		}else if (name.equalsIgnoreCase("rightclick")) {
			ac.contextClick(element).build().perform();

		}else if (name.equalsIgnoreCase("move")) {
			ac.moveToElement(element).build().perform();

		}else {
			System.out.println("invalid click");
		}


	}

	public static void draganddrop(String name,WebElement source,WebElement dis) {
		Actions ac=new Actions(driver);
		if (name.equalsIgnoreCase("draganddrop")) {
			ac.dragAndDrop(source, dis).build().perform();

		}else if (name.equalsIgnoreCase("clickandhold")) {
			ac.clickAndHold(source).moveToElement(dis).release(dis).build().perform();

		}

	}

	public static void keyboard(String optn) throws AWTException {
		Robot r=new Robot();

		if (optn.equalsIgnoreCase("clickcontrol")) {
			r.keyPress(KeyEvent.VK_CONTROL);

		}else if (optn.equalsIgnoreCase("releasecontrol")) {
			r.keyRelease(KeyEvent.VK_CONTROL);

		}

	}

	public static void alert(String value) {

		Alert alert = driver.switchTo().alert();

		if (value.equalsIgnoreCase("accept")) {
			alert.accept();

		}else if (value.equalsIgnoreCase("Dismiss")) {
			alert.dismiss();

		}else if (value.equalsIgnoreCase("text")) {
			String text = alert.getText();
			System.out.println();

		}else if (value.equalsIgnoreCase("alertsendkeys")) {
			alert.sendKeys(value);
			alert.accept();

		}else {
			System.out.println("invalid selection");
		}

	}

}



