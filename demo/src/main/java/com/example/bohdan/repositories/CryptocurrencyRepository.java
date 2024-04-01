package com.example.bohdan.repositories;

import com.example.bohdan.entities.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, Long> {
//    List<Cryptocurrency> getAllCryptocurrency();
//    Optional<Cryptocurrency> getCryptocurrencyById(Long id);
    List<Cryptocurrency> getAllByDateTime(LocalDateTime dateTime);
}
