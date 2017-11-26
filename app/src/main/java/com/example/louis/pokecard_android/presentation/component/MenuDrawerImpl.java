package com.example.louis.pokecard_android.presentation.component;

import android.app.Activity;
import android.view.View;

import com.example.louis.pokecard_android.R;
import com.example.louis.pokecard_android.presentation.navigator.MenuNavigator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

/**
 * Created by louis on 15/11/2017.
 */

public class MenuDrawerImpl implements MenuDrawer {

    private final static int USER_POKEMONS_MENU_ID = 1;
    private final static int POKEMON_MENU_ID = 2;
    private final static int MEMBERS_MENU_ID = 3;
    private final static int EXCHANGE_MENU_ID = 4;

    private int currentItem = 1;

    private MenuNavigator menuNavigator;
    private Activity activity;

    public MenuDrawerImpl(MenuNavigator menuNavigator) {
        this.menuNavigator = menuNavigator;
    }

    @Override
    public void createNavigationDrawer(final Activity activity) {
        this.activity = activity;
        new DrawerBuilder().withActivity(activity).build();
        createMenu();
    }

    private void createMenu() {

        PrimaryDrawerItem pokemonItem = new PrimaryDrawerItem().withIdentifier(POKEMON_MENU_ID).withName(R.string.menu_label_pokemons);
        PrimaryDrawerItem memberItem = new PrimaryDrawerItem().withIdentifier(MEMBERS_MENU_ID).withName(R.string.menu_label_members);
        PrimaryDrawerItem exchangeItem = new PrimaryDrawerItem().withIdentifier(EXCHANGE_MENU_ID).withName(R.string.menu_label_exchange);
        PrimaryDrawerItem userPokemonsItem = new PrimaryDrawerItem().withIdentifier(USER_POKEMONS_MENU_ID).withName(R.string.menu_label_user_pokemons);


        final Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withAccountHeader(createAccountHeader())
                .addDrawerItems(
                        userPokemonsItem,
                        pokemonItem,
                        memberItem,
                        exchangeItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        selectedItem(position);
                        return false;
                    }
                })
                .withSelectedItem(currentItem)
                .build();
    }

    private void selectedItem(int position) {
        switch (position) {
            case POKEMON_MENU_ID :
                if (currentItem != USER_POKEMONS_MENU_ID) {
                    menuNavigator.launchPokemonActivity(activity, false);
                } else {
                    menuNavigator.changeList(activity, false);
                }
                currentItem = POKEMON_MENU_ID;
                break;

            case USER_POKEMONS_MENU_ID :
                if (currentItem != POKEMON_MENU_ID) {
                    menuNavigator.launchPokemonActivity(activity, true);
                } else {
                    menuNavigator.changeList(activity, true);
                }
                currentItem = POKEMON_MENU_ID;
                break;


            case MEMBERS_MENU_ID :
                menuNavigator.launchMembersActivity(activity);
                currentItem = MEMBERS_MENU_ID;
                break;

            default:
                break;
        }
    }
    private AccountHeader createAccountHeader() {
        return new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.color.colorPrimary)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com")//.withIcon(activity().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
    }
}
