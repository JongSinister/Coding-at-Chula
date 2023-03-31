package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.PlayDirection;

//You CAN modify the first line
public class ReverseCard extends EffectCard{

	public ReverseCard(CardColor color) {
		super(color,CardSymbol.REVERSE);
	}

	@Override
	public String performEffect() {
		GameLogic.getInstance().setPlayDirection(GameLogic.getInstance().getPlayDirection().getOpposite());
		return "Set direction to "+GameLogic.getInstance().getPlayDirection();
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
		if (topCard.getColor().equals(this.getColor()) || topCard.getSymbol().equals(this.getSymbol())) {
			return true;
		}
		return false;
	}
	


}
