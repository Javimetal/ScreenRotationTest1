package com.exodux.screenrotationtest1;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView currentMode;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Button butAllowRotation = findViewById(R.id.butAllowRotation);
        Button buttonSetPortrait = findViewById(R.id.setPortrait);
        Button buttonSetLandscape = findViewById(R.id.setLandscape);

        //String rot = SystemProperties.get("persist.sys.app.rotation", "middle_port");
        //String mode = System.getProperties().getProperty("persist.sys.app.rotation");
        mode = getSystemProperty("persist.sys.app.rotation");
        currentMode = findViewById( R.id.currentMode );
        currentMode.setText( mode );

        butAllowRotation.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                mode = getSystemProperty("persist.sys.app.rotation");
                if (mode.equals( "middle_port" )) {
                    String newmode = "original";
                    setSystemProperty( "persist.sys.app.rotation", newmode );
                    currentMode.setText( newmode );
                } else {
                    String newmode = "middle_port";
                    setSystemProperty( "persist.sys.app.rotation", newmode );
                    currentMode.setText( newmode );
                }
            }

        });

        buttonSetPortrait.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

        });

        buttonSetLandscape.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

        });
    }

    private String getSystemProperty(String propertyName) {
        String propertyValue = "[UNKNOWN]";

        try {
            Process getPropProcess = Runtime.getRuntime().exec("getprop " + propertyName);

            BufferedReader osRes =
                    new BufferedReader(new InputStreamReader(getPropProcess.getInputStream()));

            propertyValue = osRes.readLine();

            osRes.close();
        } catch (Exception e) {
            // Do nothing - can't get property value
        }

        return propertyValue;
    }

    private void setSystemProperty(String propertyName, String propertyValue) {
        //propertyValue = "[UNKNOWN]";

        try {
            Process setPropProcess = Runtime.getRuntime().exec("setprop " + propertyName + " " +propertyValue);

            BufferedReader osRes =
                    new BufferedReader(new InputStreamReader(setPropProcess.getInputStream()));

            //propertyValue = osRes.readLine();

            osRes.close();
        } catch (Exception e) {
            // Do nothing - can't set property value
        }

        //return getSystemProperty("propertyName");
    }
}
