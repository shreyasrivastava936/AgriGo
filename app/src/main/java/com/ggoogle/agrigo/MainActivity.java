package com.ggoogle.agrigo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView dashboard, Data, GovSchemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //views initialization
        dashboard = (TextView) findViewById(R.id.b1);
        Data = (TextView) findViewById(R.id.b2);
        GovSchemes = (TextView) findViewById(R.id.b3);

        //default fragment = dashboard
        Fragment dashboardFragment = new DashboardFragment();
        replaceFragment(dashboardFragment);

        //onClick listener
        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment dashboardFragment = new DashboardFragment();
                replaceFragment(dashboardFragment);
            }
        });

        Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment dataFragment = new DataFragment();
                replaceFragment(dataFragment);
            }
        });

        GovSchemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment govSchemesFragment = new GovSchemesFragment();
                replaceFragment(govSchemesFragment);
            }
        });
    }

    //replaceFragment method
    // Replace current Fragment with the destination Fragment.
    public void replaceFragment(Fragment destFragment)
    {
        final int CONTENT_VIEW_ID = 10101010;
        FrameLayout frame = new FrameLayout(this);
        frame.setId(CONTENT_VIEW_ID);

        // First get FragmentManager object.
        FragmentManager fragmentManager = this.getFragmentManager();

        // Begin Fragment transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.dynamic_fragment_frame_layout, destFragment);

        // Commit the Fragment replace action.
        fragmentTransaction.commit();
    }
}
