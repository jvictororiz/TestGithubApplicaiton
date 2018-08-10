package br.com.cabal.testgithubapplicaiton.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.Objects;

import br.com.cabal.testgithubapplicaiton.R;

public class SuperFragment extends Fragment {
    public static SuperFragment newInstance() {
        Bundle args = new Bundle();

        SuperFragment fragment = new SuperFragment();
        fragment.setArguments(args);
        return fragment;
    }
    void startActivityAnim(Intent intent) {
        startActivity(intent);
        Objects.requireNonNull(getActivity()).overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }
}
