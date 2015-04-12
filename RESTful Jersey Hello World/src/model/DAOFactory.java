package model;

import java.util.ArrayList;


public class DAOFactory {

	public void insert(DAOTemplate dt) {
		dt.insert();
	}

	public ArrayList getDetails(DAOTemplate dt) {
		return dt.getDetails();
	}

	public void update(DAOTemplate dt, int a) {
		dt.update(a);
	}

	public void delete(DAOTemplate dt) {
		dt.delete();
	}

}
