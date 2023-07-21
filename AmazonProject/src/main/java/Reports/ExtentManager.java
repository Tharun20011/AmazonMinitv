package Reports;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.baseTest;


 
public class ExtentManager extends baseTest {
 
    private static ExtentReports extent;
    public static String screenshotName;
    public static String screenShotpath;
    public static ExtentTest logger;
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
    public static ExtentReports createInstance(String fileName) {
    	
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
  
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
         
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Release No", "22");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Build no", "B-12673");
               
        return extent;
    }
 
     
    public static void captureScreenshot() {
         
        TakesScreenshot screenshot = (TakesScreenshot)driver;
           
        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);
 
        try
        {
            Date d = new Date();
            screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";  
            screenShotpath ="C:\\Users\\tharunbalaji.sk\\NewWorkspace\\AmazonProject\\target\\screenshots\\"+screenshotName;
            FileUtils.copyFile(src,new File("C:\\Users\\tharunbalaji.sk\\NewWorkspace\\AmazonProject\\target\\screenshots\\"+screenshotName));
           
       } catch (IOException e) {
           System.out.println("Exception while taking screenshot " + e.getMessage());
      }
    }
    
 public static void logpass(Status status,String details,boolean screenShot) {
        
        if(screenShot==true) {
        	
        try {
        	
 
            ExtentManager.captureScreenshot();
            ExtentListeners.testReport.get().pass("<b>" + "<font color=" + "green>" + details + "</font>" + "</b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenShotpath)
                            .build());
        } catch (Exception e) {
 
        }
        }
        ExtentListeners.testReport.get().log(status,details);
      
        
      
 
    }
 public static void logfail(Status status,String details,boolean screenShot) {
     
     if(screenShot==true) {
     	System.out.println("SS took");
     try {

         ExtentManager.captureScreenshot();
         ExtentListeners.testReport.get().fail("<b>" + "<font color=" + "red>" + details + "</font>" + "</b>",
                 MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenShotpath)
                         .build());
     } catch (Exception e) {

     }
     }
     ExtentListeners.testReport.get().log(status,details);
   
     
   

 }
    
}