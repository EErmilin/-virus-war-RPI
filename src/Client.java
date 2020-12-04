import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

	public static final String UNIQUE_BINDING_NAME = "server";

	public static void main(String[] args) throws RemoteException, NotBoundException {

        final Registry registry = LocateRegistry.getRegistry(2732);
        Scanner scan = new Scanner(System.in);
        IGame game = (IGame) registry.lookup(UNIQUE_BINDING_NAME);
        int[][] pole = game.getPole();
        int hod;
        int id = game.getUserNumber();
        System.out.println("ID of player: " + id);
        if (id == 2) {
            for (int i = 1; i < pole.length - 1; i++) {
                for (int j = 1; j < pole[i].length - 1; j++) {
                    System.out.print(pole[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
while (true) {
    hod = game.gethode();
    if (id == 1 && hod < 3) {
        hod = game.gethode();
        pole = game.getPole();
        for (int i = 1; i < pole.length - 1; i++) {
            for (int j = 1; j < pole[i].length - 1; j++) {
                System.out.print(pole[i][j] + "\t");
            }
            System.out.println();
        }
        while (hod != 4) {
            System.out.println("First player");
            int y = scan.nextInt();
            int x = scan.nextInt();
            game.multiply(x, y);
            hod = game.gethode();
            pole = game.getPole();
            for (int i = 1; i < pole.length - 1; i++) {
                for (int j = 1; j < pole[i].length - 1; j++) {
                    System.out.print(pole[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    } else if (id == 2 && hod > 3) {
        hod = game.gethode();
        pole = game.getPole();
        for (int i = 1; i < pole.length - 1; i++) {
            for (int j = 1; j < pole[i].length - 1; j++) {
                System.out.print(pole[i][j] + "\t");
            }
            System.out.println();
        }
        while (hod != 1) {
            System.out.println("Second player");
            int y = scan.nextInt();
            int x = scan.nextInt();
            game.multiply(x, y);
            hod = game.gethode();
            pole = game.getPole();
            for (int i = 1; i < pole.length - 1; i++) {
                for (int j = 1; j < pole[i].length - 1; j++) {
                    System.out.print(pole[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
	}
}