import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CountriesFileApp {

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		
		Path path = Paths.get("countries.txt");
		if (Files.notExists(path)) {
			Files.createFile(path);
		}
		
		boolean valid = true; 
		
		do { 

			System.out.println("Welcome to the Countries Maintenance Application");
			System.out.println("1. See the list of countries");
			System.out.println("2. Add a country");
			System.out.println("3. Exit");

			// could do with with an switch statement


			int userInput = scnr.nextInt();
			scnr.nextLine(); // clearing the scanner

			if (userInput == 1) {
				// See
				List<Country> countries = CountriesFileUtil.readFile();
				for (Country c : countries) {
					System.out.println(c.getName() + " is home to " + c.getPopulation() + " people.");
				}

			} else if (userInput == 2) {
				// Add

				// String name = Validator.getString(scnr, "Enter a country name to add: ");

				System.out.print("Enter a  country name to add: ");
				String name = scnr.nextLine();
				System.out.print("Enter their population: ");
				int population = scnr.nextInt();
				Country newCountry = new Country(name, population);
				CountriesFileUtil.appendToFile(newCountry);

				List<Country> countries = CountriesFileUtil.readFile();
				for (Country c : countries) {
					System.out.println(c.getName() + " is home to " + c.getPopulation() + " people.");
				}

			} else {
				valid = true;

			}

		} while (!valid);
			/*
			 * System.out.print("Enter a  country name to add: "); String name =
			 * scnr.nextLine(); System.out.print("Enter their population: "); int population
			 * = scnr.nextInt(); Country newCountry = new Country(name, population);
			 * CountriesFileUtil.appendToFile(newCountry);
			 */

			/*
			 * List<Country> countries = CountriesFileUtil.readFile(); for (Country c :
			 * countries) { System.out.println(c.getName() + " is home to " +
			 * c.getPopulation() + " people."); }
			 */
		


		System.out.println();
		System.out.println("Have a wonderful vacation!");

		scnr.close();
	}
}