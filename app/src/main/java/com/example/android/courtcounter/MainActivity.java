package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private TextView scoreViewTeamA;
    private TextView scoreViewTeamB;
    private TextView result;
    private Button btnTeamAaddThree;
    private Button btnTeamAaddTwo;
    private Button btnTeamAaddOne;
    private Button btnTeamBaddThree;
    private Button btnTeamBaddTwo;
    private Button btnTeamBaddOne;
    private Button btnResult;
    private View[] views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        displayForTeamA(0);
        displayForTeamB(0);
    }

    /**
     * Binds the xml UI Views
     */
    private void setViews() {
        scoreViewTeamA = (TextView) findViewById(R.id.team_a_score);
        scoreViewTeamB = findViewById(R.id.team_b_score);
        result = findViewById(R.id.tv_result);
        btnTeamAaddThree = findViewById(R.id.btn_team_a_plus_three);
        btnTeamAaddTwo = findViewById(R.id.btn_team_a_plus_two);
        btnTeamAaddOne = findViewById(R.id.btn_team_a_free_throw);
        btnTeamBaddThree = findViewById(R.id.btn_team_b_plus_three);
        btnTeamBaddTwo = findViewById(R.id.btn_team_b_plus_two);
        btnTeamBaddOne = findViewById(R.id.btn_team_b_free_throw);
        btnResult = findViewById(R.id.btn_result);
        views = new View[]{btnResult, btnTeamAaddThree, btnTeamAaddTwo, btnTeamAaddOne, btnTeamBaddThree, btnTeamBaddTwo, btnTeamBaddOne};
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreViewTeamA.setText(String.valueOf(score));
    }

    /**
     * Increases the current score of team A by 3
     */
    public void teamAaddThree(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increases the current score of team A by 2
     */
    public void teamAaddTwo(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increases the current score of team A by 1
     */
    public void teamAaddOne(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increases the current score of team B by 3
     */
    public void teamBaddThree(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team B
     */
    private void displayForTeamB(int scoreTeamB) {
        scoreViewTeamB.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Increases the current score of team B by 2
     */
    public void teamBaddTwo(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increases the current score of team B by 1
     */
    public void teamBaddOne(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Resets the score to 0 for both team to start it over again
     */
    public void resetScores(View view) {
        result.setVisibility(View.GONE);
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(0);
        displayForTeamB(0);
        activateUserInputs();
    }

    /**
     * Activates, Enables all user input to start the match
     */
    private void activateUserInputs() {
        for (View view : views) {
            view.setEnabled(true);
        }
    }

    /**
     * Fires on click of Result button. Disables other buttons after displaying result.
     */
    public void result(View view) {
        displayResult();
        disableUserInputs(views);
    }

    /**
     * Disables all user input after displaying result until reset
     */
    private void disableUserInputs(View[] views) {
        for (View view : views) {
            view.setEnabled(false);
        }
    }

    /**
     * Displays result
     */
    private void displayResult() {
        result.setVisibility(View.VISIBLE);
        if (scoreTeamA > scoreTeamB) {
            result.setText(getString(R.string.label_win).replace("#", getString(R.string.label_team_a)));
        } else if (scoreTeamB > scoreTeamA) {
            result.setText(getString(R.string.label_win).replace("#", getString(R.string.label_team_b)));
        } else {
            result.setText(getString(R.string.label_tie));
        }
    }
}
