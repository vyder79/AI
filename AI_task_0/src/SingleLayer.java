import java.util.ArrayList;

/**
 * Single layer of neurons
 * 
 * @author vyder
 *
 */
public class SingleLayer {
	
	private ArrayList<Neuron> singleLayer;
	
	private String description;

	public SingleLayer(ArrayList<Neuron> neurons, String description) {
		this.description = description;
		this.singleLayer = neurons;		
	}

	public ArrayList<Neuron> getSingleLayer() {
		return singleLayer;
	}

	public void setSingleLayer(ArrayList<Neuron> singleLayer) {
		this.singleLayer = singleLayer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
