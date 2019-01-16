package jeff.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    char gameBoard[];
    boolean gameOver;
    boolean xWins;
    boolean oWins;
    boolean xTurn;
    boolean oTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = new char[] {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'};
        gameOver = false;
        xWins = false;
        oWins = false;
        xTurn = true;
        oTurn = false;
    }

    protected void updateBottomMsg() {
        TextView bottomMsg = (TextView) findViewById(R.id.bottomMsg);
        if (this.gameOver) {
            if (xWins) {
                bottomMsg.setText(R.string.p1_wins);
            }
            else if (oWins) {
                bottomMsg.setText(R.string.p2_wins);
            }
            else {
                bottomMsg.setText(R.string.tie);
            }
            return;
        }
        if (xTurn) {
            bottomMsg.setText(R.string.p1_s_turn);
        }
        else {
            bottomMsg.setText(R.string.p2_s_turn);
        }
    }

    protected boolean checkIfTie() {
        int numE = 0;
        for (int i=0; i<gameBoard.length; i++) {
            if (gameBoard[i] == 'E') {
                numE++;
            }
        }
        return numE == 9;
    }

    protected void updateWinners() {
        // check if tie
        if (checkIfTie()) {
            updateBottomMsg();
            return;
        }

        // check row1
        if (gameBoard[0] != 'E' && gameBoard[0] == gameBoard[1] && gameBoard[0] == gameBoard[2]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check row2
        if (gameBoard[3] != 'E' && gameBoard[3] == gameBoard[4] && gameBoard[3] == gameBoard[5]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check row3
        if (gameBoard[6] != 'E' && gameBoard[6] == gameBoard[7] && gameBoard[6] == gameBoard[8]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check col1
        if (gameBoard[0] != 'E' && gameBoard[0] == gameBoard[3] && gameBoard[0] == gameBoard[6]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check col2
        if (gameBoard[1] != 'E' && gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check col3
        if (gameBoard[2] != 'E' && gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check diagonal1
        if (gameBoard[0] != 'E' && gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check diagonal 2
        if (gameBoard[2] != 'E' && gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        updateBottomMsg();
    }
}
