package com.example.myportfolioapp.team;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myportfolioapp.R;

import java.util.ArrayList;
import java.util.List;

public class TeamFragment extends Fragment {


    RecyclerView RvTeam;
    TeamAdapter adapter;
    List<TeamItem> mdata;

    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RvTeam = view.findViewById(R.id.rv_team);

        // create list of team items

        TeamItem item = new TeamItem("Bsc(hons) Information Technology and Business Information Systems \nMiddlesex University - 2024 \nIT and Business | 1st Class",getString(R.string.middlesex_university_text),R.drawable.middlesex_university);
        TeamItem item2 = new TeamItem("Advanced Diploma in Software Engineering \nAptech Education - 2023 \nSoftware Engineering | Distinction",getString(R.string.aptech_text),R.drawable.aptech_education);
        TeamItem item3 = new TeamItem("A level \nChrisland High School Abuja - 2022 \nDistinction",getString(R.string.lorem_text2),R.drawable.chrisland_high);

        mdata = new ArrayList<>();
        mdata.add(item);
        mdata.add(item2);
        mdata.add(item3);

        // setup adapter and recyclerview

        RvTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TeamAdapter(mdata);
        RvTeam.setAdapter(adapter);


    }
}