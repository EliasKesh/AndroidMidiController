package com.kesh.midictrl;

import android.content.Context;
import android.media.midi.MidiDeviceInfo;
import android.media.midi.MidiInputPort;
import android.media.midi.MidiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class ControlActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int midiDevice = 0;
    MidiManager m;
    MidiDeviceInfo[] infos;
    MidiInputPort inputPort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        // Initialize MIDI
        m = (MidiManager) getApplicationContext().getSystemService(Context.MIDI_SERVICE);
        // Get connected Devices
        infos = m.getDevices();
        // Build String Array
        String[] devices = new String[infos.length];
        for (int i = 0; i < infos.length; i++) {
            devices[i] = infos[i].getProperties().getString(MidiDeviceInfo.PROPERTY_NAME);
        }
        // Populate the Spinner
        Spinner spinnerDevices = findViewById(R.id.spinnerDevices);
        ArrayAdapter<String> adapterDevices = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, devices);
        spinnerDevices.setAdapter(adapterDevices);
        spinnerDevices.setOnItemSelectedListener(this);

        //Connect Buttons
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (0x01); // Program Change
            sendMidi(buffer, numBytes);
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (0x02); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (0x03); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (0x04); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (5); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (6); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (7); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (8); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (9); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (10); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button11 = findViewById(R.id.button11);
        button11.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (11); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button12 = findViewById(R.id.button12);
        button12.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (12); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button13 = findViewById(R.id.button13);
        button13.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (13); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button14 = findViewById(R.id.button14);
        button14.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (14); // Program Change
            sendMidi(buffer, numBytes);
        });

        Button button15 = findViewById(R.id.button15);
        button15.setOnClickListener(v -> {
            byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xc0); // Program Change
            buffer[numBytes++] = (byte) (15); // Program Change
            sendMidi(buffer, numBytes);
        });


        SeekBar seekBar1 = findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar1, int progress, boolean fromUser) {
                byte[] buffer = new byte[32];
                int numBytes = 0;
                buffer[numBytes++] = (byte) (0xB0); // CC on Channel 0
                buffer[numBytes++] = (byte) (0x00); // Controller #0
                buffer[numBytes++] = (byte) (progress); // value
                sendMidi(buffer, numBytes);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar1) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar1) {
                // TODO Auto-generated method stub
            }
        });
        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                byte[] buffer = new byte[32];
                int numBytes = 0;
                buffer[numBytes++] = (byte) (0xB0); // CC on Channel 0
                buffer[numBytes++] = (byte) (1); // Controller #0
                buffer[numBytes++] = (byte) (progress); // value
                sendMidi(buffer, numBytes);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {
                // TODO Auto-generated method stub
            }
        });

        SeekBar seekBar3 = findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar3, int progress, boolean fromUser) {
                byte[] buffer = new byte[32];
                int numBytes = 0;
                buffer[numBytes++] = (byte) (0xB0); // CC on Channel 0
                buffer[numBytes++] = (byte) (2); // Controller #0
                buffer[numBytes++] = (byte) (progress); // value
                sendMidi(buffer, numBytes);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar3) {
                // TODO Auto-generated method stub
            }
        });

        SeekBar seekBar4 = findViewById(R.id.seekBar4);
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar4, int progress, boolean fromUser) {
                byte[] buffer = new byte[32];
                int numBytes = 0;
                buffer[numBytes++] = (byte) (0xB0); // CC on Channel 0
                buffer[numBytes++] = (byte) (3); // Controller #0
                buffer[numBytes++] = (byte) (progress); // value
                sendMidi(buffer, numBytes);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar4) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar4) {
                // TODO Auto-generated method stub
            }
        });


    }

    public void sendMidi(byte[] buffer, int numBytes) {
        if (inputPort != null) {
            /*byte[] buffer = new byte[32];
            int numBytes = 0;
            buffer[numBytes++] = (byte) (0xF0); // MMC
            buffer[numBytes++] = (byte) (0x7F); // MMC
            buffer[numBytes++] = (byte) (0x7F); // all devices
            buffer[numBytes++] = (byte) (0x06); // command
            buffer[numBytes++] = cmd;          // stop
            buffer[numBytes++] = (byte) (0xF7); // end*/
            int offset = 0;
            // post is non-blocking
            try {
                inputPort.send(buffer, offset, numBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getApplicationContext(), "No Input Port connected!",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println(i);
        m.openDevice(infos[midiDevice], device -> {
            if (device == null) {
                Toast.makeText(getApplicationContext(), "Could not open device!",
                        Toast.LENGTH_LONG).show();
            } else {
                inputPort = device.openInputPort(0);
            }
        }, new Handler(Looper.getMainLooper()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
