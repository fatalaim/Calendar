import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Listener implements ActionListener{
	
	private int num;
	private CalendarData data;
	private CalendarGUI gui;
	private CalendarAddGUI addGui;
	private JButton dayGui;
	private int month;
	private int year;
	
	public Listener(int button, CalendarGUI GUI, CalendarData Data)
	{
		data = Data;
		num = button;
		gui = GUI;
	}
	
	public Listener(int button, CalendarAddGUI GUI, CalendarData Data)
	{
		data = Data;
		num = button;
		addGui = GUI;
	}
	
	public Listener(int button, JButton day, int Month, int Year, CalendarData Data)
	{
		data = Data;
		num = button;
		dayGui = day;
		month = Month;
		year = Year;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch(num)
		{
			case 1: //add
				new CalendarAddGUI(data);
				break;
			case 2: //edit
				break;
			case 3: //delete
				break;
			case 4: //next
				if(gui.GetMonth() == 11)
				{
					gui.CreateGUI(0, gui.GetYear() + 1);
				}
				else
				{
					gui.CreateGUI(gui.GetMonth() + 1, gui.GetYear());
				}
				break;
			case 5: //prev
				if(gui.GetMonth() == 0)
				{
					gui.CreateGUI(11, gui.GetYear() - 1);
				}
				else
				{
					gui.CreateGUI(gui.GetMonth() - 1, gui.GetYear());
				}
				break;
			case 6: //confirm add
				//DB handling
				Event event = new Event();
				event.SetDay(addGui.GetDay());
				event.SetMonth(addGui.GetMonth());
				event.SetYear(addGui.GetYear());
				event.SetDesc(addGui.GetDesc());
				event.SetDuration(addGui.GetDuration());
				event.SetLocation(addGui.GetLocation());
				event.SetName(addGui.GetName());
				event.SetTimeHour(addGui.GetTimeHour());
				event.SetTimeMin(addGui.GetTimeMin());
				data.Add(event);
				break;
			case 7: //cancel add
				addGui.setVisible(false);
				break;
			case 8: //display events
				if(!dayGui.getText().isEmpty())
					new CalendarEventDisplay(Integer.parseInt(dayGui.getText()), month, year, data);
				break;
		}
	}

}

