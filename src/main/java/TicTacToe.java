public class TicTacToe {

    private static Character[][] board = {
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'},
            {'\0', '\0', '\0'}
    };

    public static void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x,y);
    }

    private static void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("axis is outside board");
        }
    }

    private static void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }
}
