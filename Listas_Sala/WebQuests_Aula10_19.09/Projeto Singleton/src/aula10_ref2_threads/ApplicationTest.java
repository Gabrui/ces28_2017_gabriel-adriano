package aula10_ref2_threads;

// Atividade: A propósito, como se poderia testar a classe singleton agora?
// SE TESTA CRIANDO THREADS
// RODAR O MAIN.JAVA
public class ApplicationTest implements Runnable {
	
	public void run() {
		Application app1 = Application.getApplication();
		app1.run( );
		Application app2 = Application.getApplication();
		app2.run( );
		if (app1 == app2)
			System.out.println ("Same instance");
		else
			System.out.println ("Different instances");
	}

}
