/**
 * Hieu Duong
 * CSC 201
 * Assignment 4
 * Problem 4.11:
 * Decimal to hex) Write a program that prompts the user to enter an integer between
 * 0 and 15 and displays its corresponding hex number.
 *
 * 10/13/2017
 *
 */

package edu.vccs.hduong7592.csc_201_assignment4_android;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ResultLB;
    Button SubmitBtn;
    EditText InputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputTxt = (EditText) findViewById(R.id.InputTxt);
        SubmitBtn = (Button) findViewById(R.id.SubmitBtn);
        ResultLB = (TextView) findViewById(R.id.ResultLB);

        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int input = Integer.parseInt(InputTxt.getText().toString());

                if (input < 0 || input > 15){
                   showSimpleDialog("Please enter value from 0 to 15 only!");
                }
                else{
                    ResultLB.setText("Hex value is: "+Integer.toHexString(input).toUpperCase());
                    InputTxt.setText("");
                }
            }
        });
    }

    /**
     * Alert box
     * @param Message
     */

    public void showSimpleDialog(String Message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Error!!!");
        builder.setMessage(Message);
        builder.setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
                InputTxt.setText("");
            }
        });
        builder.create().show();
    }
}
