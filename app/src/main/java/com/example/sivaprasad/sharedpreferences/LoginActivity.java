package com.example.sivaprasad.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {


    private String mPassword;
    private EditText mPasswordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPasswordText = (EditText) findViewById(R.id.password);

        /* If no password found in shared preferences, then one needs to be set
           1. Find a reference to the Shared Preferences
           2. Check for the key "password"
           3. If none found, create one.
         */

        // Get Shared Preferences
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        // Get the password key
        mPassword = sharedPreferences.getString("password","N/A");

        if (mPassword.equals("N/A")){
            // Password not set yet, Set one here.
            // Transfer to Activity - SetPasswordActivity"
            Intent intent = new Intent(this,SetPasswordActivity.class);
            startActivity(intent);
        }
        else {
            // Password set already. Compare this with the value in Shared Preferences
            if (mPassword.equals(mPasswordText.getText().toString())){
                // Password Matches. Toast and send to main activity
                Toast toast = Toast.makeText(this,"Password Matches",Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
            }
            else {
                // Wrong password. Toast
                Toast toast = Toast.makeText(this,"Wrong Password",Toast.LENGTH_SHORT);
                toast.show();

            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void onClickSubmit(View view) {

    }
}
