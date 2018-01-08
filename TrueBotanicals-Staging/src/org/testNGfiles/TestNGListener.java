package org.testNGfiles;

/**
 * @author Ankush
 *
 */


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test case started, Name : " + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test case succeeded, Name : " + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test case Failed, Name : " + result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test case Skipped, Name : " + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext result) {
		
		System.out.println("Test case entry, Name : " + result.getName());
		
	}

	@Override
	public void onFinish(ITestContext result) {
		
		System.out.println("Test case exit, Name : " + result.getName());
		
	}

}
