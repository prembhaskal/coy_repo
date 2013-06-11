package subex.excel.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import subex.excel.CreateTestFile;

import java.util.HashMap;
import java.util.Map;

/** 
* CreateTestFile Tester. 
* 
* @author <Premkumar Bhaskal> 
* @since <pre>Jun 7, 2013</pre> 
* @version 1.0 
*/ 
public class CreateTestFileTest { 
    
    CreateTestFile testClass = new CreateTestFile();
    long starttime;
    
    @Before
    public void before() throws Exception {
          starttime = System.nanoTime(); 
    } 
    
    @After
    public void after() throws Exception {
		long now = System.nanoTime();
		System.out.println("elapsed time " + (now-starttime)/1000000 + "milli secs");
    } 
    
        /** 
    * 
    * Method: createSheetWithTestData(String path, Map<String, String> keyValue) 
    * 
    */ 
    @Test
    public void testCreateSheetWithTestData() throws Exception {
		Map<String, String> keyValues = new HashMap<>();
		String path = "D:\\project\\RA\\mywork\\WebClient-Localization\\using_excel\\testFile.xlsx";
		fillValues(keyValues);
		testClass.createSheetWithTestData(path, keyValues);
    }

	private void fillValues(Map<String, String> keyValues) {
		keyValues.put("welcome-msg", "welcome");
		keyValues.put("bye-msg", "bye");
	}
    
        
} 
