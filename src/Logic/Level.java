package Logic;

public enum Level {
    EASY(4, 2 , 0.1, 3, 0.5),
    HARD(8, 2 ,0.3 , 2, 0.2),
    INSANE(8 , 4, 0.5, 1, 0.1);
	
	int regularShips;
	int destroyerShips;
	double bombFrequency;
	int speed;
	double ovniFrequency;
	
	private Level(
			int regularShips,
			int destroyerShips,
			double shootFrequency,
			int speed,
			double ovniFrequency
			){
			this.regularShips = regularShips;
			this.destroyerShips = destroyerShips;
			this.bombFrequency = shootFrequency;
			this.speed = speed;
			this.ovniFrequency = ovniFrequency;
	}

	public int getRegularShips() {
		return regularShips;
	}

	public void setRegularShips(int regularShips) {
		this.regularShips = regularShips;
	}

	public int getDestroyerShips() {
		return destroyerShips;
	}

	public void setDestroyerShips(int destroyerShips) {
		this.destroyerShips = destroyerShips;
	}

	public double getBombFrequency() {
		return bombFrequency;
	}

	public void setBombFrequency(double bombFrequency) {
		this.bombFrequency = bombFrequency;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getOvniFrequency() {
		return ovniFrequency;
	}

	public void setOvniFrequency(double ovniFrequency) {
		this.ovniFrequency = ovniFrequency;
	}
	
	
	
	
}
