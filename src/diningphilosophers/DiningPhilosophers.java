/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphilosophers;

/**
 *
 * @author Algharabeh
 * //kmalgharabeh2016@spartans.manchester.edu
 */
public class DiningPhilosophers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
   Forks f[] = new Forks[5]; // Creates an array of five forks
   
   
   for (int n = 0; n < 5; ++ n)  //Creates instance of Forks for each item in the array 
   {
       f[n] = new Forks(n);
   }
   
   Philosophers p[] = new Philosophers[5]; //Creates an array of five philosphers  
   
   p[0] = new Philosophers(0, f[4], f[0]); //Creates instance of Philosophers
   
   
   for (int n = 1; n < 5; ++ n) //Creates instance of Philosphers for each item in array
   {
       p[n] = new Philosophers(n, f[n-1], f[n]);
   }
   
   
   for (int n = 0; n < 5; ++ n) //Starts thread for each item in the philosopher array
   {
       p[n].start();
   }
 }
    
    }
    

