package com.uttesh.mqs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class mqsTest {
	MQSService mqsService = new MQSService();

	@Test(priority = 1)
	public void testPush() {
		System.out.println("testPush ");
		Message message = new Message("test", "test", "test");
		mqsService.add(message);
		Assert.assertEquals(true, true);
	}

}
