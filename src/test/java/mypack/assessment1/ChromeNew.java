package mypack.assessment1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChromeNew {
	WebDriver driver;
	@BeforeMethod()
	@Parameters("browser")
	// Test to select Browser
	public void selectBrower(String browser) {
		// if browser is Chrome
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Applications\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        driver = new ChromeDriver(options);
        } else {
            System.out.println("Unsupported browser. Please choose 'chrome' or 'firefox'.");
            System.exit(0);
        }
		driver.get("https://www.coursera.org/");	
	}
	@Test(priority=0)
	// Test to maximize window
	public void maxScreen() {
		driver.manage().window().maximize();
			
	}
	@Test(priority=1)
	public void testSearch() throws InterruptedException {
		driver.manage().window().maximize();
		//Finding search box using xpath
		WebElement ser=driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));
		String xpath= "//input[@placeholder='What do you want to learn?']";
		 String className = ser.getAttribute("class"); 
		//Seraching selenium courses in searchbox
		 System.out.println("Search Box Attributes:");
	     System.out.println("XPath: " + xpath);
	     System.out.println("Class Name: " + className);
        ser.sendKeys("Search for a Course");
		WebElement btn = driver.findElement(By.xpath("//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']"));
		btn.click();        
      
	}
	@Test(priority=2)
	public void testLink() throws InterruptedException {
		driver.manage().window().maximize();
		WebElement loginLink= driver.findElement(By.linkText("Log In"));
		String linkText=loginLink.getText();
		System.out.println("\nLog in Link Attributes:");
		System.out.println("Link Text:"+linkText);
		
	}
	@Test(priority=3)
	public void testLinkAttributes() throws InterruptedException {
		
		
		driver.manage().window().maximize();
		//Finding link using xpath
		WebElement logLink = driver.findElement(By.xpath("//a[normalize-space()='Log In']"));
        logLink.click();
        Thread.sleep(1000);
		
        //finding attributes like id and name for username and password input box after clicking login
        WebElement uname = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement sub = driver.findElement(By.xpath("//button[@type='submit']"));
        
     
        uname.sendKeys("username");
        pass.sendKeys("password");
        
        
        sub.click();
        
		
	}
	@Test
	public static void main(String str[]) throws InterruptedException {
        ChromeNew obj= new ChromeNew();
        obj.selectBrower("chrome");
        obj.maxScreen();
        obj.testSearch();
        obj.testLink();
        obj.testLinkAttributes();
    }
}
