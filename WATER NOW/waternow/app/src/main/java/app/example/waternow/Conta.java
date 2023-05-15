package app.example.waternow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.InputStream;
import java.net.URL;

import app.example.waternow.R;

public class Conta extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);
        drawerLayout = findViewById(R.id.conta1);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null)
        {
            MainActivity.redirectActivity(this,MainActivity.class);
        } else
        {
            ((ImageView) findViewById(R.id.imgUserFoto)).setImageDrawable(carregarFotoUsuario(user.getPhotoUrl().toString()));
            ((TextView) findViewById(R.id.textUserEmail)).setText(getString(R.string.textUserEmail, user.getEmail()));
            ((TextView) findViewById(R.id.textUserName)).setText(getString(R.string.textUserName, user.getDisplayName()));
        }
    }

    private static Drawable carregarFotoUsuario(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "photo");
            return d;
        } catch (Exception e) {
            Log.e("erro foto", e.getMessage());
            return null;
        }
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
    public void Conta1(View view){
        MainActivity.redirectActivity(this,Conta.class);
    }
    public void Relatorio1(View view){MainActivity.redirectActivity(this,Relatorio.class);}
    public void Metas1(View view){
        MainActivity.redirectActivity(this,Metas.class);
    }
    public void Configuracoes1(View view){MainActivity.redirectActivity(this,Configuracoes.class);}

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}