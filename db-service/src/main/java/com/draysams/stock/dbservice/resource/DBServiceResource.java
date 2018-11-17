package com.draysams.stock.dbservice.resource;

import com.draysams.stock.dbservice.model.Quote;
import com.draysams.stock.dbservice.model.Quotes;
import com.draysams.stock.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username) {
        return getQuotesByUserName(username);
    }

    @PostMapping("/addquote")
    public List<String> addQuote(@RequestBody final Quotes quotes) {
        quotes.getQuotes()
                .stream()
                .map(quote -> new Quote(quotes.getUserName(), quote))
                .forEach(quote -> quotesRepository.save(quote));


        return getQuotesByUserName(quotes.getUserName());
    }

    @PostMapping("/delete/{username}")
    public List<String> deletePost(@PathVariable("username") final String usernname) {
        Quote quote = quotesRepository.findQuoteByUsername(usernname);

        quotesRepository.delete(quote);

        return getQuotesByUserName(usernname);
    }

    private List<String> getQuotesByUserName(@PathVariable("username") String username) {
        return quotesRepository.findAllByUsername(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }
}
