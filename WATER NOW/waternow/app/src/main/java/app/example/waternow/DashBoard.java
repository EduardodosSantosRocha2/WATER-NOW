package app.example.waternow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DashBoard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        drawerLayout=findViewById(R.id.drawer_layout);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Pessoa teste = new Pessoa(FirebaseAuth.getInstance().getCurrentUser().getUid(), "Joao Teste");

        ((Button)findViewById(R.id.btnAddAgua)).setOnClickListener((e) ->
        {
            teste.agua = Double.parseDouble(((EditText) findViewById(R.id.editQtdAgua)).getText().toString());
            db.collection("pessoa")
                    .add(teste)
                    .addOnSuccessListener(documentReference -> Log.d("a", "DocumentSnapshot written with ID: " + documentReference.getId()))
                    .addOnFailureListener(e1 -> Log.w("a", "Error adding document", e1));
        });
    }
    public void Conta1(View view) {
        MainActivity.redirectActivity(this, Conta.class);
    }
    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public  void Clickhome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public  void clickDashboard(View view){
        recreate();
    }
    public void clickAboutUs(View view){
        MainActivity.redirectActivity(this,AboutUs.class);
    }
    public  void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}