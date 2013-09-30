
public class Event {

	private int day;
	private int month;
	private int year;
	private String location;
	private int hour;
	private int minute;
	private float duration;
	private String desc;
	private String name;
	private int guid;
	
	public void SetDay(int Day)
	{
		day = Day;
	}
	
	public void SetMonth(int Month)
	{
		month = Month;
	}
	
	public void SetYear(int Year)
	{
		year = Year;
	}
	
	public void SetName(String Name)
	{
		name = Name;
	}
	
	public void SetLocation(String Location)
	{
		location = Location;
	}
	
	public void SetTimeHour(int Hour)
	{
		hour = Hour;
	}
	
	public void SetTimeMin(int Min)
	{
		minute = Min;
	}
	
	public void SetDuration(float Duration)
	{
		duration = Duration;
	}
	
	public void SetDesc(String Desc)
	{
		desc = Desc;
	}
	
	public String GetName()
	{
		return name;
	}
	
	public String GetLocation()
	{
		return location;
	}
	
	public String GetDesc()
	{
		return desc;
	}
	
	public int GetDay()
	{
		return day;
	}
	
	public int GetMonth()
	{
		return month;
	}
	
	public int GetYear()
	{
		return year;
	}
	
	public int GetTimeHour()
	{
		return hour;
	}
	
	public int GetTimeMinute()
	{
		return minute;
	}
	
	public float GetDuration()
	{
		return duration;
	}
	
	public int GetGUID()
	{
		return guid;
	}
	
	public void SetGUID(int GUID)
	{
		guid = GUID;
	}
}
