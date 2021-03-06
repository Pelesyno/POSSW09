package dsrtecnologia.com.br.petindermobile;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Like extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frag_content, new LikeFragment())
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.darLike) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_content, new LikeFragment()).commit();
        } else if (id == R.id.nav_verLikes) {
            alert("Bloqueado pela Isabelle");
        } else if (id == R.id.nav_chat) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_content, new ChatFragment()).commit();
        } else if (id == R.id.nav_adocao) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_content, new AdocaoFragment()).commit();
        } else if (id == R.id.nav_hot) {
            alert("Bloqueado pelo Marclenilson");
        } else if (id == R.id.nav_petshop) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_content, new PetShopFragment()).commit();
        }else if (id == R.id.nav_exit) {
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void alert(String m) {
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }
}