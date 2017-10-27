package test;

import java.util.*;
import java.io.*;

public abstract class Test {
	
	protected List<TestCase> tests;
	
	public Test () {
		tests = new ArrayList <> ();
	}
	
	public void testAndGenerate (String outputPath) throws FileNotFoundException, UnsupportedEncodingException {
		test ();
		generate (outputPath);
	}
	
	protected abstract void test ();
	
	protected void generate (String path) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter pw = new PrintWriter (new File(path), "UTF-8");
		for (TestCase tc: tests) {
			pw.println ("--------------ERROR REPORT--------------");
			pw.println ("QA REPORT");
			pw.println ();
			pw.println ("Test ID: ");
			pw.println ();
			pw.println ("Date Tested: " + tc.getDate ());
			pw.println ();
			pw.println ("Tested By: " + tc.getTester ());
			pw.println ();
			pw.println ("Test Case Summary: " + tc.getSummary ());
			pw.println ();
			pw.println ("Test Case Details: " + tc.getDetails ());
			pw.println ();
			pw.println ("Steps to reproduce error: ");
			for (String s: tc.getSteps ()) {
				pw.println ("\t" + s);
			}
			pw.println ();
			pw.println ("Expected Output: " + tc.getExpected ());
			pw.println ();
			pw.println ("Actual Output: " + tc.getActual ());
			pw.println ();
			pw.println ("DEV REPORT");
			pw.println ();
			pw.println ("Date Fixed: ");
			pw.println ();
			pw.println ("Fixed By: ");
			pw.println ();
			pw.println ("Dev Comments: ");
			pw.println ();
			pw.println ("QA Confirmation");
			pw.println ();
			pw.println ("Confirmed By: ");
			pw.println ();
			pw.println ("QA Comments: ");
			pw.println ("--------------ERROR SUMMARY--------------");
			pw.println (tc.getDate () + "," + tc.getTester () + "," +
				tc.getInput () + "," + tc.getExpected () + "," + 
				tc.getActual () + "," + tc.getResult ());
			pw.println ("-------------------------------------------------");
		}
		
		pw.close ();
	}
	
}