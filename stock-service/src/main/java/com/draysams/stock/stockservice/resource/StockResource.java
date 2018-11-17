package com.draysams.stock.stockservice.resource;

import com.draysams.stock.stockservice.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/{username}")
    public List<Quote>  getStockQuote(@PathVariable("username") final String userName) {
        ResponseEntity<List<String>> quotesResponse = restTemplate.exchange("http://db-service/rest/db/" + userName, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<String>>() {
                });
        List<String> quotes = quotesResponse.getBody();
        return quotes
                .stream()
                .map(quote -> {
                    Stock stock = getStockPrice(quote);
                    return new Quote(quote, stock.getQuote().getPrice());
                })
                .collect(Collectors.toList());
    }

    public Stock getStockPrice(String quote) {
        try {
            return YahooFinance.get(quote);
        } catch (IOException e) {
            e.printStackTrace();
            return new Stock(quote);
        }
    }
}