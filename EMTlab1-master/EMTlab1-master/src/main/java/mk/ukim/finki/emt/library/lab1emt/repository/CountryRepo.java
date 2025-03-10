package mk.ukim.finki.emt.library.lab1emt.repository;

import mk.ukim.finki.emt.library.lab1emt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {};
