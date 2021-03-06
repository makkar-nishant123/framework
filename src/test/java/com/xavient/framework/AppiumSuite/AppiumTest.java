package com.xavient.framework.AppiumSuite;

import java.io.IOException;
import java.util.Hashtable;
import com.xavient.framework.util.Constants;
import com.xavient.framework.util.MobileHelper;
import com.xavient.framework.util.TestCaseDataProvider;
import com.xavient.framework.util.Utility;
import com.xavient.framework.util.Xls_Reader;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class AppiumTest {


@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForAppiumSuite")

public void AppiumDemoAndoridTest(Hashtable<String,String> data) throws InterruptedException, IOException
{
	
	Xls_Reader xls = new Xls_Reader(Constants.APPIUMSUITE_XLS_PATH);
	
	String testName="AppiumDemoAndoridTest";
	Logger log=Utility.initLogs(testName,testName+" - "+data.get(Constants.ITERATION_COL));
	log.debug("Executing  "+ testName+" - "+data.toString());
	Utility.validateTestExecution(testName,"AppiumSuite",data.get(Constants.RUNMODE_COL),xls);
	MobileHelper mobile = new MobileHelper();
	mobile.setLogger(log);
	mobile.executeKeywords(testName,xls,data);
	log.debug("Ending "+testName);
	
}



}


