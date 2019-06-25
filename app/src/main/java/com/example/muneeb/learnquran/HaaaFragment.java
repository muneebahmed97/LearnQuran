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


/**
 * A simple {@link Fragment} subclass.
 */
public class HaaaFragment extends Fragment {


    public HaaaFragment() {
        // Required empty public constructor
    }

    Button btnPlay, btnNext, btnPrevious;

    ImageView ivHaaa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_haaa, container, false);

        btnPlay = (Button) view.findViewById(R.id.btn_play);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnPrevious = (Button) view.findViewById(R.id.btn_previous);

        ivHaaa = (ImageView) view.findViewById(R.id.iv_haaaa);

        ivHaaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle("Pronunciation");
                alertDialog.setMessage("Said by the end of the throat which is closer to chest." +
                        "\n" +
                        "\n" +
                        "Halaq K Aakhir Say, Jou Seenay K Qareeb Hay. ");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                alertDialog.show();
            }
        });

        final MediaPlayer haaaSound = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.haaa);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haaaSound.start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new YaaFragment());
                transaction.commit();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fl_fragmentContainer, new WaowFragment());
                transaction.commit();
            }
        });

        return view;
    }
}
