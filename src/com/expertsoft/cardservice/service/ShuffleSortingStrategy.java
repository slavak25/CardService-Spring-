package com.expertsoft.cardservice.service;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.expertsoft.cardservice.web.model.Deck.Card;
import com.expertsoft.cardservice.web.model.Deck;

@Component("shuffle")
public class ShuffleSortingStrategy implements SortingStrategy<Deck> {	
	private Card[] cards;

	@Override
	@Autowired
	public void doAlgorithm(Deck deck){		
		cards = ((com.expertsoft.cardservice.web.model.Deck) deck).getCards();
		Random rand= new Random();
		int numberOftime = rand.nextInt(1200);

        for(int i=0;i<numberOftime;i++){
            int m=rand.nextInt(((com.expertsoft.cardservice.web.model.Deck) deck).getCurrentCount());
            int n=rand.nextInt(((com.expertsoft.cardservice.web.model.Deck) deck).getCurrentCount());
            Card temp=cards[m];
            cards[m]=cards[n];
            cards[n]=temp;
        }        
	}	
}
