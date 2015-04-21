package com.dominik.swipedl;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;

public class Settings extends ActionBarActivity implements View.OnClickListener {
    // TODO image and audio

    Intent returnHome;

    private int numPlayers;
    private boolean timeLimit;
    private int gameModeOption;
    private int difficulty;

    Button one_player_button;
    Button two_player_button;
    Button time_limit_button;
    Button drag_limit_button;
    Button game_mode_option_one_button;
    Button game_mode_option_two_button;
    Button game_mode_option_three_button;
    Button easy_button;
    Button medium_button;
    Button hard_button;
    Button save_button;
    Button cancel_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Get current settings values
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        numPlayers = Integer.parseInt(extras.getString("NUM_PLAYERS"));
        timeLimit = Boolean.parseBoolean(extras.getString("TIME_LIMIT"));
        gameModeOption = Integer.parseInt(extras.getString("GAME_MODE_OPTION"));
        difficulty = Integer.parseInt(extras.getString("DIFFICULTY"));

        one_player_button = (Button) findViewById(R.id.OnePlayer);
        one_player_button.setOnClickListener(this);

        two_player_button = (Button) findViewById(R.id.TwoPlayer);
        two_player_button.setOnClickListener(this);

        time_limit_button = (Button) findViewById(R.id.TimeLimit);
        time_limit_button.setOnClickListener(this);

        drag_limit_button = (Button) findViewById(R.id.DragLimit);
        drag_limit_button.setOnClickListener(this);

        game_mode_option_one_button = (Button) findViewById(R.id.GameModeOptionOne);
        game_mode_option_one_button.setOnClickListener(this);

        game_mode_option_two_button = (Button) findViewById(R.id.GameModeOptionTwo);
        game_mode_option_two_button.setOnClickListener(this);

        game_mode_option_three_button = (Button) findViewById(R.id.GameModeOptionThree);
        game_mode_option_three_button.setOnClickListener(this);

        easy_button = (Button) findViewById(R.id.Easy);
        easy_button.setOnClickListener(this);

        medium_button = (Button) findViewById(R.id.Medium);
        medium_button.setOnClickListener(this);

        hard_button = (Button) findViewById(R.id.Hard);
        hard_button.setOnClickListener(this);

        save_button = (Button) findViewById(R.id.Save);
        save_button.setOnClickListener(this);

        cancel_button = (Button) findViewById(R.id.Cancel);
        cancel_button.setOnClickListener(this);

        updateButtonState();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.OnePlayer:
                onePlayerSelected();
                break;

            case R.id.TwoPlayer:
                twoPlayersSelected();
                break;

            case R.id.TimeLimit:
                timeLimitSelected();
                break;

            case R.id.DragLimit:
                dragLimitSelected();
                break;

            case R.id.GameModeOptionOne:
                if (timeLimit) {
                    seconds10Selected();
                } else {
                    drags10Selected();
                }
                break;

            case R.id.GameModeOptionTwo:
                if (timeLimit) {
                    seconds30Selected();
                } else {
                    drags50Selected();
                }
                break;

            case R.id.GameModeOptionThree:
                if (timeLimit) {
                    seconds60Selected();
                } else {
                    drags100Selected();
                }
                break;

            case R.id.Easy:
                easySelected();
                break;

            case R.id.Medium:
                mediumSelected();
                break;

            case R.id.Hard:
                hardSelected();
                break;

            case R.id.Save:
                saveSelected();
                break;

            case R.id.Cancel:
                cancelSelected();
                break;
        }

        updateButtonState();
    }

    // Button selected ? button colour = green : button colour = grey
    private void updateButtonState() {

        Button selectedNumPlayers;
        Button selectedTimeLimit;
        Button selectedGameModeOption;
        Button selectedDifficulty;

        if (numPlayers == 1) {
            selectedNumPlayers= one_player_button;

        } else {
            selectedNumPlayers = two_player_button;
        }

        if (timeLimit) {
            selectedTimeLimit = time_limit_button;
            game_mode_option_one_button.setText(getString(R.string.ten_seconds));
            game_mode_option_two_button.setText(getString(R.string.thirty_seconds));
            game_mode_option_three_button.setText(getString(R.string.sixty_seconds));

        } else {
            selectedTimeLimit = drag_limit_button;
            game_mode_option_one_button.setText(getString(R.string.ten_drags));
            game_mode_option_two_button.setText(getString(R.string.fifty_drags));
            game_mode_option_three_button.setText(getString(R.string.hundred_drags));
        }

        if (gameModeOption == 1) {
            selectedGameModeOption = game_mode_option_one_button;

        } else if (gameModeOption == 2) {
            selectedGameModeOption = game_mode_option_two_button;

        } else {
            selectedGameModeOption = game_mode_option_three_button;
        }

        if (difficulty == 1) {
            selectedDifficulty = easy_button;

        } else if (difficulty == 2) {
            selectedDifficulty = medium_button;

        } else {
            selectedDifficulty = hard_button;
        }

        one_player_button.setBackgroundColor(Color.LTGRAY);
        two_player_button.setBackgroundColor(Color.LTGRAY);
        time_limit_button.setBackgroundColor(Color.LTGRAY);
        drag_limit_button.setBackgroundColor(Color.LTGRAY);
        game_mode_option_one_button.setBackgroundColor(Color.LTGRAY);
        game_mode_option_two_button.setBackgroundColor(Color.LTGRAY);
        game_mode_option_three_button.setBackgroundColor(Color.LTGRAY);
        easy_button.setBackgroundColor(Color.LTGRAY);
        medium_button.setBackgroundColor(Color.LTGRAY);
        hard_button.setBackgroundColor(Color.LTGRAY);

        selectedNumPlayers.setBackgroundColor(Color.GREEN);
        selectedTimeLimit.setBackgroundColor(Color.GREEN);
        selectedGameModeOption.setBackgroundColor(Color.GREEN);
        selectedDifficulty.setBackgroundColor(Color.GREEN);

    }

    private void onePlayerSelected() { numPlayers = 1; }
    private void twoPlayersSelected() { numPlayers = 2; }

    private void timeLimitSelected() {
        timeLimit = true;
    }

    private void dragLimitSelected() {
        timeLimit = false;
    }

    private void seconds10Selected() { gameModeOption = 1; }
    private void seconds30Selected() { gameModeOption = 2; }
    private void seconds60Selected() { gameModeOption = 3; }

    private void drags10Selected() { gameModeOption = 1; }
    private void drags50Selected() { gameModeOption = 2; }
    private void drags100Selected() { gameModeOption = 3; }

    private void easySelected() { difficulty = 1; }
    private void mediumSelected() { difficulty = 2; }
    private void hardSelected() { difficulty = 3; }

    private void saveSelected() {
        returnHome = new Intent(this, topMenu.class);
        Bundle extras = new Bundle();
        extras.putString("NUM_PLAYERS", Integer.toString(numPlayers));
        extras.putString("TIME_LIMIT", Boolean.toString(timeLimit));
        extras.putString("GAME_MODE_OPTION", Integer.toString(gameModeOption));
        extras.putString("DIFFICULTY", Integer.toString(difficulty));
        returnHome.putExtras(extras);
        startActivity(returnHome);
    }

    private void cancelSelected() {
        returnHome = new Intent(this, topMenu.class);
        startActivity(returnHome);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
