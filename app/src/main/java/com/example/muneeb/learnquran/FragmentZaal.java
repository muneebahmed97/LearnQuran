package com.example.muneeb.learnquran;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentZaal extends Fragment {

    Button btnPlay, btnNext, btnPrevious;

    ImageView ivZaal;

    public FragmentZaal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zaal, container, false);

        btnPlay = (Button) view.findViewById(R.id.btn_play);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnPrevious = (Button) view.findViewById(R.id.btn_previous);

        ivZaal =(ImageView) view.findViewById(R.id.iv_zaal);

        ivZaal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle("Pronunciation");
                alertDialog.setMessage("Said by touching the end of the two upper front tooth with the tip of the tongue." +
                        "\n" +
                        "\n" +
                        "Zuban Ki Nok Jab Ooper K Saamnay Waalay 2 Daanton K Aakhir Waalay Hissay Sey Lagay.");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                alertDialog.show();
            }
        });

        final MediaPlayer zaalSound = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.zaal);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zaalSound.start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new FragmentRaa());
                transaction.commit();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new FragmentDaal());
                transaction.commit();
            }
        });

        return view;
    }

}
