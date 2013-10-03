import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class CalendarEventDisplay extends JFrame{
	
	public CalendarEventDisplay(int day, int month, int year, CalendarData Data)
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Events");
						
		int count = Data.GetCount(day, month + 1, year);
		if(count != 0)
			this.setSize(250, count * 100);
		else
			this.setSize(250,100);
		JPanel eventPanel = new JPanel();
		eventPanel.setLayout(new GridLayout(count, 1));
		JButton[] events = new JButton[count];
		Listener[] edit = new Listener[count];
		Event[] e = Data.GetEvents(day, month + 1, year);
		for(int i = 0; i < count; i++)
		{
			events[i] = new JButton();
			edit[i] = new Listener(200,e[i], Data, this, day, month, year);
			String label;
			if(e[i].GetTimeMinute() != 0)
				label = String.format("<html>%s<br>%s<br>%d:%d<p></html>", e[i].GetName(), e[i].GetLocation(), e[i].GetTimeHour(), e[i].GetTimeMinute());
			else
				label = String.format("<html>%s<br>%s<br>%d:%d0<p></html>", e[i].GetName(), e[i].GetLocation(), e[i].GetTimeHour(), e[i].GetTimeMinute());
			events[i].setText(label);
			events[i].setHorizontalAlignment(SwingConstants.CENTER);
			events[i].addActionListener(edit[i]);
			eventPanel.add(events[i]);
		}
		
		this.add(eventPanel);
		this.setVisible(true);
	}
}
