import java.util.ArrayList;
import java.util.Random;

/**
 * Class to generate and store list of trening patterns.
 * Number of elements in pattern and number of patterns are stored
 * in Constants class.
 * 
 * @author vyder
 *
 */
public class NeuronTrenningList {
	
	/** list of trening patterns */
	ArrayList<TreningPattern> treningList = new ArrayList<TreningPattern>();
	
	/** 
	 * constructor
	 */
	public NeuronTrenningList() {
		for (int i=0; i<Constants.HOW_MANY_TRENING_PATTERNS; i++) {
			this.treningList.add(new TreningPattern(getRandomList(), getRandomDouble()));
		}
		showTreningList();
	}
	
	private double getRandomDouble(){
		Random r = new Random();
		return r.nextDouble();
	}
	
	private ArrayList<Double> getRandomList(){
		ArrayList<Double> al = new ArrayList<>();
		for (int i=0; i<Constants.HOW_MANY_PATTERN_ELEMENTS; i++) {
			al.add(getRandomDouble());
		}
		return al;
	}
	
	/**
	 * print trening list in console
	 */
	public void showTreningList(){
		for (TreningPattern tp : this.treningList) {
			System.out.println(tp.getInputList().toString() + " " + tp.getOutput());
		}
	}

	// getters and setters
	public ArrayList<TreningPattern> getTreningList() {
		return treningList;
	}

	public void setTreningList(ArrayList<TreningPattern> treningList) {
		this.treningList = treningList;
	}

}
