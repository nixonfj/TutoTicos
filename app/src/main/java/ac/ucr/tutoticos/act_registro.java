package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ac.ucr.tutoticos.modelo.Cuenta;

public class act_registro extends AppCompatActivity {

    Cuenta cuenta = new Cuenta();

    Button btn_registrar, btn_ingreso;
    EditText txt_correo, txt_user, txt_contrasena, txt_contrasenaConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_registro);

        btn_registrar = findViewById(R.id.registro_btn_registrar);
        btn_ingreso = findViewById(R.id.registro_btn_ingresar);

        txt_correo = findViewById(R.id.txt_correo_registro);
        txt_user = findViewById(R.id.txt_usuar_registro);
        txt_contrasena = findViewById(R.id.txt_contrasena_registro);
        txt_contrasenaConfirm = findViewById(R.id.txt_contrasenaConfirm_registro);

        btn_ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_registro.this, act_iniciosesion.class);
                startActivity(intent);
            }
        });
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txt_correo.getText().toString().isEmpty() || txt_user.getText().toString().isEmpty() || txt_contrasena.getText().toString().isEmpty() || txt_contrasenaConfirm.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Favor llenar todos los campos",Toast.LENGTH_SHORT).show();
                }else
                {
                    String correo = txt_correo.getText().toString();
                    String user = txt_user.getText().toString();
                    String contrasena = txt_contrasena.getText().toString();
                    String contrasenaC = txt_contrasenaConfirm.getText().toString();

                    if(contrasena.equalsIgnoreCase(contrasenaC)){

                        cuenta.setCorreoUsuario(correo);
                        cuenta.setNombreUsuario(user);
                        cuenta.setContrasenna(contrasena);
                        cuenta.setNombreCompleto("");
                        cuenta.setTipoCuenta(-1);

                        Intent intent = new Intent(act_registro.this, act_datos_principales.class);
                        intent.putExtra("cuenta", cuenta);
                        startActivity(intent);

                    }else{
                        Toast.makeText(getApplicationContext(),"La contraseñas ingresadas no concuerdan",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}//fin de la clase