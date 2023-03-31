package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;
import logic.game.GameLogic;

//You CAN modify the first line
public class NumberCard extends BaseCard{
	public NumberCard(CardColor color, CardSymbol symbol) {
		super(color, symbol);
	}

	@Override
	public String toString() {
		return getColor().toString()+" "+getSymbol().toString();
	}

	@Override
	public boolean canPlay() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if (topCard.getColor() == null) {
			return true;
		}
		if (topCard.getColor().equals(this.getColor()) || topCard.getSymbol().equals(this.getSymbol())) {
			return true;
		}
		return false;
	}

	@Override
	public String play() {
		GameLogic.getInstance().setTopCard(this);
		GameLogic.getInstance().getCurrentPlayerHand().remove(this);
		return null;
	}



}
