package org.sambasoft;

import org.sambasoft.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CountriesApplication implements CommandLineRunner {

	@SuppressWarnings("unused")
	@Autowired
	private CountryRepository countryRepository; // inject/insert data into the country repository

	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// countryRepository.save(new Country("Earth", "World"));
		// countryRepository.save(new Country("China", "Pecking"));
		// countryRepository.save(new Country("Germany", "Berlin"));
		// countryRepository.save(new Country("USA", "Washington DC"));
		// countryRepository.save(new Country("Russia", "Moscow"));
		// countryRepository.save(new Country("Mamibia", "Windhoek"));
		// countryRepository.save(new Country("India", "Windhoek"));
		// countryRepository.save(new Country("North Korea", "Windhoek"));
		// countryRepository.save(new Country("Canda", "Windhoek"));

	}
}
