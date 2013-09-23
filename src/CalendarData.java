import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = String.format("insert into events (`name`,`location`,`desc`,`month`,`day`,`year`,`hour`,`minute`,`duration`) values(%s, %s, %s, %d, %d, %d, %d, %d, %f);", e.GetName(), e.GetLocation(), e.GetDesc(), e.GetMonth(), e.GetDay(), e.GetYear(), e.GetTimeHour(), e.GetTimeMinute(), e.GetDuration());
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		}
		catch(SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}
}
