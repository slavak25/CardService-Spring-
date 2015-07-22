package com.expertsoft.cardservice.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.expertsoft.cardservice.service.SortingStrategy;
import com.expertsoft.cardservice.web.model.Deck;

@RestController
@RequestMapping("/")
public class RestDeckController {		
	private Deck deck;
	List<Deck> list = new ArrayList<Deck>();

	@Autowired
	public RestDeckController(Deck deck) {
		this.deck = deck;
	}
	
	@Resource(name = "shuffle")	
	SortingStrategy<Deck> shuffle;
	
	@Resource(name = "byValue")	
	SortingStrategy<Deck> byValue;
	
	@RequestMapping(value = "jsonCreate", method = RequestMethod.POST)
	public Deck create() {		
		return new Deck();
	}
	
	@RequestMapping(value = "jsonShuffle", method = RequestMethod.PUT, params="id")
	public Deck shuffle() {
		shuffle.doAlgorithm(deck);
		return deck;
	}
	
	@RequestMapping(value = "jsonSort", method = RequestMethod.PUT, params="id")
	public Deck sort() {
		byValue.doAlgorithm(deck);
		return deck;
	}
}

