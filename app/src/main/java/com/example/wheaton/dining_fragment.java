package com.example.wheaton;
import android.content.Intent;
import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

import com.example.wheaton.Dining.BalfourActivity;

public class dining_fragment extends Fragment {

    // Declare view
    View root_view;

    // Empty Constructor
    public dining_fragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.dining, container, false);
        return root_view;
    }
    public void BalfourButton(View view){
        Intent i = new Intent(getActivity(), BalfourActivity.class);
        startActivity(i);
    }

}
