package library.management;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    public static final String EXTRA_MESSAGE = "library.management.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //see if fragments are already loaded

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.commonlysearched);

        if( f instanceof CommSearchFragment || f instanceof PubResultFragment) {
            return;
        }

        // get fragment manager
        FragmentTransaction ft = fm.beginTransaction();
        //replace empty frames with fragments
        ft.replace(R.id.publishersearch, new PubSearchFragment());
        ft.replace(R.id.commonlysearched, new CommSearchFragment());
        ft.commit();
    }



    //called when the user presses the search button
    public void searchPublisher(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.commonlysearched, new PubResultFragment());
        ft.commit();
    }

    public void Back(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.commonlysearched, new CommSearchFragment());
        ft.commit();
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
