package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import ac.ucr.tutoticos.modelo.Cuenta;
import ac.ucr.tutoticos.modelo.Estudiante;
import ac.ucr.tutoticos.modelo.Tutor;

public class act_tipo_usuario extends AppCompatActivity {

    Button btn_tutor, btn_estudiante;

    Cuenta cuenta;
    Tutor tutor = new Tutor();
    Estudiante estudiante=new Estudiante();

    FirebaseDatabase databaseFirebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_tipo_usuario);
        inicializarFirebase();

        btn_tutor = findViewById(R.id.tipoCuenta_btn_tutor);
        btn_estudiante = findViewById(R.id.tipoCuenta_btn_estudiante);

        cuenta = getIntent().getParcelableExtra("cuenta");

        btn_tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cuenta == null)
                {
                    Toast.makeText(getApplicationContext(),"Error al agregar datos",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    tutor.setIdCuenta("");
                    tutor.setNombreUsuario(cuenta.getNombreUsuario());
                    tutor.setNombre(cuenta.getNombre());
                    tutor.setApellido(cuenta.getApellido());
                    tutor.setCorreoUsuario(cuenta.getCorreoUsuario());
                    tutor.setContrasenna(cuenta.getContrasenna());
                    tutor.setTipoCuenta(0);
                    tutor.setIdEspecialidad(1);
                    tutor.setEdad(20);
                    tutor.setSexo("Sin definir");
                    tutor.setDescripcion("Esta es la descripcion del tutor");
                    tutor.setModalidad("Virtual");
                    tutor.setPrecio(0);
                    tutor.setCalificacion(5);
                    tutor.setImgUser(cuenta.getImgUser());

                    Intent intent = new Intent(act_tipo_usuario.this, act_modalidad_precio.class);
                    intent.putExtra("tutor", tutor);
                    startActivity(intent);
                }
            }
        });

        btn_estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                estudiante.setIdCuenta("");
                estudiante.setNombreUsuario(cuenta.getNombreUsuario());
                estudiante.setNombre(cuenta.getNombre());
                estudiante.setApellido(cuenta.getApellido());
                estudiante.setCorreoUsuario(cuenta.getCorreoUsuario());
                estudiante.setContrasenna(cuenta.getContrasenna());
                estudiante.setTipoCuenta(1);
                estudiante.setImgUser(cuenta.getImgUser());

                if (estudiante != null)
                {
                    if(agregarEstudiante(estudiante))
                    {
                        Intent intent = new Intent(act_tipo_usuario.this, act_iniciosesion.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"Error al registrar Usuario",Toast.LENGTH_LONG).show();
                    }
                }//fin del if
            }
        });
    }

    public boolean agregarEstudiante(Estudiante est){
        if(est != null)
        {
            est.setIdCuenta(UUID.randomUUID().toString());
            databaseReference.child("Estudiante").child(est.getIdCuenta()).setValue(est);
            return true;
        }
        else
        {
            return false;
        }

    }//fin del metodo

    public void  inicializarFirebase()
    {
        FirebaseApp.initializeApp(this);
        databaseFirebase = FirebaseDatabase.getInstance();//obtengo instancia de firebase
        databaseReference = databaseFirebase.getReference();//obtengo referencia para utilizar la base de datos

    }//fin del metodo inicializarFireBase

}