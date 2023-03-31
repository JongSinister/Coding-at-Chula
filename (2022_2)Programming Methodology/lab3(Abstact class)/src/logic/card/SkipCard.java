package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class SkipCard extends EffectCard {

	public SkipCard(CardColor color) {
		super(color, CardSymbol.SKIP);
	}

	@Override
	public String performEffect() {
		while(true) {
			GameLogic.getInstance().goToNextPlayer();
			if (!GameLogic.getInstance().getCurrentPlayerHand().isEmpty()) {
				break;
			}
		}
		return "Skipped player "+GameLogic.getInstance().getCurrentPlayer();
	}

	@Override
	public String toString() {
		return this.getColor().toString()+" "+this.getSymbol().toString();
	}

	@Override
	public boolean canPlay() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if (topCard.getColor() == null) {
			return true;
		}
		if (this.getColor().equals(topCard.getColor()) || topCard.getSymbol().equals(this.getSymbol())) {
			return true;
		}
		return false;
	}
	
	

}
