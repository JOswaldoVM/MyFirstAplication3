package com.l20291025.myfirstaplication3.usuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.l20291025.myfirstaplication3.R;
import com.l20291025.myfirstaplication3.usuario.model.Usuario;
import com.l20291025.myfirstaplication3.usuario.repository.UsuarioRepository;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

public class DashboardUuario extends AppCompatActivity {
    private UsuarioRepository ur;
    Toolbar toolbar;
    private Usuario userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_uuario);
        TextView tvUser = findViewById(R.id.tvUser2);
        TextView tvContra = findViewById(R.id.tvContra);
        TextView tvName = findViewById(R.id.tvNombre);
        TextView tvEdad = findViewById(R.id.tvEdad);
        TextView tvEmail = findViewById(R.id.tvEmail);

        //Aqui creamos la instancia del Usuario Repository
        ur = UsuarioRepository.getInstance();

        //Esta es la manera en la que recibimos información de otro activity
        String usuario = getIntent().getStringExtra("usuario");
        String pass = getIntent().getStringExtra("pass");


        //Obtenemos información del usuario logueado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvUser.setText("Usuario: "+ userInfo.getUsuario()+"\n");
        tvContra.setText("Contraseña: "+ userInfo.getPasss()+"\n");
        tvName.setText("Dueño: "+ userInfo.getNombre()+"\n");
        tvEdad.setText("Edad: "+ userInfo.getEdad()+"\n");
        tvEmail.setText("Email: "+ userInfo.getEmail()+"\n");


    }
    

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.miBorrar){
            Toast.makeText(this , "Borrar", Toast.LENGTH_LONG).show();
        }else if (item.getItemId() == R.id.miInfo){
            Toast.makeText(this, "Info", Toast.LENGTH_LONG).show();
        }else if(item.getItemId() == R.id.miSetting){
            Toast.makeText(this, "Info", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}