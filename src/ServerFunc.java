import java.io.Console;
import java.rmi.RemoteException;
        import java.util.Arrays;


public class ServerFunc implements IGame {
    int[][] pole = new int[12][12];
    int hod = 1;
    int userNember = 0;
    @Override
    public int[][]  multiply(int x, int y) throws RemoteException {
        pole[10][1] = 1;
        pole[1][10] = 2;
        if (hod <= 3) {
           boolean isFirstHod = pole[10][2] == 0 && pole[9][1] == 0 && pole[9][2] == 0;
           if (isFirstHod) {
               hod++;
           }
            boolean isFirstCorrect = pole[x][y - 1] == 1 || pole[x][y + 1] == 1 || pole[x + 1][y] == 1 ||
                    pole[x - 1][y] == 1 || pole[x + 1][y + 1] == 1 || pole[x + 1][y - 1] == 1 ||
                    pole[x - 1][y + 1] == 1 || pole[x - 1][y - 1] == 1 ||
                    pole[x][y - 1] == 4 || pole[x][y + 1] == 4 || pole[x + 1][y] == 4 ||
                    pole[x - 1][y] == 4 || pole[x + 1][y + 1] == 4 || pole[x + 1][y - 1] == 4 ||
                    pole[x - 1][y + 1] == 4 || pole[x - 1][y - 1] == 4;
            if (isFirstCorrect) {
                    if ( pole[x][y] == 2) {
                        pole[x][y] = 4;
                        hod++;
                        return pole;
                    }
                    pole[x][y] = 1;
                    hod++;
                    return pole;
            }
        } else {
            boolean isFirstHod = pole[1][9] == 0 && pole[2][9] == 0 && pole[2][10] == 0;
            if (isFirstHod) {
                hod++;
            }
            boolean isSecondCorrect = pole[x][y - 1] == 2 || pole[x][y + 1] == 2 || pole[x + 1][y] == 2 ||
                    pole[x - 1][y] == 2 || pole[x + 1][y + 1] == 2 || pole[x + 1][y - 1] == 2 ||
                    pole[x - 1][y + 1] == 2 || pole[x - 1][y - 1] == 2 ||
                    pole[x][y - 1] == 3 || pole[x][y + 1] == 3 || pole[x + 1][y] == 3 ||
                    pole[x - 1][y] == 3 || pole[x + 1][y + 1] == 3 || pole[x + 1][y - 1] == 3 ||
                    pole[x - 1][y + 1] == 3 || pole[x - 1][y - 1] == 3;
            if (isSecondCorrect) {
                if (pole[x][y] == 1) {
                    pole[x][y] = 3;
                    if (hod == 6){
                        hod = 1;
                    } else {
                        hod++;
                    }
                    return pole;
                }
                pole[x][y] = 2;
                if (hod == 6){
                    hod = 1;
                } else {
                    hod++;
                }
                return pole;
            }
        }
            return pole;
    }
    public int[][]  getPole() throws RemoteException {
        pole[10][1] = 1;
        pole[1][10] = 2;
        return pole;
    }
    public int gethode() throws RemoteException {
        return hod;
    }
    public int getUserNumber() throws RemoteException {
        userNember++;
        if (userNember == 1) {
            return userNember;
        }
        return userNember;
    }
}
