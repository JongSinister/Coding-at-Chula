package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawTwoCard extends EffectCard {

	public DrawTwoCard(CardColor color) {
		super(color, CardSymbol.DRAW_TWO);
	}

	@Override
	public String performEffect() {
		GameLogic gameInstance = GameLogic.getInstance();
		gameInstance.setDrawAmount(2);
		String massage = "";
		while (true) {
			gameInstance.goToNextPlayer();
			if (!gameInstance.getCurrentPlayerHand().isEmpty()) {
				if (haveDrawCard() != null) {
					BaseCard cardtoplay = haveDrawCard();
					gameInstance.setTopCard(cardtoplay);
					gameInstance.getCurrentPlayerHand().remove(cardtoplay);
					if (cardtoplay.getSymbol().equals(CardSymbol.DRAW_TWO)) {
						gameInstance.incrementDrawAmount(2);
						massage += "Player " + gameInstance.getCurrentPlayer() + " played " + cardtoplay.toString()
								+ ". " + gameInstance.getCurrentPlayerHand().size() + " cards remaining.\n";
					}
					if (cardtoplay.getSymbol().equals(CardSymbol.DRAW_FOUR)) {
						gameInstance.incrementDrawAmount(4);
						massage += "Player " + gameInstance.getCurrentPlayer() + " played " + cardtoplay.toString()
								+ ". " + gameInstance.getCurrentPlayerHand().size() + " cards remaining.\n";
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
							massage += "Set color to "
									+ GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor().toString()
									+ "\n";
						}
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
		return this.getColor().toString() + " " + this.getSymbol().toString();
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

	private BaseCard haveDrawCard() {
		for (BaseCard card : GameLogic.getInstance().getCurrentPlayerHand()) {
			if (card.getSymbol().equals(CardSymbol.DRAW_TWO) || card.getSymbol().equals(CardSymbol.DRAW_FOUR)) {
				return card;
			}
		}
		return null;
	}

}
