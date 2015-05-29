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


public class SetPasswordActivity extends ActionBarActivity {

    private EditText mPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_password, menu);
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
        // Make sure the Password is NOT "N/A"
        mPassword = (EditText) findViewById(R.id.password);
       if (mPassword.equals("N/A")){
            Toast toast = Toast.makeText(this,"N/A is not allowed as password",Toast.LENGTH_SHORT);
            toast.show();
       }
       else {
            // New Password Set, save this to the Shared Preferences and
            // take the user back to the login Activity
            SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("password",mPassword.getText().toString());
            editor.commit();
           
           // Taking the user back to the main activity for logging in

           Intent intent = new Intent(this,LoginActivity.class);
           startActivity(intent);
        }
    }
}
