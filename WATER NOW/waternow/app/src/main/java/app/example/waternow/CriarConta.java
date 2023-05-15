package app.example.waternow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CriarConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);
        ((Button) findViewById(R.id.btnOK)).setOnClickListener((e) -> RegistrarUsuario());
    }

    private void RegistrarUsuario() {
        String userEmail = ((EditText)findViewById(R.id.inputEmail)).getText().toString();
        String pass = ((EditText)findViewById(R.id.inputSenha)).getText().toString();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(userEmail, pass).addOnCompleteListener(this,
                task -> {
                    if (task.isSuccessful()) {
                        Log.i("registro", FirebaseAuth.getInstance().getCurrentUser().getUid() + "registro OK");
                        // pegar ID e atualizar banco com informações
                    } else {
                        Log.i("registro", "erro no registro --" + task.getException());
                        Toast.makeText(CriarConta.this, "Erro na criação de conta.",
                                Toast.LENGTH_SHORT).show();

                        // mostrar mensagem de erro
                    }
                }
        );
    }
}