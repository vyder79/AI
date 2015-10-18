package matt;

import java.util.LinkedList;
import java.util.Random;

public class neuron {

	private LinkedList<Double> wagi = new LinkedList<>();
	private Double sumaWa�ona = 0.0;
	private LinkedList<Double> wejscie = new LinkedList<>();
	private Double wyjscie = 0.0;
	private boolean ready = false;
	private LinkedList<Double> wagiTemp = new LinkedList<>();

	private funkcjaAktywacji foo = new funkcjaAktywacji();

	// Konsturktor domy�lny gotowy(nauczony) neuron b�dzie potrzebowa� do
	// funkcjonowania jedynie wej�cia i funkcji aktywacji.
	public neuron(LinkedList<Double> wejscie, funkcjaAktywacji foo) {
		super();
		this.wejscie = wejscie;
		this.foo = foo;
	}

	public neuron() {
	};

	// W�a�ciwy proces dzia�ania neuronu
	public double work() {
		for (int i = 0; i < wejscie.size(); i++) {
			sumaWa�ona += wejscie.get(i) * wagi.get(i);
		}

		wyjscie = foo.fn(sumaWa�ona);
		return wyjscie;
	}

	// Meotda wykorzystywana do obliczenia warto�ci wyj�ciowej w procesie
	// uczenia
	public double work2(LinkedList<Double> wagiTemp) {
		for (int i = 0; i < wejscie.size(); i++) {
			sumaWa�ona += wejscie.get(i) * wagiTemp.get(i);
		}

		wyjscie = foo.fn(sumaWa�ona);
		return wyjscie;
	}

	// Metoda wst�pnej propagacji b�edu potrzebna do ustalenia wag w procesie
	// nauczania neuronu
	/*
	 * LinkedList<Double> wejsce -> wektor wej�ciowy double wyjscie -> wyjscie z
	 * neuronu double epsilon -> ma�a dodatnia liczba rzeczywista
	 */
	public LinkedList<Double> backwardErrorPropagation(LinkedList<Double> wejscie, double wyjscie, double epsilon) {

		// wyczyszczenie wag neuronu
		wagi.clear();

		// wyjscie z neuronu przy losowo ustalonych wagach
		double z = work2(wagiTemp);

		// wyliczenie warto�ci ka�dej z wag zgodnie z regu�� delta
		for (int i = 0; i < wagiTemp.size(); i++) {
			double x = wagiTemp.get(i) + (epsilon * (wyjscie - z)) * wejscie.get(i);
			wagi.add(x);
		}
		return wagi;
	}

	// Metoda sprawdzaj�ca czy neuron zosta� wystarczaj�co dobrze nauczony
	// Czyli por�wnanie czy r�znica miedzy wyj�ciem porz�danym a wyj�ciem
	// otrzymanym jest w granicach b�edu
	public boolean test() {
		// TO DO SOMETHING

		return ready;
	}

	// Metoda ucz�ca neuron ustawiaj�ca wagi wykorzystuj�c do tego
	// backwardErrorPropagation()
	// Metoda dzia�a do momentu a� ready nie zmieni si� na true
	public void learn() {
		if (!ready) {
			// TO DO SOMETHING
		}

	}

	// Metoda ustawiaj�ca pocz�tkowe losowe wagi do procesu uczenia
	public LinkedList<Double> setRandomWeight(LinkedList<Double> wejscie) {

		double tempWagi = 0.0;
		double x = 0.0;

		// liczba element�w o jeden mniejsza od liczby element�w wej�ciowych
		int count = wejscie.size() - 1;
		Random r = new Random();

		// // losowe ustawienie wag wszystkich opr�cz jednej
		for (int i = 0; i < count; i++) {
			double temp = r.nextDouble();
			wagi.add(i, temp);
			System.out.println(wagi.get(i));
		}

		// Ustawienie brakuj�cej wagi tak aby warto�� wyj�cia by�a zgodna z
		// oczekiwaniami
		for (int i = 0; i < count; i++) {
			double temp = 0.0;
			tempWagi = +wejscie.get(i) * wagi.get(i);

			x = (1 - tempWagi) / wejscie.getLast();
		}

		wagi.addLast(x);

		return wagiTemp;
	}

	//////////////////////////////////////////
	////// GETTERY I SETTERY///////////////////
	//////////////////////////////////////////
	public LinkedList<Double> getWagi() {
		return wagi;
	}

	public void setWagi(LinkedList<Double> wagi) {
		this.wagi = wagi;
	}

	public Double getSumaWa�ona() {
		return sumaWa�ona;
	}

	public void setSumaWa�ona(Double sumaWa�ona) {
		this.sumaWa�ona = sumaWa�ona;
	}

	public LinkedList<Double> getWejscie() {
		return wejscie;
	}

	public void setWejscie(LinkedList<Double> wejscie) {
		this.wejscie = wejscie;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public funkcjaAktywacji getFoo() {
		return foo;
	}

	public void setFoo(funkcjaAktywacji foo) {
		this.foo = foo;
	}

}
