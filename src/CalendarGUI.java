import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Calendar;

public class CalendarGUI extends JFrame{

	public CalendarGUI()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Calendar");
		this.setSize(750, 750);
		this.setVisible(true);


		JPanel calendar = new JPanel();
		calendar.setLayout(new GridLayout(6,7));
		JButton[][] days = new JButton[6][7];
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				days[i][j] = new JButton();
				calendar.add(days[i][j]);
			}
		}

		Calendar rightNow = Calendar.getInstance();
		int day = rightNow.get(Calendar.DAY_OF_MONTH);
		int month = rightNow.get(Calendar.MONTH);
		int year = rightNow.get(Calendar.YEAR);
		int dayOfWeek = rightNow.get(Calendar.DAY_OF_WEEK);

		int[] MonthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
		int monthStart = (Math.abs(dayOfWeek - day) % 7);
		int dayNum = 1;
		for(int i = monthStart; i < 6; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				days[i][j].setText(Integer.toString(dayNum));
				dayNum++;
				if(MonthDays[month] == dayNum - 1)
					break;
			}
			if(MonthDays[month] == dayNum - 1)
				break;
		}

		JPanel actions = new JPanel();
		JButton[] buttons = new JButton[7];
		for(int i = 0; i < 7; i++)
		{
			buttons[i] = new JButton();
			actions.add(buttons[i]);
		}
		buttons[0].setText("Prev");
		buttons[2].setText("Add Event");
		buttons[3].setText("Edit Event");
		buttons[4].setText("Delete Event");
		buttons[6].setText("Next");

		JPanel Name = new JPanel();
		JLabel[] monthName = new JLabel[2];
		for(int i = 0; i < 2; i++)
			monthName[i] = new JLabel();
		switch(month)
		{
		case 1:
			monthName[0].setText("January");
			break;
		case 2:
			monthName[0].setText("February");
			break;
		case 3:
			monthName[0].setText("March");
			break;
		case 4:
			monthName[0].setText("April");
			break;
		case 5:
			monthName[0].setText("May");
			break;
		case 6:
			monthName[0].setText("June");
			break;
		case 7:
			monthName[0].setText("July");
			break;
		case 8:
			monthName[0].setText("August");
			break;
		case 9:
			monthName[0].setText("September");
			break;
		case 10:
			monthName[0].setText("October");
			break;
		case 11:
			monthName[0].setText("November");
			break;
		case 12:
			monthName[0].setText("December");
			break;
		}
		monthName[1].setText(Integer.toString(year));
		for(int i = 0; i < 2; i++)
			Name.add(monthName[i]);

		this.add(Name, BorderLayout.NORTH);
		this.add(actions, BorderLayout.SOUTH);
		this.add(calendar, BorderLayout.CENTER);

		Listener add = new Listener(1);
		Listener edit = new Listener(2);
		Listener delete = new Listener(3);
		Listener next = new Listener(4);
		Listener prev = new Listener(5);

		buttons[0].addActionListener(prev);
		buttons[2].addActionListener(add);
		buttons[3].addActionListener(edit);
		buttons[4].addActionListener(delete);
		buttons[6].addActionListener(next);
	}

	public CalendarGUI(int i)
	{
		switch(i)
		{
		case 1:
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setTitle("Add Event");
			this.setSize(250, 250);
			this.setVisible(true);
			this.setLayout(new GridLayout(10,2));
			JComponent[][] inputs = new JComponent[10][2];
			String[] labels = {"Name:","Day:","Month:","Year:","Location:","Time(hour):","Time(minute):","Duration:","Description:"};
			for(int j = 0; j < 9; j++){
				for(int k = 0; k <2; k++){
					if(k == 0){
						inputs[j][k] = new JLabel(labels[j]);
					}
					else{
						inputs[j][k] = new JTextField(30);
					}
					this.add(inputs[j][k]);
				}
			}
			JButton confirmEvent = new JButton("Add");
			JButton cancelEvent = new JButton("Cancel");
			this.add(confirmEvent);
			this.add(cancelEvent);
			
			break;
		}


	}
	public static void main(String[] args) {
		new CalendarGUI();

	}

}
