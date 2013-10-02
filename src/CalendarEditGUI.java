import java.awt.*;

import javax.swing.*;

public class CalendarEditGUI extends JFrame{
	
	private CalendarData data;
	private JLabel[] label = new JLabel[9];
	private JTextField[] fields = new JTextField[9];
	private int guid;
	
	public CalendarEditGUI(CalendarData Data, Event event, CalendarEventDisplay display, int day, int month, int year)
	{
		data = Data;
		guid = event.GetGUID();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Change Event");
		this.setSize(250, 250);
		this.setVisible(true);
		this.setLayout(new GridLayout(10,2));
		String[] labels = {"Name:","Day:","Month:","Year:","Location:","Time(hour):","Time(minute):","Duration:","Description:"};
		for(int j = 0; j < 9; j++){
			for(int k = 0; k <2; k++){
				if(k == 0){
					label[j] = new JLabel(labels[j]);
					this.add(label[j]);
				}
				else{
					fields[j] = new JTextField(30);
					switch(j)
					{
					case 0:
						fields[j].setText(event.GetName());
						break;
					case 1:
						fields[j].setText(Integer.toString(event.GetDay()));
						break;
					case 2:
						fields[j].setText(Integer.toString(event.GetMonth()));
						break;
					case 3:
						fields[j].setText(Integer.toString(event.GetYear()));
						break;
					case 4:
						fields[j].setText(event.GetLocation());
						break;
					case 5:
						fields[j].setText(Integer.toString(event.GetTimeHour()));
						break;
					case 6:
						fields[j].setText(Integer.toString(event.GetTimeMinute()));
						break;
					case 7:
						fields[j].setText(Float.toString(event.GetDuration()));
						break;
					case 8:
						fields[j].setText(event.GetDesc());
						break;
					}
					this.add(fields[j]);
					
				}
			}
		}
		JButton EditEvent = new JButton("Edit");
		JButton DeleteEvent = new JButton("Delete");
		this.add(EditEvent);
		this.add(DeleteEvent);

		Listener edit = new Listener(201,this,data,display,day,month,year);
		Listener delete = new Listener(300,this,data,display, day,month,year);

		EditEvent.addActionListener(edit);
		DeleteEvent.addActionListener(delete);
	}

	public int GetDay()
	{
		return Integer.parseInt(fields[1].getText());
	}
	
	public int GetMonth()
	{
		return Integer.parseInt(fields[2].getText());
	}
	
	public int GetYear()
	{
		return Integer.parseInt(fields[3].getText());
	}
	
	public String GetName()
	{
		return fields[0].getText();
	}
	
	public String GetDesc()
	{
		return fields[8].getText();
	}
	
	public String GetLocation()
	{
		return fields[4].getText();
	}
	
	public int GetTimeMin()
	{
		return Integer.parseInt(fields[6].getText());
	}
	
	public int GetTimeHour()
	{
		return Integer.parseInt(fields[5].getText());
	}
	
	public float GetDuration()
	{
		return Float.parseFloat(fields[7].getText());
	}
	
	public int GetGUID()
	{
		return guid;
	}
}
