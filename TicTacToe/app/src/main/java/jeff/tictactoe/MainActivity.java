package jeff.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button1,0);
            }
        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button2,1);
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button3,2);
            }
        });

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button4,3);
            }
        });

        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button5,4);
            }
        });

        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button6,5);
            }
        });

        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button7,6);
            }
        });

        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button8,7);
            }
        });

        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeMove(button9,8);
            }
        });

        Button newGameButton = (Button) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });
    }

    public void makeMove(Button button, int pos) {
        // ensure location is currently empty
        if (button.getText().toString().compareTo("") != 0) {
            return;
        }
        // ensure game is not over
        if (gameOver) {
            return;
        }
        if (xTurn) {
            button.setText("X");
            button.setTextSize(20);
            button.setTextColor(Color.RED);
            xTurn = false;
            oTurn = true;
            gameBoard[pos] = 'X';
        }
        else {
            button.setText("O");
            button.setTextSize(20);
            button.setTextColor(Color.BLUE);
            xTurn = true;
            oTurn = false;
            gameBoard[pos] = 'O';
        }
        updateWinners();
    }

    public void newGame() {
        gameBoard = new char[] {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'};
        gameOver = false;
        xWins = false;
        oWins = false;
        xTurn = true;
        oTurn = false;
        updateBottomMsg();
        Button[] buttons = new Button[]{
                (Button) findViewById(R.id.button1),
                (Button) findViewById(R.id.button2),
                (Button) findViewById(R.id.button3),
                (Button) findViewById(R.id.button4),
                (Button) findViewById(R.id.button5),
                (Button) findViewById(R.id.button6),
                (Button) findViewById(R.id.button7),
                (Button) findViewById(R.id.button8),
                (Button) findViewById(R.id.button9)};
        for (int i=0; i<buttons.length; i++) {
            buttons[i].setText("");
        }
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
            if (gameBoard[3] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check row3
        if (gameBoard[6] != 'E' && gameBoard[6] == gameBoard[7] && gameBoard[6] == gameBoard[8]) {
            if (gameBoard[6] == 'X') {
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
            if (gameBoard[1] == 'X') {
                xWins = true;
            }
            else {
                oWins = true;
            }
            gameOver = true;
        }
        // check col3
        if (gameBoard[2] != 'E' && gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8]) {
            if (gameBoard[2] == 'X') {
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
            if (gameBoard[2] == 'X') {
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
