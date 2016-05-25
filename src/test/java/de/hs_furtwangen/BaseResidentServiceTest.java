package de.hs_furtwangen;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.Iterator;


import org.junit.Test;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ConcreteResidentRepository;
import de.hs_furtwangen.informatik.meldeauskunft.repository.ResidentRepository;
import de.hs_furtwangen.informatik.meldeauskunft.service.BaseResidentService;
import de.hs_furtwangen.informatik.meldeauskunft.service.ResidentServiceException;

public class BaseResidentServiceTest {

	/**
	 * Die Suche erfasst alle Elemente der Liste. Deshalb
	 * wird nur die Groesse der Ergebnisliste mit der
	 * Groesse der Ursprungsliste verglichen.
	 */
	@Test
	public void testBaseResidentServiceWildcard() {
		int erwarteteSizeListe = 5;
		BaseResidentService brs;
		Resident suchmuster;
		brs = new BaseResidentService();
		brs.setResidentRepository(new ConcreteResidentRepository());
		suchmuster = new Resident();
		suchmuster.setCity("*");
		suchmuster.setFamilyName("*");
		suchmuster.setGivenName("*");
		suchmuster.setStreet("*");
		suchmuster.setCity("*");
		assertEquals(erwarteteSizeListe, brs.getFilteredResidentsList(suchmuster).size());
	}
	
	@Test
	public void testBaseResidentServiceThreeDuck() {
		int erwarteteSizeListe = 3;
		BaseResidentService brs;
		Resident suchmuster;
		brs = new BaseResidentService();
		brs.setResidentRepository(new ConcreteResidentRepository());
		suchmuster = new Resident();
		suchmuster.setFamilyName("Duck");
		assertEquals(erwarteteSizeListe, brs.getFilteredResidentsList(suchmuster).size());
	}
	
	/**
	 * Hier wird die Suchanfrage auf die Ducks noch einmal geschrieben.
	 * Die einzigen Ducks vom Herr Barks in der Liste sind Tick, Trick & Track.
	 */
	@Test
	public void testBaseResidentServiceConcreteSearch() {
		String erwarteteNamen = "TickTrickTrack";
		BaseResidentService brs;
		Resident suchmuster;
		brs = new BaseResidentService();
		brs.setResidentRepository(new ConcreteResidentRepository());
		suchmuster = new Resident();
		suchmuster.setFamilyName("Duck");
		Iterator<Resident> iter = brs.getFilteredResidentsList(suchmuster).iterator();
		while(iter.hasNext()){
			assertTrue(erwarteteNamen.contains(iter.next().getGivenName()));
		}
	}

	/**
	 * Diesmal wird Easymock verwendet.
	 * Hier wird die Suchanfrage auf die Ducks noch einmal geschrieben.
	 * Die einzigen Ducks vom Herr Barks in der Liste sind Tick, Trick & Track.
	 */
	@Test
	public void testBaseResidentServiceEasymock() {
		String suchangabe = "Duck";
		ResidentRepository easymockResidentRepos = createMock(ResidentRepository.class);
		expect(easymockResidentRepos.getResidents())
			.andReturn(new ConcreteResidentRepository().getResidents());
		replay(easymockResidentRepos); //sorgt dafuer, dass die Erwartung unter expect ausgegeben wird.
		String erwarteteNamen = "TickTrickTrack";
		BaseResidentService brs;
		Resident suchmuster;
		brs = new BaseResidentService();
		brs.setResidentRepository(easymockResidentRepos);
		suchmuster = new Resident();
		suchmuster.setFamilyName("Duck");
		Iterator<Resident> iter = brs.getFilteredResidentsList(suchmuster).iterator();
		while(iter.hasNext()){
			assertTrue(erwarteteNamen.contains(iter.next().getGivenName()));
		}
	}
	
	/**
	 * Das ist die erfolgreiche Suche mit getUniqueResident
	 * Das hier ist eine Suche aus der selbsterstellten Liste. Die Liste ist unter
	 * ConcreteResidentRepository zu finden.
	 */
	@Test
	public void testGetUniqueResident() {
		String givenN = "Trick";
		Resident suchmuster = new Resident();
		suchmuster.setGivenName(givenN);
		BaseResidentService brs = new BaseResidentService();
		brs.setResidentRepository(new ConcreteResidentRepository());
		Resident suchergebnis = null;
		try {
			 suchergebnis = brs.getUniqueResident(suchmuster);
		} catch (ResidentServiceException e) {
			e.printStackTrace();
		}
		assertEquals(givenN, suchergebnis.getGivenName());
	}
	/**
	 * Ein Test, der die Fehlermeldung ueberprueft bzw. Test auf Behandlung bei
	 * einer Sucheingabe, die nicht gefunden werden kann.
	 */
	@Test
	public void testGetUniqueResidentSearchpatternNotExisting() {
		String msg = "";
		BaseResidentService brs;
		Resident suchmuster;
		brs = new BaseResidentService();
		brs.setResidentRepository(new ConcreteResidentRepository());
		suchmuster = new Resident();
		suchmuster.setGivenName("aaasas");
		try {
			brs.getUniqueResident(suchmuster);
		} catch (ResidentServiceException r) {
			msg = r.getMessage();
		}
		assertEquals("Suchanfrage lieferte kein eindeutiges Ergebnis!", msg);
	}
	
	/**
	 * Hier kann der Test stehen, dass keine wildcards zugelassen werden.
	 * In dem Fall muss das suchmuster einen Stern als Wert in seinen Attributen enthalten.
	 * 
	 * Es steht nicht hier, denn ich will lieber die Eindeutigkeit des getUniqueResident()
	 * ueberpruefen. Weil es drei Ducks gibt, kommt die Meldung ueber das fehlende, nicht eindeutige Ergebnis
	 * heraus.
	 */
	@Test
	public void testGetUniqueResidentNotUnique() {
		String msg = "";
		BaseResidentService brs;
		Resident suchmuster;
		brs = new BaseResidentService();
		brs.setResidentRepository(new ConcreteResidentRepository());
		suchmuster = new Resident();
		suchmuster.setFamilyName("Duck");
		try {
			brs.getUniqueResident(suchmuster);
		} catch (ResidentServiceException r) {
			msg = r.getMessage();
		}
		assertEquals("Suchanfrage lieferte kein eindeutiges Ergebnis!", msg);
	}
}
