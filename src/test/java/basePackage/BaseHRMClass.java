package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHRMClass {
      public static Properties prop=new Properties();
	public static WebDriver driver;
	//Step1
	public BaseHRMClass() {
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\alvin\\eclipse-workspace\\HRManagement\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
		}
	
	catch(FileNotFoundException e) {
	e.printStackTrace();
	}
	catch (IOException a) {
	a.printStackTrace();
	
	}
	}
		//Step2
		public static void initiation() {
		//driver path
		//maximize window, page load,implicit wait, getting URL
		String browsername=prop.getProperty("browser");	
			
		if (browsername.equals("Chrome")) {	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		driver=new ChromeDriver();}
		
		else if (browsername.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver=new FirefoxDriver(options);
        }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		}
		public static void screenshots(String Filename) {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(file, new File("C:\\Users\\alvin\\eclipse-workspace\\HRManagement\\src\\test\\java\\screenshots\\Screenshots"+Filename+".jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}}}
		
		
		
		
		
		
	
			
			
			
			
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	

