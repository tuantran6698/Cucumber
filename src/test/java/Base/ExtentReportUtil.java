package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;



public class ExtentReportUtil extends BaseUtil {

    String fileName = reportLocation + "extentreport.html";


    public void ExtentReport() {
        //First is to create Extent Reports
        extent = new ExtentReports();

        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);

        extent.attachReporter(spark);

    }

    public void ExtentReportScreenshot() throws IOException {

        File scr = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scr.toPath(), new File(reportLocation + "screenshot.png").toPath());
        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
    }


    public void FlushReport(){
        extent.flush();
    }




}
