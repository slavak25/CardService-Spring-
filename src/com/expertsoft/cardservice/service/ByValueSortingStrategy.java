package com.expertsoft.cardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.expertsoft.cardservice.web.model.Deck.Card;
import com.expertsoft.cardservice.web.model.Deck.Suit;
import com.expertsoft.cardservice.web.model.Deck.Value;

@Component("byValue")
public class ByValueSortingStrategy<Deck> implements SortingStrategy<Deck> {	
	
	@Override
	@Autowired
	public void doAlgorithm(Deck deck){
		Card cards[] = ((com.expertsoft.cardservice.web.model.Deck) deck).getCards();
		Suit suits[] = ((com.expertsoft.cardservice.web.model.Deck) deck).getSuits();
		Value values[] = ((com.expertsoft.cardservice.web.model.Deck) deck).getValues();
		int currentCount = ((com.expertsoft.cardservice.web.model.Deck) deck).getCurrentCount();		
		Card bucketCards[][]= new Card[values.length][suits.length];

        for(int i=0;i<currentCount;i++){
            bucketCards[cards[i].getValue().ordinal()][cards[i].getSuit().ordinal()] = cards[i];
        }

        int pointer=0;

        for(int i=0;i<values.length;i++){
            for(int j=0;j<suits.length;j++){
                if(bucketCards[i][j]!=null)
                    cards[pointer++]=bucketCards[i][j];
            }        
        }
	}	
}
