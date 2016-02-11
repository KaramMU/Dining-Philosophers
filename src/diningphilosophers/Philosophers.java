/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosophers;

/**
 *
 * @author Algharabeh
 */
public class Philosophers extends Thread {
    
   
 private int philospher;  
 
 private Forks left; // left forks
 private Forks right; //right forks
 
  
 public Philosophers (int phil, Forks let, Forks rit) //constructor
 {
   philospher = phil; 
   left = let; 
   right = rit;
 }
 				
 
 public void run ()  // method that causes the philosopher to think and eat 5 times
 { 
    
   for (int n = 1; n <= 5; ++ n) //runs 5 times
   {
     System.out.println(philospher + " thinks");
     
     try  //thread tries to sleep for a random time
     {
	Thread.sleep(1000);
     } 
     catch (InterruptedException e) 
     { 
         e.printStackTrace();
     }
     for (;;)
	try
        {
	  left.waitFor(philospher);
	  if (right.get(philospher)) 
          {
	    System.out.println(philospher + " eats");
	    try 
            {
	      Thread.sleep(1000);
	    } 
            catch (InterruptedException e) 
            { 
                e.printStackTrace(); 
            }
	    right.put(philospher);
	    break;
	  }
	} 
        finally
        {
	  left.put(philospher);			
	}
   }
   System.out.println(philospher + " leaves");
 } 
    
}
