
package clock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock extends JFrame {

     public Clock () {
     super("My window title");
     
     int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
     int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
     this.setPreferredSize(new Dimension(szer/2,wys/2));  // wymiary
     this.setLocation((szer-(szer/2))/2,(wys-(wys/2))/2); //punkt,wycentrowanie
     this.setDefaultCloseOperation(3);
     this.pack();
     
     initComponents();
     
}
    
    public void initComponents()
    {            
       ActionListener clock = new Clockk();
       Timer clockClock=new Timer(1000,clock);
       clockClock.start();
       panel.add(time);
       panel.add(date);
       this.getContentPane().add(panel);
       pack();
       
       }
    
    private class Clockk implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           time.setText(getMyTime()); 
        }
        
      
    }
    
    public String getMyTime(){
    GregorianCalendar calendar = new GregorianCalendar();
    String hour=""+calendar.get(Calendar.HOUR_OF_DAY);
    String min=""+calendar.get(Calendar.MINUTE);
    String sec=""+calendar.get(Calendar.SECOND);
    
    if(Integer.parseInt(hour)<10)
        hour="0"+hour;
     if(Integer.parseInt(min)<10)
        min="0"+min; 
      if(Integer.parseInt(sec)<10)
        sec="0"+sec;
        return hour+" : "+min+" : "+sec;
    }
       public String getMyDate(){
    GregorianCalendar calendar = new GregorianCalendar();
    String year=""+calendar.get(Calendar.YEAR);
    String month=""+(calendar.get(Calendar.MONTH)+1);
    String day=""+calendar.get(Calendar.DAY_OF_MONTH);
    
    return year+"-"+month+"-"+day;
    }
    
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel label = new JLabel("CurrentTime");
    JLabel time = new JLabel(getMyTime());
    JLabel date = new JLabel(getMyDate());
  
    public static void main(String[] args) {
       new Clock().setVisible(true); 
    }
    
}
