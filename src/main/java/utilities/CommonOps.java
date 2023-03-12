package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CommonOps extends Base {
    //---------------------------------------------------------------------------
    //Method Name: getData
    //Method Description: This Method gets the data from xml configuration file
    //Method Parameters: String
    //Method Returns: String
    //---------------------------------------------------------------------------
    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
    //---------------------------------------------------------------------------
    //Method Name: initBrowser
    //Method Description: This Method gets the browsers to open in driver
    //Method Parameters: String
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("edge"))
            driver = initEdgeDriver();
        else
            throw new RuntimeException("Invalid platform Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initGrafana();
        action = new Actions(driver);

    }
    //---------------------------------------------------------------------------
    //Method Name: initChromeDriver
    //Method Description: This Method gets the browser Chrome to open up
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    //---------------------------------------------------------------------------
    //Method Name: initFirefoxDriver
    //Method Description: This Method gets the browser FireFox to open up
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    //---------------------------------------------------------------------------
    //Method Name: initEdgeDriver
    //Method Description: This Method gets the browser Edge to open up
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

    //---------------------------------------------------------------------------
    //Method Name: initMobile
    //Method Description: This Method opens up Appium Server to run test on mobile
    //Method Returns: MobileDriver
    //---------------------------------------------------------------------------
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData(".ApiDemos"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Cant connect to appium server, see details: " + e);
            action = new Actions(driver);
        }
        ManagePages.initApiDemos();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
    }

    //---------------------------------------------------------------------------
    //Method Name: initAPI
    //Method Description: This Method opens up URL of API
    //Method Returns: String
    //---------------------------------------------------------------------------
    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("Username"), getData("Password"));
    }

    //---------------------------------------------------------------------------
    //Method Name: initElectron
    //Method Description: This Method gets the Electron to open up and runs tests on Electron based apps
    //Method Parameters: String
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    //---------------------------------------------------------------------------
    //Method Name: initDesktop
    //Method Description: This Method gets the Desktop to open up and runs tests on operating system based apps
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    public static void initDesktop() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")),dc);
        } catch (MalformedURLException e) {
            System.out.println("Can not Connect to Appium Server, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initCalculator();
    }

    //---------------------------------------------------------------------------
    //Method Name: startSession
    //Method Description: This Method starts all platforms to work in xml
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
         platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name");

        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));

    }

    //---------------------------------------------------------------------------
    //Method Name: closeSession
    //Method Description: This Method makes api and mobile to quit after a run
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    @AfterClass
    public void closeSession() {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")){
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    //---------------------------------------------------------------------------
    //Method Name: afterMethod
    //Method Description: This Method makes web and electron to empty List after every Method run
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
       else if (platform.equalsIgnoreCase("electron"))
            ElectronFlows.EmptyList();

    }

    //---------------------------------------------------------------------------
    //Method Name: afterMethod
    //Method Description: This Method starts recording except of api
    //Method Returns: Driver
    //---------------------------------------------------------------------------
    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


