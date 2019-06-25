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

public class FragmentKhaa extends Fragment {

    Button btnPlay, btnNext, btnPrevious;

    ImageView ivKhaa;

    public FragmentKhaa() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_khaa, container, false);

        btnPlay = (Button) view.findViewById(R.id.btn_play);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnPrevious = (Button) view.findViewById(R.id.btn_previous);

        ivKhaa = (ImageView) view.findViewById(R.id.iv_khaa);

        ivKhaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle("Pronunciation");
                alertDialog.setMessage("From the start of the throat from the mouth." +
                        "\n" +
                        "\n" +
                        "Halaq k shuru sey, jou munh ki taraf hay. ");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                alertDialog.show();
            }
        });

        final MediaPlayer soundKhaa = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.khaa);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundKhaa.start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new FragmentDaal());
                transaction.commit();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new FragmentHaa());
                transaction.commit();
            }
        });

        return view;
    }
}
