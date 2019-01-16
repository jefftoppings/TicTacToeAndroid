package jeff.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    char gameBoard[];
    boolean winner;
    boolean xWins;
    boolean oWins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = new char[] {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'};
        winner = false;
        xWins = false;
        oWins = false;

    }

    protected void updateWinnerText() {
        TextView bottomMsg = (TextView) findViewById(R.id.bottomMsg);
        if (this.winner) {
            if (xWins) {
                bottomMsg.setText("P1");
            }
        }
    }

    protected void updateWinners() {
        // check row1
        if (gameBoard[0] != 'E' && gameBoard[0] == gameBoard[1] && gameBoard[0] == gameBoard[2]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            winner = true;
        }
        // check row2
        if (gameBoard[3] != 'E' && gameBoard[3] == gameBoard[4] && gameBoard[3] == gameBoard[5]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            winner = true;
        }
        // check row3
        if (gameBoard[6] != 'E' && gameBoard[6] == gameBoard[7] && gameBoard[6] == gameBoard[8]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            winner = true;
        }
        // check col1
        if (gameBoard[0] != 'E' && gameBoard[0] == gameBoard[3] && gameBoard[0] == gameBoard[6]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            winner = true;
        }
        // check col2
        if (gameBoard[1] != 'E' && gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            winner = true;
        }
        // check col3
        if (gameBoard[2] != 'E' && gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            winner = true;
        }
        // check diagonal1
        if (gameBoard[0] != 'E' && gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            winner = true;
        }
        // check diagonal 2
        if (gameBoard[2] != 'E' && gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6]) {
            if (gameBoard[0] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            winner = true;
        }
    }
}
