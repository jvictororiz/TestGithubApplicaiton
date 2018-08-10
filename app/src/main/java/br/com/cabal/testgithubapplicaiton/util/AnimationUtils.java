package br.com.cabal.testgithubapplicaiton.util;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;

import br.com.cabal.testgithubapplicaiton.R;

public class AnimationUtils {

    public static void configAnimatinoRecyclerView(Context context, RecyclerView recyclerView) {
        final LayoutAnimationController controller = android.view.animation.AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        recyclerView.setLayoutAnimation(controller);
    }

    public static void setToVisible(ViewGroup header, View view) {
        view.setVisibility(View.INVISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(header);
        }
        view.setVisibility(View.VISIBLE);
    }

    public static void setToInvisible(ViewGroup viewGroup, View view) {
        view.setVisibility(View.INVISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(viewGroup);
        }
        view.setVisibility(View.GONE);
    }
}
