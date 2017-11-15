package com.example.louis.pokecard_android.presentation.component;

import android.app.Activity;
import android.view.View;

import com.example.louis.pokecard_android.R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

/**
 * Created by louis on 15/11/2017.
 */

public class NavigationDrawerImpl implements NavigationDrawer {

    Activity activity;

    @Override
    public void createNavigationDrawer(Activity activity) {
        this.activity = activity;
        new DrawerBuilder().withActivity(activity).build();
        createMenu();
    }

    private void createMenu() {
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.menu_label_pokemons);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.menu_label_members);

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .addDrawerItems(
                        item1,
                        item2,
                        new SecondaryDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                })
                .build();
    }
}
