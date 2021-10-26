package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ac.ucr.tutoticos.modelo.Cuenta;

public class act_iniciosesion extends AppCompatActivity {

    Button btn_ingresar;
    TextView txt_registrarse;
    EditText txt_usuario, txt_contrasena;

    Cuenta cuenta = new Cuenta();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_iniciosesion);

        btn_ingresar = findViewById(R.id.btn_ingresar);

        txt_registrarse = findViewById(R.id.inision_txt_registarse);

        txt_usuario = findViewById(R.id.txt_nombreUser);
        txt_contrasena = findViewById(R.id.txt_contrasena);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txt_usuario.getText().toString().isEmpty() || txt_contrasena.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Favor llenar todos los campos",Toast.LENGTH_SHORT).show();
                }
                else {
                    cuenta.setIdCuenta(0);
                    cuenta.setNombreUsuario(txt_usuario.getText().toString());
                    cuenta.setNombreCompleto("");
                    cuenta.setCorreoUsuario("");
                    cuenta.setContrasenna(txt_contrasena.getText().toString());
                    cuenta.setTipoCuenta(-1);

                    Intent intent = new Intent(act_iniciosesion.this, act_registroTutor.class);
                    intent.putExtra("login", cuenta);
                    startActivity(intent);
                }

            }
        });

        txt_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(act_iniciosesion.this, act_registro.class);
                startActivity(intent);
            }
        });
    }//fin del onCreate

}//fin de la clase