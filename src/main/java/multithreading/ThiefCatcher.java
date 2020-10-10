package multithreading;

import java.util.Random;

public class ThiefCatcher {

	static int MAX = 100099900;
	public static void main(String[] args) {

		Vault vault = new Vault();
		vault.setPassword(new Random().nextInt(ThiefCatcher.MAX));
		System.out.println("Password set is : " + vault.getPassword());

		Thread policeThread = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					System.out.println("Game starts now.." + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				System.out.println("#######   Game over....####");
				System.exit(0);

			}
		});
		
		CatcherThreadOne ascendingThief = new CatcherThreadOne(vault);
		CatcherThreadTwo descendingThief = new CatcherThreadTwo(vault);

		// start all threads
		ascendingThief.start();
		descendingThief.start();
		policeThread.start();

	}

	static class Vault {

		private int password;

		/*private boolean isCorrect(int pwd) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return this.password == pwd;
		}*/

		public int getPassword() {
			return password;
		}

		public void setPassword(int password) {
			this.password = password;
		}

	}

	private static class CatcherThreadOne extends Thread{
		
		Vault vault ;
		public CatcherThreadOne(Vault vault) {
			this.vault= vault;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < ThiefCatcher.MAX; i++) {
				if (vault.getPassword()==i) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Cracked password by ascending thread..");
					System.exit(0);
				}
			}

		}
	}
	
private static class CatcherThreadTwo extends Thread{
		
		Vault vault ;
		public CatcherThreadTwo(Vault vault) {
			this.vault= vault;
		}
		
		@Override
		public void run() {
			for (int i = ThiefCatcher.MAX; i > 0; i--) {
				if (vault.getPassword()==i) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Cracked password by descending thread..");
					System.exit(0);
				}
			}

		}
	}
}


