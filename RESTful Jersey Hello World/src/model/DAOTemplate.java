package model;
import java.util.ArrayList;

public interface DAOTemplate {

	public void insert();
	public void delete();
	public void update(int s);
	public ArrayList getDetails();
}
