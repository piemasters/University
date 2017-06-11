package year2.CSP.Week4;

class MyThread extends Thread { 
    
  private String threadID;  
  
  MyThread(String s) { 
      threadID=s; 
  } 
  
  public void run() {
      
    for (int i=0;i<200;i++){
      System.out.println("Thread " + threadID);
    }//for
  }//run    
} //MyThread
