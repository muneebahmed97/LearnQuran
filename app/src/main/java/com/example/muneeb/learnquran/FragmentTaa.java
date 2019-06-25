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

public class FragmentTaa extends Fragment {

    Button btnPlay, btnNext, btnPrevious;

    ImageView ivTaa;

    public FragmentTaa() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_taa, container, false);

        ivTaa = (ImageView) view.findViewById(R.id.iv_taa);

        btnPlay = (Button) view.findViewById(R.id.btn_play);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnPrevious = (Button) view.findViewById(R.id.btn_previous);

        final MediaPlayer taaSound = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.taa);

        ivTaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle("Pronunciation");
                alertDialog.setMessage("Said by touching the mid of the two upper front tooth with the tip of the tongue." +
                        "\n" +
                        "\n" +
                        "Zuban Ki Nok Jab Ooper K Saamnay Waalay 2 Daanton K Darmiyan Waalay Hissay Sey Lagay. ");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                alertDialog.show();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taaSound.start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new FragmentSaa());
                transaction.commit();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new FragmentBay());
                transaction.commit();
            }
        });

        return view;
    }

}
