package com.example.partharya.generator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private EditText name, number, facebook, snapchat, linkedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this; //this is the context
        name = (EditText) this.findViewById(R.id.editText);
        number = (EditText) this.findViewById(R.id.editText2);
        facebook = (EditText) this.findViewById(R.id.editText3);
        snapchat = (EditText) this.findViewById(R.id.editText4);
        linkedIn = (EditText) this.findViewById(R.id.editText5);

        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text2Qr = "Name: "+ name.getText().toString() + "/" + "Number: " + number.getText().toString() + "/" + "Facebook: "
                        + facebook.getText().toString() + "/" + "snapchat: " + snapchat.getText().toString() +"/"+  "linkedIn: " + linkedIn.getText().toString();

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    Intent intent = new Intent(context, QRActivity.class);
                    intent.putExtra("pic",bitmap);
                    context.startActivity(intent);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
