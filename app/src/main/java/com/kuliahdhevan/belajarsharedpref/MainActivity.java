package com.kuliahdhevan.belajarsharedpref;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAddress;
    Button saveBtn;

    private final String FULLNAME = "fullname";
    private final String ADDRESS = "address";

    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.kuliahdhevan.belajarsharedpref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        saveBtn = findViewById(R.id.saveBtn);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        String mName = mPreferences.getString(FULLNAME, "");
        edtName.setText(mName);
        String mAddress = mPreferences.getString(ADDRESS, "");
        edtAddress.setText(mAddress);
    }

    public void save(View view) {
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(FULLNAME, edtName.getText().toString());
        preferencesEditor.putString(ADDRESS, edtAddress.getText().toString());
        preferencesEditor.apply();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Konfirmasi");
        alert.setMessage("Data Tersimpan");
        alert.setIcon(R.drawable.ic_launcher_foreground);
        alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Sukses Simpan", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
    }
}