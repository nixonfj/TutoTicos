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

import ac.ucr.tutoticos.modelo.Tutor;

public class act_Info_tutor extends AppCompatActivity {

    private Spinner sp_sexo;
    private Button continuar;
    EditText txt_edad, txt_descripcion;

    Tutor tutor = new Tutor();
    Tutor tutoR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_info_tutor);

        sp_sexo = findViewById(R.id.spSexo);
        continuar = findViewById(R.id.btn_modalidad_continuar);
        txt_edad = findViewById(R.id.txt_edad_infoT);
        txt_descripcion = findViewById(R.id.txt_descripcion_infoT);

        tutoR = getIntent().getParcelableExtra("tutor");

        String [] opciones= {"Sexo", "Femenino", "Masculino", "Otro"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_persona, opciones);
        sp_sexo.setAdapter(adapter);

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (txt_edad.getText().toString().isEmpty() || txt_descripcion.getText().toString().isEmpty() || sp_sexo.getSelectedItem().toString().equalsIgnoreCase("Sexo"))
                {
                    Toast.makeText(getApplicationContext(),"Favor llenar todos los espacios",Toast.LENGTH_SHORT).show();
                }
                else
                    {

                        if (tutor == null)
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

                            tutor.setEdad(Integer.parseInt(txt_edad.getText().toString()));
                            tutor.setSexo(sp_sexo.getSelectedItem().toString());
                            tutor.setDescripcion(txt_descripcion.getText().toString());
                            tutor.setModalidad(tutoR.getModalidad());
                            tutor.setPrecio(tutoR.getPrecio());
                            tutor.setCalificacion(0.0);
                            tutor.setImgUser(tutoR.getImgUser());
                            tutor.setMateria(tutoR.getMateria());

                            Intent intent = new Intent(act_Info_tutor.this, act_materia.class);
                            intent.putExtra("tutor", tutor);
                            startActivity(intent);
                        }

                    }

            }
        });

    }
}