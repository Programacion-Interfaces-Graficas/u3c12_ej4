package u3c11_ej4;
class nuevoHilo implements Runnable {
  public Thread hilo;
  private String nombreHilo;
  public nuevoHilo(String nombreHilo) {
	  this.nombreHilo=nombreHilo;
      hilo=new Thread(this,nombreHilo);
      // Llama al constructor de la clase Thread con el nombre "Nuevo Hilo"
      System.out.println("subproceso:" + hilo);
  }
  public void run() {
      try {
          for(int i = 5; i > 0; i--) {
        	  //El metodo getName obtiene el nombre del hilo
              System.out.println(hilo.getName()+":"+ i);
              Thread.sleep(500);
          }
      } catch (InterruptedException e) {
          System.out.println("nuevoHilo interrupted.");
      }
      System.out.println(hilo.getName()+ " Finalizado");
  }
}
public class ejemplo4 {
	public static void main(String[] args) {
		nuevoHilo nh1=new nuevoHilo("Hilo 1");
		nuevoHilo nh2=new nuevoHilo("Hilo 2");
		nuevoHilo nh3=new nuevoHilo("Hilo 3");
		nh1.hilo.start();
		nh2.hilo.start();
		nh3.hilo.start();
		try {
			 // Espera que los otros hilos terminen
			 Thread.sleep(10000);
		} catch (InterruptedException e) {
			 System.out.println("Hilo Principal Interrupted");
			 }
		System.out.println("Hilo Principal finalizado");
	}
}
