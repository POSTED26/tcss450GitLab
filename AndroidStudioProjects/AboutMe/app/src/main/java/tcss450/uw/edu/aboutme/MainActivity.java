package tcss450.uw.edu.aboutme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Opens a new activity and displays a TextView listing
     * information about the author.
     * @param view
     */
    public void openAboutMe(View view){
        Intent intent = new Intent(this, TextViewActivity.class);
        startActivity(intent);
    }
    /**
     * Opens an image on a different activity.
     * @param view
     */
    public void openImage(View view){
        Intent intent = new Intent(this, DisplayImageActivity.class);
        startActivity(intent);
    }

    /**
     * Opens to a website in a new activity.
     * @param view
     */
    public void openWeb(View view){
        // Build the intent
        Uri webpage = Uri.parse("http://developer.android.com/index.html");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

// Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

// Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(webIntent);
        }
    }
    /**
     * Opens a Toast.
     * @param view not used.
     */
    public void openToast(View view){
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Opens a dialog box.
     * @param view
     */
    public void openDialog(View view){
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

// 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Pen Pineapple Apple Pen.")
                .setTitle("What do we have?");
        //builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener(){

       // })
// 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        builder.show();
    }
}
