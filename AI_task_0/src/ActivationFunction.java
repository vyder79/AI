/**
 * At this moment this is a linear activation function
 * 
 * @author vyder
 *
 */
public class ActivationFunction {
	
	String function = "";
	
	public ActivationFunction(){
		
	}
	
	public ActivationFunction(String _function) {
		this.function = _function;
	}
	
	public double func(double value){
		
		//linear function, returns what gets
		return value;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
}
