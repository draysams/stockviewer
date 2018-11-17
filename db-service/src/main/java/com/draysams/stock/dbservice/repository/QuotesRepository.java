package com.draysams.stock.dbservice.repository;


import com.draysams.stock.dbservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quote, Integer>{
    List<Quote> findAllByUsername(String username);
    Quote findQuoteByUsername(String username);
}
