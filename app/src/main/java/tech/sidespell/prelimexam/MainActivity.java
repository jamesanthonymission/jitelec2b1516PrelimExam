package tech.sidespell.prelimexam;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    RadioGroup radiogroup;
    RadioButton incrementBtn;
    RadioButton decrementBtn;
    TextView seekbarTextView;
    TextView textView;
    ToggleButton toggleBtn;
    int selectedBtn;
    int timerIncrement = 0;
    int timerDecrement = 0;
    Handler handler = new Handler();
    SeekBar seekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiogroup = (RadioGroup)findViewById(R.id.radioGroup);
        incrementBtn = (RadioButton)findViewById(R.id.incrementBtn);
        decrementBtn = (RadioButton)findViewById(R.id.decrementBtn);
        seekbarTextView = (TextView)findViewById(R.id.seekBarTextView);
        textView = (TextView) findViewById(R.id.textView);
        toggleBtn = (ToggleButton)findViewById(R.id.toggleButton);
        seekbar = (SeekBar) findViewById(R.id.seekBar);

            seekbar.setOnSeekBarChangeListener(this);

            selectedBtn = radiogroup.getCheckedRadioButtonId();

        if(selectedBtn == R.id.incrementBtn ){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    timerIncrement+=1000;
                    textView.setText(timerIncrement/1000 + "");
                    handler.postDelayed(this,1000);
                }
            }; handler.postDelayed(runnable,1000);

        }
        else if(selectedBtn == R.id.decrementBtn){
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    timerDecrement -= 1000;
                    textView.setText(timerDecrement/1000 + "");
                    handler.postDelayed(this,1000);
                }
            };handler.postDelayed(r,1000);
        }






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
