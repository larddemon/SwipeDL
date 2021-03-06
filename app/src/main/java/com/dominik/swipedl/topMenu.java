package com.dominik.swipedl;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TopMenu extends ActionBarActivity implements View.OnClickListener {

    Button start_game_button;
    Button settings_button;
    Button high_scores_button;
    Button how_to_play_button;

    Intent goToGame;
    Intent goToSettings;
    Intent goToHighScores;
    Intent goToInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);

        start_game_button = (Button) findViewById(R.id.start_game_button);
        start_game_button.setOnClickListener(this);

        settings_button = (Button) findViewById(R.id.settings_button);
        settings_button.setOnClickListener(this);

        high_scores_button = (Button) findViewById(R.id.high_scores_button);
        high_scores_button.setOnClickListener(this);

        how_to_play_button = (Button) findViewById(R.id.how_to_play_button);
        how_to_play_button.setOnClickListener(this);

        goToGame = new Intent(this, Game.class);
        goToSettings = new Intent(this, Settings.class);
        goToHighScores = new Intent(this, HighScores.class);
        goToInstructions = new Intent(this, Instructions.class);
    }

    // If a button has been pressed the appropriate method will be called.
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_game_button:
                startGameButtonClicked();
                break;

            case R.id.settings_button:
                settingsButtonClicked();
                break;

            case R.id.high_scores_button:
                highScoresButtonClicked();
                break;

            case R.id.how_to_play_button:
                howToPlayButtonClicked();
                break;
        }
    }

    private void startGameButtonClicked() { startActivity( goToGame ); }
    private void settingsButtonClicked() { startActivity( goToSettings ); }
    private void highScoresButtonClicked() { startActivity( goToHighScores ); }
    private void howToPlayButtonClicked() { startActivity( goToInstructions ); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
