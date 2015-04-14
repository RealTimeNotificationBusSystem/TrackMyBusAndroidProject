package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class BusRouteDAO implements DAOTemplate {
	private BusRoute BusRoute;

	public BusRouteDAO() {
	}

	public BusRouteDAO(BusRoute BusRoute) {

		setBusRoute(BusRoute);
	}

	public BusRoute getBusRoute() {
		return BusRoute;
	}

	public void setBusRoute(BusRoute BusRoute) {
		this.BusRoute = BusRoute;
	}

	public ArrayList getDetails() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BusRoute> obj = new ArrayList<BusRoute>();
		try {
			con = DBConnect.connect();
			stmt = (Statement) con.createStatement();
			rs = (ResultSet) stmt.executeQuery("select * from BusRoute");

			while (rs.next()) {

				BusRoute busRoute = new BusRoute();
				busRoute.setBusRouteNum(rs.getString("BR_Num"));
				busRoute.setBusRouteCity(rs.getString("BR_City"));
				busRoute.setBusRouteSource(rs.getString("BR_Source"));
				busRoute.setBusRouteDestination(rs.getString("BR_Destination"));
				busRoute.setBusRouteStatus(rs.getString("BR_Status"));

				obj.add(busRoute);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.disConnect(con);
		}

		return obj;
	}

	public void insert() {

		Connection con = DBConnect.connect();
		try {
			con.setAutoCommit(false);

			// write callable statement to insert data into database
			CallableStatement cs = con.prepareCall("{call BusRouteInsert (?)}");

			// set the values to POJO
			// cs.setString(1,bc.getCASEID());

			try {
				cs.execute();
			} catch (Exception e) {
				System.out.println(e);
			}
			con.commit();
			System.out.println("Data inserted successfully");
		} catch (Exception e) {

			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {

			DBConnect.disConnect(con);
		}
	}

	public void delete() {

	}

	public void update(int a) {

	}

}