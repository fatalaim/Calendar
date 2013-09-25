import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener{
	
	private int num;
	private CalendarData data = new CalendarData();
	private CalendarGUI gui;
	private CalendarAddGUI addGui;
	
	public Listener(int button, CalendarGUI GUI)
	{
		num = button;
		gui = GUI;
	}
	
	public Listener(int button, CalendarAddGUI GUI)
	{
		num = button;
		addGui = GUI;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch(num)
		{
			case 1: //add
				new CalendarAddGUI();
				break;
			case 2: //edit
				break;
			case 3: //delete
				break;
			case 4: //prev
				break;
			case 5: //next
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
		}
	}

}
