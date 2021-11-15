package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import ac.ucr.tutoticos.modelo.Cuenta;
import ac.ucr.tutoticos.modelo.Tutor;

public class act_modalidad_precio extends AppCompatActivity {

    private Spinner sp_modalidad;

    EditText txt_precio;
    Button btn_continuar, btn_volver;

    Tutor tutor = new Tutor();
    Tutor tutoR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_precio_modalidad);

        tutoR = getIntent().getParcelableExtra("tutor");

        sp_modalidad = findViewById(R.id.spModalidad);
        txt_precio = findViewById(R.id.txt_modalidad_precio);
        btn_continuar = findViewById(R.id.btn_modalidad_continuar);
        btn_volver = findViewById(R.id.btn_modalidad_volver);

        String [] opciones= {"Virtual", "Presencial", "Bimodal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_persona, opciones);
        sp_modalidad.setAdapter(adapter);

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txt_precio.getText().toString().isEmpty() || sp_modalidad.getSelectedItem().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Favor llenar todos los espacios",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    if (tutoR == null)
                    {
                        Toast.makeText(getApplicationContext(),"Error al agregar datos",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        tutor.setIdCuenta(tutoR.getIdCuenta());
                        tutor.setNombreUsuario(tutoR.getNombreUsuario());
                        tutor.setNombre(tutoR.getNombre());
                        tutor.setApellido(tutoR.getApellido());
                        tutor.setCorreoUsuario(tutoR.getCorreoUsuario());
                        tutor.setContrasenna(tutoR.getContrasenna());
                        tutor.setTipoCuenta(tutoR.getTipoCuenta());
                        tutor.setIdEspecialidad(tutoR.getIdEspecialidad());

                        tutor.setEdad(0);
                        tutor.setSexo("");
                        tutor.setDescripcion("");
                        tutor.setModalidad(sp_modalidad.getSelectedItem().toString());
                        tutor.setPrecio(Double.parseDouble(txt_precio.getText().toString()));
                        tutor.setCalificacion(0.0);
                        tutor.setImgUser(tutoR.getImgUser());

                        Intent intent = new Intent(act_modalidad_precio.this, act_Info_tutor.class);
                        intent.putExtra("tutor", tutor);
                        startActivity(intent);
                    }

                }

            }
        });
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_modalidad_precio.this, act_tipo_usuario.class);
                startActivity(intent);
            }
        });

    }//fin del onCreate

}//fin de la clase