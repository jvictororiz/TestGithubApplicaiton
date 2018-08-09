package coopcerto.br.com.cabal.testgithubapplicaiton.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.animation.LayoutAnimationController;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;

public class AnimationUtils {

    public static void configAnimatinoRecyclerView(Context context, RecyclerView recyclerView) {
        final LayoutAnimationController controller = android.view.animation.AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        recyclerView.setLayoutAnimation(controller);
    }
}
