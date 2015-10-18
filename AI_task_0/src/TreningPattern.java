import java.util.ArrayList;

public class TreningPattern {
	
	ArrayList<Double> inputList = new ArrayList<Double>();
	double output = 0;
	
	public TreningPattern() {
	}
	
	public TreningPattern(ArrayList<Double> inputList, double output){
		this.inputList = inputList;
		this.output = output;
	}

	public ArrayList<Double> getInputList() {
		return inputList;
	}

	public void setInputList(ArrayList<Double> inputList) {
		this.inputList = inputList;
	}

	public double getOutput() {
		return output;
	}

	public void setOutput(double output) {
		this.output = output;
	}
	

	
}
