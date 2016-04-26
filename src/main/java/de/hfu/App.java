package de.hfu;

import java.io.*;

/**
 * App zum einlesen und umwandeln in Großbuchstaben.
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String eingabe;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println( "Bitte etwas eingeben und mit per Enter-Taste bestaetigen: " );
        eingabe = br.readLine();
        
        System.out.println(eingabe.toUpperCase());
    }
}
