package ac.ucr.tutoticos;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

import ac.ucr.tutoticos.modelo.Cuenta;

public class act_iniciosesion extends AppCompatActivity {

    Button btn_ingresar;
    TextView txt_registrarse, txt_msj;
    EditText txt_usuario, txt_contrasena;

    Cuenta cuenta = new Cuenta();

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_iniciosesion);

        btn_ingresar = findViewById(R.id.btn_ingresar);

        txt_registrarse = findViewById(R.id.inision_txt_registarse);

        txt_usuario = findViewById(R.id.txt_nombreUser);
        txt_contrasena = findViewById(R.id.txt_contrasena);
        txt_msj = findViewById(R.id.txt_huella_msj);

        //sensor biometrico
        //------------------------------------------------------------------------------------------

        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()){

            case BiometricManager.BIOMETRIC_SUCCESS:
                txt_msj.setText("Puesde utilizar tu dedo para logearte");
                txt_msj.setTextColor(Color.parseColor("#fffff"));
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                txt_msj.setText("Tu dispositivo no posee el sensor biometrico");
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                txt_msj.setText("Actualmente el sensor no esta disponible");
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                txt_msj.setText("No hay ninguna huega resitrada en el dispositivo");
                break;

        }//fin del switch

        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(act_iniciosesion.this, executor, new BiometricPrompt.AuthenticationCallback(){
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),"Logeado correctamente",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        //dialogo biomenrico
        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Login")
                .setSubtitle("Usa tu hulla para logearte")
                .setNegativeButtonText("Cancelar")
                .build();

        //------------------------------------------------------------------------------------------

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(txt_usuario.getText().toString().isEmpty() || txt_contrasena.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Favor llenar todos los campos",Toast.LENGTH_SHORT).show();
                }
                else {
                    cuenta.setIdCuenta("");
                    cuenta.setNombreUsuario(txt_usuario.getText().toString());
                    cuenta.setNombre("");
                    cuenta.setApellido("");
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