package de.hs_furtwangen;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	/**
	 * Testen der Methode Enqueue
	 */
	@Test
	public void testEnqueue() {
		Queue testQueue = new Queue(3);
		int eingabe = 2;
		testQueue.enqueue(eingabe);
		assertEquals(eingabe, testQueue.queue[0]);
	}
	
	/**
	 * Hier wird das schreiben mit enqueue getestet, 
	 * wenn die Queue bereits voll ist.
	 * Math.random wird fuer beliebige Werte genommen.
	 * Bis auf die Addition ergeben sich die Konstanten 
	 * aus der Groesse des Feldes. 
	 */
	@Test
	public void testEnqueueViel() {
		Queue testQueue = new Queue(3);
		testQueue.enqueue((int)(Math.round(Math.random())));
		testQueue.enqueue((int)(Math.round(Math.random())));
		testQueue.enqueue((int)(Math.round(Math.random())));
		int eingabe = testQueue.queue[2] + 3;
		
		testQueue.enqueue(eingabe);
		assertEquals(eingabe, testQueue.queue[2]);
	}

	
	/**
	 * Dequeue entnimmt der Liste Eintraege. Dabei wird der zyklische Charakter beachtet.
	 * An dieser Stelle allerdings wird der zyklische Charakter nicht getestet.
	 * Stattdessen werden die ersten zwei Eingaben in der Reihenfolge wieder ausgelesen,
	 * wie sie eingefuegt wurden, weil der erste am laengesten in der Warteschlange ist.
	 */
	@Test
	public void testDequeue() {
		Queue testQueue = new Queue(3);
		int eingabe01 = 2;
		int eingabe02 = 3;
		testQueue.enqueue(eingabe01);
		testQueue.enqueue(eingabe02);
		testQueue.enqueue((int)(Math.round(Math.random())));
		assertEquals(eingabe01, testQueue.dequeue());
		assertEquals(eingabe02, testQueue.dequeue());
		
	}
	
	/**
	 * Es wird der zyklische Charakter von Dequeue ueberprueft.
	 * Durch die Anzahl 3, muss nach dem dritten einfuegen etwas geloescht werden,
	 * damit wieder Platz frei wird. Per Test vom zyklischen Charakter von Enqueue wissen wir,
	 * dass dieser wieder vom Index 0 anfaengt einzuschreiben.
	 * Somit wissen wir, wenn enqueue nach lesen von Index 2 Index 0 liest, dann ist der
	 * zyklische Charakter bestaetigt. 
	 */
	
	@Test
	public void testDequeueCyclic() {
		Queue testQueue = new Queue(3);
		int eingabe01 = 2;
		int eingabe02 = 3;
		testQueue.enqueue((int)(Math.round(Math.random())));
		testQueue.enqueue((int)(Math.round(Math.random())));
		testQueue.enqueue(eingabe01);
		testQueue.dequeue();
		testQueue.dequeue();
		testQueue.enqueue(eingabe02);
		assertEquals(eingabe01, testQueue.dequeue());
		assertEquals(eingabe02, testQueue.dequeue());
	}
	
	/**
	 * Die leere Queue wirft eine Exception. Man kann die Exception genau
	 * definieren und testen, ob diese geworfen wird. Bin 
	 * gerade nicht mit offenem Fenster fuer den Quellcode unterwegs.
	 * Deshalb bleibt die Exception hier allgemein gehalten. 
	 * Umso eher teste ich, dass die Bedingung "Queue ist leer" erfuellt ist.
	 * Z.B. bei der Initialisierung ist dies der Fall und das wird in 
	 * diesem Test verwendet.
	 * @throws Exception
	 */
	@Test(expected=Exception.class)
	public void testDequeueException() throws Exception {
		new Queue(3).dequeue();
	}
	
}
