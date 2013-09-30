import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Listener implements ActionListener{
	
	private int num;
	private CalendarData data;
	private CalendarGUI gui;
	private CalendarAddGUI addGui;
	private CalendarEditGUI editGui;
	private JButton dayGui;
	private Event event;
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
	
	public Listener(int button, Event _event, CalendarData Data)
	{
		num = button;
		data = Data;
		event = _event;
	}
	
	public Listener(int button, CalendarEditGUI GUI, CalendarData Data)
	{
		num = button;
		editGui = GUI;
		data = Data;
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
			case 100: //add
				new CalendarAddGUI(data);
				break;
			case 200: //change event
				new CalendarEditGUI(data, event);
				break;
			case 201: //edit
				Event eventEdit = new Event();
				eventEdit.SetDay(addGui.GetDay());
				eventEdit.SetMonth(addGui.GetMonth());
				eventEdit.SetYear(addGui.GetYear());
				eventEdit.SetDesc(addGui.GetDesc());
				eventEdit.SetDuration(addGui.GetDuration());
				eventEdit.SetLocation(addGui.GetLocation());
				eventEdit.SetName(addGui.GetName());
				eventEdit.SetTimeHour(addGui.GetTimeHour());
				eventEdit.SetTimeMin(addGui.GetTimeMin());
				eventEdit.SetGUID(editGui.GetGUID());
				data.UpdateEvent(eventEdit);
				break;
			case 300: //delete
				break;
			case 400: //next
				if(gui.GetMonth() == 11)
				{
					gui.CreateGUI(0, gui.GetYear() + 1);
				}
				else
				{
					gui.CreateGUI(gui.GetMonth() + 1, gui.GetYear());
				}
				break;
			case 500: //prev
				if(gui.GetMonth() == 0)
				{
					gui.CreateGUI(11, gui.GetYear() - 1);
				}
				else
				{
					gui.CreateGUI(gui.GetMonth() - 1, gui.GetYear());
				}
				break;
			case 600: //confirm add,
				//DB handling
				Event _event = new Event();
				_event.SetDay(addGui.GetDay());
				_event.SetMonth(addGui.GetMonth());
				_event.SetYear(addGui.GetYear());
				_event.SetDesc(addGui.GetDesc());
				_event.SetDuration(addGui.GetDuration());
				_event.SetLocation(addGui.GetLocation());
				_event.SetName(addGui.GetName());
				_event.SetTimeHour(addGui.GetTimeHour());
				_event.SetTimeMin(addGui.GetTimeMin());
				data.Add(_event);
				break;
			case 700: //cancel add
				addGui.setVisible(false);
				break;
			case 800: //display events
				if(!dayGui.getText().isEmpty())
					new CalendarEventDisplay(Integer.parseInt(dayGui.getText()), month, year, data);
				break;
		}
	}

}

