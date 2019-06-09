package com.qa.hs.keyword.test;

import org.testng.annotations.Test;
import com.qa.hs.keyword.engine.keywordEngine;

public class LoginTest {

	public keywordEngine keyWordEngine;
	
	@Test(priority=1)
	public  void loginTest() 
	{
		keyWordEngine = new keywordEngine();
		keywordEngine.startExecution("login");
	}
//	@Test (priority=2)
//	public void signUpTest(){
//		keyWordEngine = new keywordEngine();
//		keyWordEngine.startExecution("signup");
//	}
}
