package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import letters.Letter;
import entity.City;
import entity.Inhabitant;

/**
 * 
 * @author Place Leclercq
 *
 */
public class Main {
	private static final int CITY_SIZE = 10;
	private static final int CITY_NAME_SIZE = 64;
	private static final String SEPARATOR = "**************************************" ;
	private static Random random;
	
	public static void main(String[] args) {
		int nbDays = (args.length > 0 ? Integer.parseInt(args[0]) : 10);
		int cpt = 1;
		random = new Random();
		
		City city = createCity();
		ArrayList<Inhabitant> inhabitants = createInhabitants(city);
		
		System.out.println("Creating " + city.getName() + " city");
		System.out.println("Creating " + CITY_SIZE + " inhabitants");
		System.out.println("Mailing letters for " + nbDays + " days");
		System.out.println(SEPARATOR);
		
		while(cpt <= nbDays){
			System.out.println("Day " + cpt++);
			
			doOneDay(city, inhabitants, true);
			
			System.out.println(SEPARATOR);
		}
		
		while(stillLetter(inhabitants)){
			System.out.println("Day " + cpt++);
			
			doOneDay(city, inhabitants, false);
			
			System.out.println(SEPARATOR);
		}
	}
	
	/**
	 * Simule une journee pour une ville et des habitants donnes
	 * @param city La ville pour laquelle la journee doit etre simulee.
	 * @param inhabitants Les habitants pour lesquels la journee doit etre simulee.
	 */
	private static void doOneDay(City city, ArrayList<Inhabitant> inhabitants, boolean allowSendLetter){
		Inhabitant sender = null;
		Inhabitant receiver = null;
		Letter<?> tmp = null;
		List<Letter<?>> tmpReceiveLetter = null;
		
		int nbLetterSend = random.nextInt(10);
		
		for (Inhabitant inhabitant : inhabitants) {
			tmpReceiveLetter = inhabitant.getReceiveLetters();
			
			if(!tmpReceiveLetter.isEmpty()){
				for (Letter<?> letter : tmpReceiveLetter) {
					System.out.println("<- " + inhabitant.getName()+" receives the letter "+letter.getId()+" which has the description \""+letter.getDescription()+"\" from "+letter.getSender().getName());
					letter.doAction();
					
				}
				inhabitant.setReceiveLetters(new ArrayList<Letter<?>>());
			}
		}
		
		if(allowSendLetter){
			for (int i = 0; i < nbLetterSend; i++) {
				sender = inhabitants.get(random.nextInt(CITY_SIZE));
				receiver = inhabitants.get(random.nextInt(CITY_SIZE));
				
				if(!sender.equals(receiver)){
					tmp = sender.makeLetter(receiver);
					sender.sendLetter(tmp);
					city.sendLetter(tmp);
					
					System.out.println("-> " + sender.getName()+" mails "+tmp.getDescription()+" to "+receiver.getName()+" for cost of "+tmp.getCost()+" euro(s)");
				}
			}
			
		}
		city.distributeLetters();
	}
	
	/**
	 * Cree une ville avec un nom aleatoire.
	 * @return une ville avec un nom aleatoire.
	 */
	private static City createCity() {
		String cityName = "";
		
		cityName += (char) ('A' + random.nextInt(26));
		
		for(int i = 0; i < CITY_NAME_SIZE - 1; i++) {
			cityName += (char) ('a' + random.nextInt(26));
		}
		
		return new City(cityName);
	}
	
	/**
	 * Cree un tableau compose d'habitants pour la ville passee en parametre.
	 * @param city La ville devant etre peuplee d'habitants.
	 * @return inhabitantList La liste des habitants generes pour la ville.
	 */
	private static ArrayList<Inhabitant> createInhabitants(City city) {
		ArrayList<Inhabitant> inhabitantList = new ArrayList<>(CITY_SIZE);
		
		for (int cpt = 1; cpt <= CITY_SIZE; cpt++) {
			inhabitantList.add(new Inhabitant(city, "inhabitant-" + cpt));
		}
		
		return inhabitantList;
	}
	
	/**
	 * Renvoie un boolean permettant de savoir s'il reste des lettres a distribuer dans la ville.
	 * @return un boolean permettant de savoir s'il reste des lettres a distribuer dans la ville.
	 */
	private static boolean stillLetter(ArrayList<Inhabitant> inhabitants){
		
		for (Inhabitant hab : inhabitants) {
			if(!hab.getReceiveLetters().isEmpty()){
				return true;
			}
		}
		
		return false;
	}
	
}
