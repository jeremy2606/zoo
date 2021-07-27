package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Animal;

public class ModelAnimal extends AbstractTableModel {

	private List<String> animalNameList;

	public ModelAnimal() {
		this.animalNameList = new ArrayList<>();
	}

	public ModelAnimal(List<Animal> animalList) {
		this.animalNameList = new ArrayList<>();
		for (Animal animal : animalList) {
			animalNameList.add(animal.getName());
		}
	}

	public int getColumnCount() {
		return 1;
	}

	public int getRowCount() {
		return this.animalNameList.size();
	}

	public Object getValueAt(int row, int col) {
		return animalNameList.get(row);
	}

	public List<String> getAll(){
		return this.animalNameList;
	}

}
