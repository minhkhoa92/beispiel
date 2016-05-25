package de.hs_furtwangen;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;

public class ResidentServiceExceptionTest {

	@Test
	public void testResidentServiceException() {
		String msg = "Das hier ist ein Ausnahmefall!";
		Exception d = new ResidentServiceException(msg);
		assertEquals(msg, d.getMessage());
	}

}
