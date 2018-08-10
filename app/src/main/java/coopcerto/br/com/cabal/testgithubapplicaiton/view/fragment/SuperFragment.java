package coopcerto.br.com.cabal.testgithubapplicaiton.view.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;

public class SuperFragment extends Fragment {
    protected void startActivityAnim(Intent intent) {
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
}
