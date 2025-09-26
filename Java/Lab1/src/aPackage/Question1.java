package aPackage;

interface Playable{
	public static final int MAX_PLAYERS = 4;
	public static final int MIN_PLAYERS = 1;
	void play();
}

class Guitar implements Playable{
	public void play() {
		System.out.println("Playing guitar max players: "+MAX_PLAYERS+ ", min players: "+MIN_PLAYERS);
	}
}
class Football implements Playable{
	public void play() {
		System.out.println("Playing football max players: "+MAX_PLAYERS+ ", min players: "+MIN_PLAYERS);
	}
}
class VideoGame implements Playable{
	public void play() {
		System.out.println("Playing video game  max players: "+MAX_PLAYERS+ ", min players: "+MIN_PLAYERS);
	}
}

public class Question1 {

	public static void main(String[] args) {
		Playable guitar;
		Playable football;
		Playable videogame;
		guitar = new Guitar();
		football = new Football();
		videogame = new VideoGame();
		
		guitar.play();
		football.play();
		videogame.play();
	}

}
