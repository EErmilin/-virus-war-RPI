import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGame extends Remote {

    int[][]  multiply(int x, int y) throws RemoteException;
    int[][]  getPole() throws RemoteException;
    int gethode() throws RemoteException;
    int getUserNumber() throws RemoteException;
}
