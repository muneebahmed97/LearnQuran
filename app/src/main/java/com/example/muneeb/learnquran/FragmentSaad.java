package com.example.muneeb.learnquran;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FragmentSaad extends Fragment {

    Button btnPlay, btnNext, btnPrevious;

    ImageView ivSawd;

    public FragmentSaad() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saad, container, false);

        btnPlay = (Button) view.findViewById(R.id.btn_play);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnPrevious = (Button) view.findViewById(R.id.btn_previous);

        ivSawd = (ImageView) view.findViewById(R.id.iv_sawd);

        ivSawd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle("Pronunciation");
                alertDialog.setMessage("Said by touching the mid of the two upper front and two lower front tooth with the tip of the tongue." +
                        "\n" +
                        "\n" +
                        "Zuban Ki Nok Jab Ooper K Awr Neechay K Saamnay Waalay Daanton K Darmiyan Aajaaye. ");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                alertDialog.show();
            }
        });

        final MediaPlayer sawdSound = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.sawd);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sawdSound.start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new FragmentZawd());
                transaction.commit();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new FragmentSheen());
                transaction.commit();
            }
        });

        return view;
    }

}
