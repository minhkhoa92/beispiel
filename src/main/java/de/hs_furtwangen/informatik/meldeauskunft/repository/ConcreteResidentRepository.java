package de.hs_furtwangen.informatik.meldeauskunft.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hs_furtwangen.informatik.meldeauskunft.domain.Resident;

public class ConcreteResidentRepository implements ResidentRepository {

	public List<Resident> getResidents() {
		
		long berechnetSekunde = 1000, berechnetStunde, berechnetTag, berechnetMonat, berechnetJahr;
		long jahr, monat, tag;
		berechnetStunde = berechnetSekunde * 3600;
		berechnetTag = berechnetStunde * 24;
		berechnetMonat = berechnetTag * 30;
		berechnetJahr = berechnetMonat * 12;
		List<Resident> demoList = new ArrayList<Resident>();
		jahr = 1940; //Jahr ueber www.duckipedia.de/index.php5?title=Tick,_Trick_und_Track bzw. ueber Rosa
		monat = 1;
		tag = 1;
		demoList.add(new Resident(
				"Tick", 
				"Duck", 
				"Blumenweg 13", 
				"Entenhausen", 
				new Date((jahr-1970)*berechnetJahr+monat*berechnetMonat+tag*berechnetTag) //von 1970 hochgerechnet
		));
		demoList.add(new Resident(
				"Trick", 
				"Duck", 
				"Blumenweg 13", 
				"Entenhausen", 
				new Date((jahr-1970)*berechnetJahr+monat*berechnetMonat+tag*berechnetTag) //von 1970 hochgerechnet
		));
		demoList.add(new Resident(
				"Track", 
				"Duck", 
				"Blumenweg 13", 
				"Entenhausen", 
				new Date((jahr-1970)*berechnetJahr+monat*berechnetMonat+tag*berechnetTag) //von 1970 hochgerechnet
		));
		jahr = 1960;
		monat = 2;
		tag = 3;
		demoList.add(new Resident(
				"Canyon", 
				"Wanderer", 
				"Wo der Wind durchweht 4", 
				"Landschaft", 
				new Date((jahr-1970)*berechnetJahr+monat*berechnetMonat+tag*berechnetTag) //von 1970 hochgerechnet
		));
		jahr = 2011;
		monat = 4;
		tag = 4;
		demoList.add(new Resident(
				"Jens", 
				"Fisch", 
				"Im Stein 9999", 
				"Im Flussbett", 
				new Date((jahr-1970)*berechnetJahr+monat*berechnetMonat+tag*berechnetTag) //von 1970 hochgerechnet
		));
		return demoList;
	}

}
