package com.freedom.lauzy.ticktockmusic.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.freedom.lauzy.ticktockmusic.R;
import com.freedom.lauzy.ticktockmusic.ui.SettingActivity;
import com.freedom.lauzy.ticktockmusic.ui.activity.SongListActivity;
import com.freedom.lauzy.ticktockmusic.ui.fragment.SongListFragment;

import javax.inject.Inject;

/**
 * Desc : Class used to navigate through the application.
 * Author : Lauzy
 * Date : 2017/7/5
 * Blog : http://www.jianshu.com/u/e76853f863a9
 * Email : freedompaladin@gmail.com
 */
public class Navigator {

    @Inject
    public Navigator() {
    }

    /**
     * Goes to SettingActivity.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToSetting(Context context) {
        if (context != null) {
            Intent intent = SettingActivity.newInstance(context);
            context.startActivity(intent);
        }
    }

   /* public static void navigateToSongList(Context context, int type, String title) {
        if (context != null) {
            Intent intent = SongListActivity.newInstance(context, type, title);
            context.startActivity(intent);
        }
    }*/

    public static void navigateToSongList(Activity context, int type, String title) {
        FragmentTransaction transaction = ((AppCompatActivity) context)
                .getSupportFragmentManager().beginTransaction();
        Fragment fragment = SongListFragment.newInstance(type, title);
        transaction.hide(((AppCompatActivity) context)
                .getSupportFragmentManager()
                .findFragmentById(R.id.layout_main));
        transaction.add(R.id.layout_main, fragment);
        transaction.addToBackStack(null).commit();
    }
}
