package ac.ucr.tutoticos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ac.ucr.tutoticos.modelo.Cuenta;
import ac.ucr.tutoticos.modelo.Tutor;

public class act_registroTutor extends AppCompatActivity {

    Tutor tutor;
    FirebaseDatabase databaseFirebase;
    DatabaseReference databaseReference;

    Tutor addTutor;
    Cuenta loginCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_registro_tutor);

        addTutor = getIntent().getParcelableExtra("tutor");
        loginCuenta = getIntent().getParcelableExtra("login");

        inicializarFirebase();

        if (addTutor != null)
        {
            if(agregarTutor(addTutor))
            {
                Intent intent = new Intent(act_registroTutor.this, act_iniciosesion.class);
                startActivity(intent);
            }else
            {
                Toast.makeText(getApplicationContext(),"Error al registrar Usuario",Toast.LENGTH_LONG).show();
            }
        }//fin del if

        if(loginCuenta != null){
            loginVerification();
        }//fin del if

    }//fin del onCreate

    public void  inicializarFirebase()
    {
        FirebaseApp.initializeApp(this);
        databaseFirebase = FirebaseDatabase.getInstance();//obtengo instancia de firebase
        databaseReference = databaseFirebase.getReference();//obtengo referencia para utilizar la base de datos

    }//fin del metodo inicializarFireBase

    public void loginVerification()
    {
        ArrayList<Tutor> listaTutores= new ArrayList<>();
        databaseReference.child("Tutor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot obj: snapshot.getChildren()){
                    tutor = obj.getValue(Tutor.class);
                    listaTutores.add(tutor);
                }
                Tutor logT = getTutor(listaTutores, loginCuenta.getNombreUsuario());
                if(logT != null){
                    if(logT.getContrasenna().equalsIgnoreCase(loginCuenta.getContrasenna())){
                        Intent intent = new Intent(act_registroTutor.this, act_perfiltutor.class);
                        intent.putExtra("tutor", logT);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario o contraseña incorracta",Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent (act_registroTutor.this, act_iniciosesion.class);
                        startActivity(intent);
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"usuario no encontrado",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent (act_registroTutor.this, act_iniciosesion.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Fallo la lectura: " + error.getCode());
            }
        });

    }//fin del metodo lista de datos

    public boolean agregarTutor(Tutor t){
        if(t != null)
        {
            t.setIdCuenta(UUID.randomUUID().toString());
            databaseReference.child("Tutor").child(t.getIdCuenta()).setValue(t);
            return true;
        }
        else
        {
            return false;
        }

    }//fin del metodo

    public Tutor getTutor(ArrayList<Tutor> list, String user){
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

}//fin de la clase