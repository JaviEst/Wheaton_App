package com.example.wheaton;
import android.content.Intent;
import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

import com.example.wheaton.Dining.BalfourActivity;

public class dining_fragment extends Fragment {

    View root_view;
    public dining_fragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.dining, container, false);

        Button Balfour = root_view.findViewById(R.id.BalfourButton);
        Balfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bal = new Intent(getContext(), BalfourActivity.class);
                try{
                    startActivity(bal);
                }catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        return root_view;
    }

}
