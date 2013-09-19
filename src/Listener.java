import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener{
	
	private int num;
	private CalendarData data = new CalendarData();
	
	public Listener(int button)
	{
		num = button;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch(num)
		{
			case 1:
				new CalendarGUI(1);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
		}
	}

}
