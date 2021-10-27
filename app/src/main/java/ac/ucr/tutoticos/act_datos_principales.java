package ac.ucr.tutoticos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import ac.ucr.tutoticos.modelo.Cuenta;
import ac.ucr.tutoticos.modelo.Tutor;

public class act_datos_principales extends AppCompatActivity {

    Button btn_continuar, btn_foto;
    ImageView img_foto;
    EditText txt_nombre, txt_apellidos;

    Cuenta cuentaR;

    Uri direccionFoto;

    private final int galeria = 1;
    private final int camara = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_datos_principales);

        btn_continuar = findViewById(R.id.datos_btn_continuar);
        btn_foto = findViewById(R.id.datosPrincipales_btn_elegir_foto);

        txt_nombre = findViewById(R.id.txt_nombre_datos);
        txt_apellidos = findViewById(R.id.txt_apellidos_datos);

        img_foto = findViewById(R.id.img_foto);

        cuentaR = getIntent().getParcelableExtra("cuenta");

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txt_nombre.getText().toString().isEmpty() || txt_apellidos.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Favor llenar todos los campos",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String nombreC = ""+txt_nombre.getText().toString()+ " " + txt_apellidos.getText().toString();

                    Cuenta cuenta = new Cuenta(0, cuentaR.getNombreUsuario(), nombreC, cuentaR.getCorreoUsuario(), cuentaR.getContrasenna(), cuentaR.getTipoCuenta()/*direccionFoto*/);

                    Intent intent = new Intent(act_datos_principales.this, act_tipo_usuario.class);
                    intent.putExtra("cuenta", cuenta);
                    startActivity(intent);
                }
            }
        });

        btn_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Tab", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(act_datos_principales.this);
                alertDialog.setTitle("Selecciones la Fotografía");
                alertDialog.setMessage("¿Qué desea utilizar?");
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setCancelable(false);

                alertDialog.setPositiveButton("Galería", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(intent.ACTION_GET_CONTENT);

                        startActivityForResult(intent.createChooser(intent, "Seleccione una fotografía"), galeria);

                    }
                });

                alertDialog.setNegativeButton("Cámara", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, camara);

                    }
                });

                alertDialog.show();

            }//Fin onClick

        });

    }//Fin onCreate

    public void onActivityResult(int rqCode, int resCode, Intent data) {

        super.onActivityResult(rqCode, resCode, data);

        if (resCode == RESULT_OK) {

            switch (rqCode) {
                case galeria:

                    direccionFoto = data.getData();
                    img_foto.setImageURI(direccionFoto);
                    Toast.makeText(getApplicationContext(), "Imagen cargada", Toast.LENGTH_SHORT).show();

                    break;

                case camara:
                    if (data != null) {

                        Bitmap thumnail = (Bitmap) data.getExtras().get("data");
                        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                        thumnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

                        File destination = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
                        FileOutputStream fileOutputStream;

                        try {

                            destination.createNewFile();
                            fileOutputStream = new FileOutputStream(destination);
                            fileOutputStream.write(bytes.toByteArray());
                            fileOutputStream.close();

                        } catch (FileNotFoundException e) {

                            e.printStackTrace();

                        } catch (IOException ex) {

                            ex.printStackTrace();

                        }

                        img_foto.setImageBitmap(thumnail);
                        direccionFoto = (Uri) data.getData();
                        Toast.makeText(getApplicationContext(), "Fotografía capturada", Toast.LENGTH_SHORT).show();

                    }
                    break;
            }

        } else {
            Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
        }

    }
}