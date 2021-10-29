package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ac.ucr.tutoticos.modelo.Cuenta;
import ac.ucr.tutoticos.modelo.Estudiante;
import ac.ucr.tutoticos.modelo.Tutor;

public class act_tipo_usuario extends AppCompatActivity {

    Button btn_tutor, btn_estudiante;

    Cuenta cuenta;
    Tutor tutor = new Tutor();
    Estudiante estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_tipo_usuario);

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
                    String nombreU = cuenta.getNombreUsuario();
                    String nombre = cuenta.getNombre();
                    String apellido = cuenta.getApellido();
                    String correo = cuenta.getCorreoUsuario();
                    String pass = cuenta.getContrasenna();

                    tutor.setIdCuenta(0);
                    tutor.setNombreUsuario(nombreU);
                    tutor.setNombre(nombre);
                    tutor.setApellido(apellido);
                    tutor.setCorreoUsuario(correo);
                    tutor.setContrasenna(pass);
                    tutor.setTipoCuenta(0);
                    tutor.setIdEspecialidad(1);
                    tutor.setEdad(20);
                    tutor.setSexo("Sin definir");
                    tutor.setDescripcion("Esta es la descripcion del tutor");
                    tutor.setModalidad("Virtual");
                    tutor.setPrecio(0);
                    tutor.setCalificacion(5);
                    //tutor.setImgUser(null);

                    Intent intent = new Intent(act_tipo_usuario.this, act_Info_tutor.class);
                    intent.putExtra("tutor", tutor);
                    startActivity(intent);
                }
            }
        });

        btn_estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(act_tipo_usuario.this, act_pantalla_principal.class);
                startActivity(intent);
            }
        });
    }
}