package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class ChangeColorCard extends EffectCard {

	public ChangeColorCard() {
		super(null, CardSymbol.CHANGE_COLOR);
	}

	@Override
	public String performEffect() {
		if (GameLogic.getInstance().getCurrentPlayerHand().isEmpty()) {
			this.setColor(CardColor.RED);
			return "Set color to RED";
		}
		if (GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor() == null) {
			this.setColor(CardColor.RED);
			return "Set color to RED";
		}
		this.setColor(GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor());
		return "Set color to " + GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor().toString(); 
		
	}

	@Override
	public String toString() {
		if (this.getColor() == null) {
			return "CHANGE COLOR";
		}
			return "CHANGE COLOR (" + this.getColor() + " color selected)";
		}

	@Override
	public boolean canPlay() {
		return true;
	}
	
	

}
