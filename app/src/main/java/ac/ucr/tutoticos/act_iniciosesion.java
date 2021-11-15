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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;

import ac.ucr.tutoticos.modelo.Cuenta;
import ac.ucr.tutoticos.modelo.Estudiante;
import ac.ucr.tutoticos.modelo.Tutor;

public class act_iniciosesion extends AppCompatActivity {

    Button btn_ingresar;
    TextView txt_registrarse, txt_msj;
    EditText txt_usuario, txt_contrasena;

    Estudiante estudiante;

    Cuenta cuenta = new Cuenta();
    FirebaseDatabase databaseFirebase;
    DatabaseReference databaseReference;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_iniciosesion);
        inicializarFirebase();

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

                    loginVerification();
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

    public void loginVerification()
    {
        ArrayList<Estudiante> listaEstudiantes= new ArrayList<>();
        databaseReference.child("Estudiante").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot obj: snapshot.getChildren()){
                    estudiante = obj.getValue(Estudiante.class);
                    listaEstudiantes.add(estudiante);
                }
                Estudiante logE = getEstudiante(listaEstudiantes, cuenta.getNombreUsuario());
                if(logE != null){
                    if(logE.getContrasenna().equalsIgnoreCase(cuenta.getContrasenna())){
                        Intent intent = new Intent(act_iniciosesion.this, act_pantalla_principal.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario o contraseña incorracta",Toast.LENGTH_SHORT).show();
                        clear();
                    }

                }else{

                    Intent intent = new Intent(act_iniciosesion.this, act_registroTutor.class);
                    intent.putExtra("login", cuenta);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Fallo la lectura: " + error.getCode());
            }
        });

    }//fin del metodo lista de datos

    public Estudiante getEstudiante(ArrayList<Estudiante> list, String user){
        if(list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++){
                if(list.get(i).getNombreUsuario().equalsIgnoreCase(user))
                {
                    return list.get(i);
                }
            }
        }

        return null;

    }//fin del metodo

    public void clear()
    {
        txt_usuario.setText("");
        txt_contrasena.setText("");
    }//fin del metodo

    public void  inicializarFirebase()
    {
        FirebaseApp.initializeApp(this);
        databaseFirebase = FirebaseDatabase.getInstance();//obtengo instancia de firebase
        databaseReference = databaseFirebase.getReference();//obtengo referencia para utilizar la base de datos

    }//fin del metodo inicializarFireBase

}//fin de la clase