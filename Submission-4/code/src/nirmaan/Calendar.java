package nirmaan;

import java.util.ArrayList;
import java.util.Date;
import nirmaan.Event;

/**
 *
 * @author sreejith
 */
public class Calendar {
    private ArrayList<Event> finalised;
    
    
    /**
     * @return A sorted and approved list of events
     */
    public ArrayList<Event> ShowCalendar()
    {   Date order[]=new Date[30];
        ArrayList<Event> a =new ArrayList<Event>();
        int i=0;

        finalised=(ArrayList<Event>)Utility.deserialize("Events.ser");

        for (Event e: finalised)
        { 
           order[i++]=e.getStartDate();
        }
       
       
        Date temp=new Date();
               int min= 0;
        for (i=0;i<finalised.size();i++)
        {   min=i;
            for(int j=i;j<finalised.size();j++)
            {
                if(order[j].before(order[min]))
                {
                    min=j;
                }
            }
            temp=order[i];
            order[i]=order[min];
            order[min]=temp;
            
        } 
         
        for(i=0;i<finalised.size();)
        {
            for(Event ab : finalised )
            {
            if(ab.getStartDate().equals(order[i]))
            {
             a.add(ab);
             i++;
            }
            }
        }
        
        finalised=new ArrayList<Event>();
        for(Event ab : a)
        {
            /*System.out.println("Event Name : " + ab.getEvent()+"    StartDate :  "+ab.getStartDate() + " End Date : " + ab.getEndDate());
            System.out.println("........Activities include.........");
            ArrayList<Activity> n = ab.showallactivity();
            for(Activity act : n)
            {
                System.out.println(act.getname() + " " + act.getdate());
            }*/
            if(ab.checkapproval())
                finalised.add(ab);
            
        }
        
        return finalised;
    }
    
    /*public static void main(String args[])
    {   System.out.println("..........................Upcoming Events......................");
        Calendar a= new Calendar();
        a.ShowCalendar();
    }*/

}
