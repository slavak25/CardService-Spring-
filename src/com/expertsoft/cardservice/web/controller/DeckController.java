package com.expertsoft.cardservice.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.expertsoft.cardservice.service.SortingStrategy;
import com.expertsoft.cardservice.web.model.Deck;

@Controller
@RequestMapping("/")
public class DeckController {
	
	private Deck deck;
	Map<Integer, Deck> map = new HashMap<Integer, Deck>();
	
	@Autowired
	public DeckController(Deck deck){
		this.deck = deck;
	}
	
	@Resource(name = "shuffle")	
	SortingStrategy<Deck> shuffle;
	
	@Resource(name = "byValue")	
	SortingStrategy<Deck> byValue;

	@RequestMapping(method = RequestMethod.GET)
	public String home() {		
		return "home";
	}	
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView deck(Deck deck) {			
		map.put(deck.getId(), deck);		
		ModelAndView model = new ModelAndView("decks");
		model.addObject("map", map); 
		return model;
	}	
	
	@RequestMapping(value = "shuffle", method = RequestMethod.GET, params="id")
	public String shuffle() {
		shuffle.doAlgorithm(deck);
		return "shuffledDecks";
	}	
	
	@RequestMapping(value = "sort", method = RequestMethod.GET, params="id")
	public String sort() {
		byValue.doAlgorithm(deck);
		return "sortedDecks";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET, params="id")
	public ModelAndView delete(int id) {
		map.remove(id);
		ModelAndView model = new ModelAndView("decks");
		model.addObject("map", map);
		return model;
	}
	
	@RequestMapping(value = "redirect", method = RequestMethod.GET)
	   public ModelAndView redirect() {	     
		ModelAndView model = new ModelAndView("decks");
		model.addObject("map", map);
		return model;
	}
}
