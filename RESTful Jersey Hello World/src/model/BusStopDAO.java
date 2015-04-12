package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class BusStopDAO implements DAOTemplate {
	private BusStop busStop;

	public BusStopDAO() {
	}

	public BusStopDAO(BusStop busStop) {

		setBusStop(busStop);
	}

	public BusStop getBusStop() {
		return busStop;
	}

	public void setBusStop(BusStop busStop) {
		this.busStop = busStop;
	}

	public ArrayList getDetails() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BusStop> obj = new ArrayList<BusStop>();
		try {
			con = DBConnect.connect();
			stmt = (Statement) con.createStatement();
			rs = (ResultSet) stmt.executeQuery("select * from busstop");

			while (rs.next()) {

				BusStop busStop = new BusStop();
				busStop.setBusStopId(rs.getInt("BS_Id"));
				busStop.setBusName(rs.getString("BS_Name"));
				busStop.setBusLocationLongitude(rs
						.getString("BS_Loc_Longitude"));
				busStop.setBusLocationLatitude(rs.getString("BS_Loc_Latitude"));
				busStop.setBusStatus(rs.getString("BS_Status"));

				obj.add(busStop);
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
			CallableStatement cs = con.prepareCall("{call BusStopInsert (?)}");

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