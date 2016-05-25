package de.hs_furtwangen;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

public class ResidentTest {

	@Test
	public void testResident() {
		assertEquals(Resident.class, new Resident().getClass());
	}

	
	/**
	 * Das ist der Test zu testen des Konsturktors von Resident.
	 * Der Konstruktor setzt die Attribute entsprechend der uebergebenen Parameter.
	 * Um die Werte wieder zu lesen werden die getter verwendet.
	 */
	@Test
	public void testResidentStringStringStringStringDate() {
		Resident toTest;
		String givenN, familyN, stree, cit;
		Date dateBirth;
		givenN = "M";
		familyN = "f";
		stree = "s";
		cit = "c";
		dateBirth = new Date(0L);
		toTest = new Resident(givenN, familyN, stree, cit, dateBirth);
		
		assertEquals(givenN ,toTest.getGivenName());
		assertEquals(familyN ,toTest.getFamilyName());
		assertEquals(stree ,toTest.getStreet());
		assertEquals(cit ,toTest.getCity());
		assertEquals(dateBirth ,toTest.getDateOfBirth());
		
	}

	@Test
	public void testSetGivenName() {
		Resident toTest;
		String givenN, familyN, stree, cit;
		Date dateBirth;
		givenN = "M";
		familyN = "f";
		stree = "s";
		cit = "c";
		dateBirth = new Date(0L);
		toTest = new Resident(givenN, familyN, stree, cit, dateBirth);
		
		toTest.setGivenName("a");
		assertEquals("a", toTest.getGivenName());
	}

	@Test
	public void testSetFamilyName() {
		Resident toTest;
		String givenN, familyN, stree, cit;
		Date dateBirth;
		givenN = "M";
		familyN = "f";
		stree = "s";
		cit = "c";
		dateBirth = new Date(0L);
		toTest = new Resident(givenN, familyN, stree, cit, dateBirth);
		
		toTest.setFamilyName("a");
		assertEquals("a", toTest.getFamilyName());
	}

	@Test
	public void testSetStreet() {
		Resident toTest;
		String givenN, familyN, stree, cit;
		Date dateBirth;
		givenN = "M";
		familyN = "f";
		stree = "s";
		cit = "c";
		dateBirth = new Date(0L);
		toTest = new Resident(givenN, familyN, stree, cit, dateBirth);
		
		toTest.setStreet("a");
		assertEquals("a", toTest.getStreet());
	}

	@Test
	public void testSetCity() {
		Resident toTest;
		String givenN, familyN, stree, cit;
		Date dateBirth;
		givenN = "M";
		familyN = "f";
		stree = "s";
		cit = "c";
		dateBirth = new Date(0L);
		toTest = new Resident(givenN, familyN, stree, cit, dateBirth);
		
		toTest.setCity("a");
		assertEquals("a", toTest.getCity());
	}

	@Test
	public void testSetDateOfBirth() {
		Resident toTest;
		String givenN, familyN, stree, cit;
		Date dateBirth;
		givenN = "M";
		familyN = "f";
		stree = "s";
		cit = "c";
		dateBirth = new Date(0L);
		toTest = new Resident(givenN, familyN, stree, cit, dateBirth);
		
		toTest.setDateOfBirth(new Date(1L));
		assertEquals(new Date(1L), toTest.getDateOfBirth());
	}

}
