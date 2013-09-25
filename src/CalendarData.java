import java.sql.*;


public class CalendarData {

	private Connection con;

	public CalendarData()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

		try
		{
			con = DriverManager.getConnection("jdbc:mysql://orion.csl.mtu.edu/jcleveng" ,"jcleveng", "jcDCFwoC0p74w");
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}
	public void Add(Event e)
	{
		String insertSQL = "insert into events (`name`,`location`,`desc`,`month`,`day`,`year`,`hour`,`minute`,`duration`) values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(insertSQL);
			preparedStatement.setString(1, e.GetName());
			preparedStatement.setString(2, e.GetLocation());
			preparedStatement.setString(3, e.GetDesc());
			preparedStatement.setInt(4, e.GetMonth());
			preparedStatement.setInt(5, e.GetDay());
			preparedStatement.setInt(6, e.GetYear());
			preparedStatement.setInt(7, e.GetTimeHour());
			preparedStatement.setInt(8, e.GetTimeMinute());
			preparedStatement.setFloat(9, e.GetDuration());
			preparedStatement.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public int GetCount(int day, int month, int year)
	{
		Statement stmt = null;
		ResultSet rs = null;
		String selectSQL = String.format("select * from events where day = %d and month = %d and year = %d;", day, month, year);
		try
		{
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(selectSQL);
			
			rs.last();
			return rs.getRow();
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return 0;
	}
	
	public Event[] GetEvents(int day, int month, int year)
	{
		Statement stmt = null;
		ResultSet rs = null;
		String selectSQL = String.format("select * from events where day = %d and month = %d and year = %d;", day, month, year);
		try
		{
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(selectSQL);
			
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			Event[] e = new Event[count];
			int i = 0;
			while(rs.next())
			{
				e[i] = new Event();
				e[i].SetName(rs.getString(2));
				e[i].SetLocation(rs.getString(3));
				e[i].SetDesc(rs.getString(4));
				e[i].SetDay(rs.getInt(5));
				e[i].SetMonth(rs.getInt(6));
				e[i].SetYear(rs.getInt(7));
				e[i].SetTimeHour(rs.getInt(8));
				e[i].SetTimeMin(rs.getInt(9));
				e[i].SetDuration(rs.getFloat(10));
				i++;
			}
			return e;
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
	}
}

