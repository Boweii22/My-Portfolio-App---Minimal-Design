package com.example.myportfolioapp;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myportfolioapp.CV.CVFragment;
import com.example.myportfolioapp.contact.ContactFragment;
import com.example.myportfolioapp.home.HomeFragment;
import com.example.myportfolioapp.portfolio.PortfolioFragment;
import com.example.myportfolioapp.sidemenu.Callback;
import com.example.myportfolioapp.sidemenu.MenuAdapter;
import com.example.myportfolioapp.sidemenu.MenuItem;
import com.example.myportfolioapp.sidemenu.MenuUtil;
import com.example.myportfolioapp.team.TeamFragment;

import java.util.List;


public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRv;
    ImageView imageView2;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos = 0 ;
    private Dialog fullImageDialog;
    private ImageView fullProfileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // setup side menu
        setupSideMenu();

        // set the default fragment when activity launch
        setHomeFragment();

        // Create and configure the dialog
        fullImageDialog = new Dialog(this);
        fullImageDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        fullImageDialog.setContentView(R.layout.dialog_full_profile);
        fullProfileImage = fullImageDialog.findViewById(R.id.fullProfileImage);

        // Load the mini profile image as a circle
        Glide.with(this)
                .load(R.drawable.profile_image)
                .apply(RequestOptions.circleCropTransform())
                .into(fullProfileImage);

        imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the full profile image as a circle
                Glide.with(MainActivity.this)
                        .load(R.drawable.profile_image)
                        .apply(RequestOptions.circleCropTransform())
                        .into(fullProfileImage);

                fullImageDialog.show();
            }
        });

    }



    private void setupSideMenu() {

        menuRv = findViewById(R.id.rv_side_menu);

        // get menu list item  will get data from a static data class

        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems,this);
        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.setAdapter(adapter);

    }

    void setContactFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ContactFragment()).commit();
    }

    void setPortfoliofragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PortfolioFragment()).commit();

    }

    void setTeamFragment () {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new TeamFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new CVFragment()).commit();
    }


    void setHomeFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

    }


    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuItems.get(i).getCode()) {

            case MenuUtil.HOME_FRAGMENT_CODE : setHomeFragment();
                break;
            case MenuUtil.CV_FRAGMENT_CODE : setCVFragment();
                break;
            case MenuUtil.TEAM_FRAGMENT_CODE: setTeamFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE:setPortfoliofragment();
                break;
            case MenuUtil.CONTACT_FRAGMENT_CODE: setContactFragment();
                break;
            default: setHomeFragment();
        }

        // hightligh the selected menu item

        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i ;
        adapter.notifyDataSetChanged();

    }
}