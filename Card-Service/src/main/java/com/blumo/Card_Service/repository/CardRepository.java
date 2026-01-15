package com.blumo.Card_Service.repository;

import com.blumo.Card_Service.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    List<Card> findByIsActiveTrue();

    List<Card> findByBankNameIgnoreCase(String bankName);

    List<Card> findByNetworkIgnoreCase(String network);
    Optional<Card> findByBankNameIgnoreCaseAndCardNameIgnoreCase(
            String bankName, String cardName
    );

}
