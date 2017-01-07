package io.github.tsuyosh.displaymetricsdemo;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        DisplayMetrics metrics = getResources().getDisplayMetrics();

        ((TextView) findViewById(R.id.density_value)).setText(String.valueOf(metrics.density));
        ((TextView) findViewById(R.id.scaled_density_value)).setText(String.valueOf(metrics.scaledDensity));

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        ((TextView) findViewById(R.id.density_value2)).setText(String.valueOf(metrics.density));
        ((TextView) findViewById(R.id.scaled_density_value2)).setText(String.valueOf(metrics.scaledDensity));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_display_setting) {
            Intent intent = new Intent("android.settings.DISPLAY_SETTINGS");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            List<ResolveInfo> activities = getPackageManager().queryIntentActivities(intent, 0);
            if (!activities.isEmpty()) {
                startActivity(intent);
            }
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
