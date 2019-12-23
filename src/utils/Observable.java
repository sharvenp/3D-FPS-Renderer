package utils;

import java.util.ArrayList;

public class Observable {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	public void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.update(this);
		}
	}
}
