package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BusInformationDAO implements DAOTemplate {
	private BusInformation busInformation;

	public BusInformationDAO() {
	}

	public BusInformationDAO(BusInformation busInformation) {

		setBusInformation(busInformation);
	}

	public BusInformation getBusInformation() {
		return busInformation;
	}

	public void setBusInformation(BusInformation busInformation) {
		this.busInformation = busInformation;
	}

	public ArrayList getDetails() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BusInformation> obj = new ArrayList<BusInformation>();
		try {
			con = DBConnect.connect();
			stmt = (Statement) con.createStatement();
			rs = (ResultSet) stmt
					.executeQuery("select b1.Bus_Loc_Longitude,b1.Bus_Loc_Latitude from businformation b1, "
							+ "busroute b2 where b1.BR_Id=b2.BR_Id and b1.BR_Id=2");

			while (rs.next()) {

				BusInformation busInformation = new BusInformation();
				// busInformation.setBusId(rs.getInt("Bus_Id"));
				// busInformation.setDeviceNum(rs.getString("Device_Num"));
				busInformation.setBusLocationLongitude(rs
						.getString("Bus_Loc_Longitude"));
				busInformation.setBusLocationLatitude(rs
						.getString("Bus_Loc_Latitude"));
				// busInformation
				// .setBusLastUpdate(rs.getString("Bus_Last_Update"));
				// busInformation.setBusRouteId(rs.getString("BR_Id"));

				obj.add(busInformation);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				DBConnect.disConnect(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

	public void update(int busId) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		String query = null;
		try {
			con = DBConnect.connect();
			query = "update businformation set Bus_Loc_Longitude=?, Bus_Loc_Latitude=?"
					+ " where Bus_Id=? and BR_ID=?";
			preparedStatement = (PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1, "18.100000");// busInformation.getBusLocationLongitude());
			preparedStatement.setString(2, "18.100000");// busInformation.getBusLocationLatitude());
			preparedStatement.setInt(3, busId);
			preparedStatement.setInt(4, 1); // busInformation.getBusRouteId());

			preparedStatement.executeUpdate();

			System.out.println("Bus Information is updated successfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				DBConnect.disConnect(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}