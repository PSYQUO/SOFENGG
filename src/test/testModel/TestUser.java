package test.testModel;

import model.User;
import test.*;
import java.time.*;

public class TestUser extends Test {
	
	public void test () {
		TestCase.TestCaseBuilder tcb = new TestCase.TestCaseBuilder ()
			.setDate (LocalDateTime.now ().toString ().replace ("T", " "))
			.setTester (TestCase.Tester.JASPER)
			.setSummary ("Bug confirmation test case on creating an object of type User.")
			.setDetails ("User.Role is private and object creation requires User.Role.")
			.setExpected ("Successful creation of a User object.")
			.setInput ("User u = new User (\"Jasper\", \"Jasper\", \"p@ssword\", User.Role.OWNER);")
			.addSteps ("Instantiate a User object with parameters: Jasper, Jasper, p@ssword, User.Role.OWNER")
			.setResult (TestCase.Result.FAILED)
			.setActual ("Failed creation of User object.");
			
		//User u = new User ("Jasper", "Jasper", "p@ssword", User.Role.OWNER);
		try {
			tests.add (tcb.build ());
		} catch (Exception e) {}
	}
	
}