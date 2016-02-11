/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosophers;

/**
 *
 * @author Karam Algharabeh
 * // 
 */
public class Forks {
    
   
   private int forks; // Number of forks
   
   private boolean beingused; // It says that its true if fork is being used	
   
   public Forks (int frk) //constructor 
   {
     forks = frk;
   }
      
    public synchronized boolean get (int who) // It turns true if fork has been taken, false if not being used 
    {
     System.out.println(who + (beingused ? " misses " : " grabs ") + forks);
    if(beingused)
        return false;
    if(!beingused)
        return true;
    else 
       return false;    
    }
   
   public synchronized void put (int who)  //drops the fork
   {
     System.out.println(who + " drops " + forks);
     beingused = false;    
   }
   
    
   public synchronized void waitFor (int who)  // waits for the fork to be obtained
   {
     while (!get(who))
	try
        {
	  wait();
        } 
        catch (InterruptedException e) 
        { 
            e.printStackTrace();
        }
    
}
}
