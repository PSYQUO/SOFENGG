package test.testModel;

import model.User;
import test.*;
import java.time.*;

public class TestUser extends Test {

	public void test () {
		//check0 ();
		check1();
	}

	private void check0 () {
		TestCase.TestCaseBuilder tcb = new TestCase.TestCaseBuilder ()
			.setTester (TestCase.Tester.JASPER)
			.setSummary ("Bug confirmation test case on creating an object of type User.")
			.setDetails ("User.Role is private and object creation requires User.Role.")
			.setExpected ("Successful creation of a User object.")
			.setInput ("User u = new User (\"Jasper\", \"Jasper\", \"p@ssword\", User.Role.OWNER);")
			.addSteps ("Instantiate a User object with parameters: Jasper, Jasper, p@ssword, User.Role.OWNER")
			.setResult (TestCase.Result.FAILED)
			.setActual ("Failed creation of User object.")
			.setError (TestCase.ResultError.CTE);

		//User u = new User ("Jasper", "Jasper", "p@ssword", User.Role.OWNER);
		try {
			tests.add (tcb.build ());
		} catch (Exception e) {}
	}

	private void check1 ()
	{
		TestCase.TestCaseBuilder tcb = new TestCase.TestCaseBuilder()
			.setTester(TestCase.Tester.STEPHEN)
			.setSummary("Error in creating a User object.")
			.setDetails("Role has private access in User.")
			.setExpected("Proper initialization of User class.")
			.setInput("User u = new User(\"Big Shaq\", \"Ting\", \"HesNotHot\", User.Role.SUPERVISOR);")
			.addSteps("Create new object with given parameters")
			.setResult(TestCase.Result.FAILED)
			.setActual("Failed creation of User")
			.setError(TestCase.ResultError.CTE);

		//User u = new User("Big Shaq", "Ting", "HesNotHot", User.Role.SUPERVISOR);
		try
		{
			tests.add(tcb.build());
		}
		catch(Exception e){}
	}

}
