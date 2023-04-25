package application;

public class GameCoreWrapper extends Thread{
	private GameCore gameCore;
	
	public GameCoreWrapper(BeatMap beatMap, NoteTiles notetiles) {
		gameCore = new GameCore(beatMap,notetiles);
	}
	
	public void run() {
		gameCore.executeGameCore();
	}
}
