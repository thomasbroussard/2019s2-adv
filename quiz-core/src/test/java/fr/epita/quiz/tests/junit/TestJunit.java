package fr.epita.quiz.tests.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJunit {
	
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println("beforeAll");
	}
	
	@Before
	public void prepareForEach() {
		System.out.println("beforeEach");
	}
	
	@Test
	public void firstSuccessTest() {
		System.out.println("testSucces");
		
	}
	@Test
	public void firstFailTest() {
		System.out.println("testFail");
		Assert.fail();
	}
	@Test
	public void firstErrorTest() {
		System.out.println("testError");
		int zero = 0;
		double other = 1/zero;
	}
	
	@After
	public void tearDownForEach() {
		System.out.println("afterEach");
	}
	
	@AfterClass
	public static void afterAll() {
		System.out.println("afterAll");
	}

}
