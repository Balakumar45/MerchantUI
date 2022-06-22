package resources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

static ExtentReports extent;

public static ExtentReports getReportObject()

{

Calendar calendar = Calendar.getInstance();

SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");

String path =System.getProperty("user.dir")+"\\reports\\index"+formater.format(calendar.getTime())+".html.html";

ExtentSparkReporter reporter = new ExtentSparkReporter(path);

reporter.config().setReportName("Web Automation Results");

reporter.config().setDocumentTitle("Test Results");

extent =new ExtentReports();

extent.attachReporter(reporter);

extent.setSystemInfo("Tester", "Balakumar");

return extent;

}

}