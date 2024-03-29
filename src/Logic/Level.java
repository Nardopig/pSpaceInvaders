package Logic;

public enum Level {
EASY(4, 2, 0.2, 3, 0.5, 1),
HARD(8, 4, 0.3, 2, 0.2, 2),
INSANE(12, 4, 0.5, 1, 0.1, 3);
private int numRegularAliens;
private int numDestroyerAliens;
private int numCyclesToMoveOneCell;
private double ovniFrequency;
private double bombFrequency;
private int numRowsOfRegularAliens;
private double turnExplodeFrequency = 0.05; // actualmente no depende del nivel
private Level(
int numRegularAliens,
int numDestroyerAliens,
double bombFrequency,
int numCyclesToMoveOneCell,
double ovniFrequency,
int numRowsOfRegularAliens)
{
this.numRegularAliens = numRegularAliens;
this.numDestroyerAliens = numDestroyerAliens;
this.bombFrequency = bombFrequency;
this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
this.ovniFrequency = ovniFrequency;
this.numRowsOfRegularAliens = numRowsOfRegularAliens;
}
public int getNumRegularAliens() {
return numRegularAliens;
}
public int getNumDestroyerAliens() {
return numDestroyerAliens;
}
public double getBombFrequency() {
return bombFrequency;
}
public int getNumCyclesToMoveOneCell() {
return numCyclesToMoveOneCell;
}
public double getOvniFrequency() {
return ovniFrequency;
}
public int getNumRowsOfRegularAliens() {
return numRowsOfRegularAliens;
}
public int getNumRegularAliensPerRow() {
return numRegularAliens / numRowsOfRegularAliens;
}
public int getNumDestroyerAliensPerRow() {
return getNumDestroyerAliens();
}
public static Level parse(String cadenaEntrada) {
for (Level level : Level.values() )
if (level . name().equalsIgnoreCase(cadenaEntrada))
return level;
return EASY;
}
public double getTurnExplodeFrequency(){
return turnExplodeFrequency;
}
}
