package Logic;

import Logic.Objects.*;

public class GameObjectGenerator {
	private static GameObject[] availableGameObjects = {
			new UCMShip(),
			new Ovni(),
			new RegularAlien(),
			new DestroyerAlien(),
			new ExplosiveAlien(),
			new ShockWave(),
			new Bomb(),
			new UCMMissile(),
			new Supermissile()
			};

	public static GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier)
			throws FileContentsException {
		GameObject gameObject = null;
		for (GameObject go : availableGameObjects) {
			gameObject = go.parse(stringFromFile, game, verifier);
			if (gameObject != null)
				break;
		}
		return gameObject;
	}
}
