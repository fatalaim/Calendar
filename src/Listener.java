import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Listener implements ActionListener{
	
	private int num;
	private CalendarData data;
	private CalendarGUI gui;
	private CalendarAddGUI addGui;
	private CalendarEditGUI editGui;
	private CalendarEventDisplay Display;
	private JButton dayGui;
	private Event event;
	private int day;
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
	
	public Listener(int button, Event _event, CalendarData Data, CalendarEventDisplay display, int Day, int Month, int Year)
	{
		num = button;
		data = Data;
		event = _event;
		Display = display;
		day = Day;
		month = Month;
		year = Year;
	}
	
	public Listener(int button, CalendarEditGUI GUI, CalendarData Data, CalendarEventDisplay display, int Day, int Month, int Year)
	{
		num = button;
		editGui = GUI;
		data = Data;
		Display = display;
		day = Day;
		month = Month;
		year = Year;
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
				new CalendarEditGUI(data, event, Display,day,month,year);
				break;
			case 201: //edit
				Event eventEdit = new Event();
				eventEdit.SetDay(editGui.GetDay());
				eventEdit.SetMonth(editGui.GetMonth());
				eventEdit.SetYear(editGui.GetYear());
				eventEdit.SetDesc(editGui.GetDesc());
				eventEdit.SetDuration(editGui.GetDuration());
				eventEdit.SetLocation(editGui.GetLocation());
				eventEdit.SetName(editGui.GetName());
				eventEdit.SetTimeHour(editGui.GetTimeHour());
				eventEdit.SetTimeMin(editGui.GetTimeMin());
				eventEdit.SetGUID(editGui.GetGUID());
				
				int error = data.ErrorCheck(eventEdit);
				if(error == 1)
				{
					int rs = data.UpdateEvent(eventEdit);
					if(rs == 1)
					{
						editGui.setVisible(false);
						Display.setVisible(false);
						Display = new CalendarEventDisplay(day, month, year, data);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(editGui, "Error in given data.");
				}
				
				break;
			case 300: //delete
				int rsd = data.DeleteEvent(editGui.GetGUID());
				if(rsd == 1)
				{
					editGui.setVisible(false);
					Display.setVisible(false);
					Display = new CalendarEventDisplay(day, month, year, data);
				}
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
				
				int errorAdd = data.ErrorCheck(_event);
				if(errorAdd == 1)
				{
					data.Add(_event);
					addGui.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(addGui, "Error in given data.");
				}
				
				
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

