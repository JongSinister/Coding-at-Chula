package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawFourCard extends EffectCard {

	public DrawFourCard() {
		super(null, CardSymbol.DRAW_FOUR);
	}

	@Override
	public String performEffect() {
		String massage = "";
		// set color part
		if (GameLogic.getInstance().getCurrentPlayerHand().isEmpty()
				|| GameLogic.getInstance().getCurrentPlayerHand().get(0) == null) {
			this.setColor(CardColor.RED);
			massage += "Set color to RED\n";
		} else if (GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor() == null) {
			this.setColor(CardColor.RED);
			massage += "Set color to RED\n";
		} else {
			this.setColor(GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor());
			massage += "Set color to " + GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor().toString()
					+ "\n";
		}

		GameLogic gameInstance = GameLogic.getInstance();
		gameInstance.setDrawAmount(4);
		while (true) {
			gameInstance.goToNextPlayer();
			if (!gameInstance.getCurrentPlayerHand().isEmpty()) {
				if (haveDrawFourCard() != null) {
					BaseCard cardtoplay = haveDrawFourCard();
					gameInstance.setTopCard(cardtoplay);
					gameInstance.getCurrentPlayerHand().remove(cardtoplay);
					gameInstance.incrementDrawAmount(4);
					massage += "Player " + gameInstance.getCurrentPlayer() + " played " + cardtoplay.toString() + ". "
							+ gameInstance.getCurrentPlayerHand().size() + " cards remaining.\n";
					// set color massage
					if (GameLogic.getInstance().getCurrentPlayerHand().isEmpty()
							|| GameLogic.getInstance().getCurrentPlayerHand().get(0) == null) {
						this.setColor(CardColor.RED);
						massage += "Set color to RED\n";
					} else if (GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor() == null) {
						this.setColor(CardColor.RED);
						massage += "Set color to RED\n";
					} else {
						this.setColor(GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor());
						massage += "Set color to "
								+ GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor().toString() + "\n";
					}
				} else {
					gameInstance.draw(gameInstance.getDrawAmount());
					massage += "Player " + gameInstance.getCurrentPlayer() + " drew " + gameInstance.getDrawAmount()
							+ " cards. " + gameInstance.getCurrentPlayerHand().size() + " cards remaining.\n";
					gameInstance.setDrawAmount(0);
					break;
				}

				// set draw amount to not more than deck size

				if (gameInstance.getDrawAmount() > gameInstance.getDeck().size()) {
					gameInstance.setDrawAmount(gameInstance.getDeck().size());
				}

			}
		}
		return massage.substring(0, massage.length() - 1);
	}

	@Override
	public String toString() {
		if (this.getColor() == null) {
			return "DRAW FOUR";
		}
		return "DRAW FOUR (" + this.getColor() + " color selected)";
	}

	@Override
	public boolean canPlay() {
		return true;
	}

	private BaseCard haveDrawFourCard() {
		for (BaseCard card : GameLogic.getInstance().getCurrentPlayerHand()) {
			if (card.getSymbol().equals(CardSymbol.DRAW_FOUR)) {
				return card;
			}
		}
		return null;
	}

}
