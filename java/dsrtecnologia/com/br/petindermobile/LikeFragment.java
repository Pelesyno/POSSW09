package dsrtecnologia.com.br.petindermobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class LikeFragment extends Fragment {
    public LikeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, container, false);

        String orientation = Orientacao.verificarOrientacao(this);

        if(orientation.equals("retrato")){
            view = inflater.inflate(R.layout.fragment_like, container, false);
        }else if(orientation.equals("paisagem")){
            view = inflater.inflate(R.layout.fragment_like_retrato, container, false);
        }

        Button b = view.findViewById(R.id.btnChat);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Chat Não Mamãe!!!!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
