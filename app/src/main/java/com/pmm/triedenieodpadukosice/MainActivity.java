package com.pmm.triedenieodpadukosice;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button buttonNotifikacie;
    private Button buttonInformacie;
    private Button buttonMapa;
    Map mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNotifikacie=(Button) findViewById(R.id.btnNotifikacie);
        buttonInformacie=(Button) findViewById(R.id.btnInformacie);
        buttonMapa=(Button) findViewById(R.id.btnMapa);

        buttonNotifikacie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Menu_Notifikacie.class);
                startActivity(intent);
            }
        });

        buttonInformacie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Menu_Informacie.class);
                startActivity(intent);
            }
        });

        buttonMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.About_Us_id:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainActivityLayout, new AboutUsFragment())
                        .addToBackStack("MainActivity")
                        .commit();

                return true;

            case R.id.Contact_us_id:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainActivityLayout, new ContactUsFragment())
                        .addToBackStack("MainActivity")
                        .commit();

                return true;
            case R.id.Fivethings_id:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainActivityLayout, new FiveThingsFragment())
                        .addToBackStack("MainActivity")
                        .commit();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}

