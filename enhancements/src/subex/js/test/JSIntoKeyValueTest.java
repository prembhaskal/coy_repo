package subex.js.test; 

import java.util.Scanner;
import java.io.PrintWriter;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;
import subex.js.*;  

/** 
* JSIntoKeyValue Tester. 
* 
* @author <Premkumar Bhaskal> 
* @since <pre>Jun 11, 2013</pre> 
* @version 1.0 
*/ 
public class JSIntoKeyValueTest { 
    
    JSIntoKeyValue testClass = new JSIntoKeyValue();
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
    * Method: printVarKeyValuePair(String jsFilePath) 
    * 
    */ 
    @Test
    public void testPrintVarKeyValuePair() throws Exception { 
		String jsFilePath = "D:\\project\\RA\\mywork\\WebClient-Localization\\ALL_JS_Files\\English_Original\\ContextDirectoryPropertyDetail.js";
		testClass.printVarKeyValuePair(jsFilePath);

		jsFilePath = "D:\\project\\RA\\mywork\\WebClient-Localization\\ALL_JS_Files\\English_Original\\CommonMessages.js";
		testClass.printVarKeyValuePair(jsFilePath);


    } 
    
        
} 
