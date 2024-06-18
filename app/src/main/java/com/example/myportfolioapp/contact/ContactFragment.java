package com.example.myportfolioapp.contact;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.util.Linkify;
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

public class ContactFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_contact_fragment, container, false);
    }
}


//public class ContactFragment extends Fragment {
//
//    private RecyclerView contactRecyclerView;
//    private ContactAdapter contactAdapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_contact_fragment, container, false);
//
//        contactRecyclerView = view.findViewById(R.id.contactRecyclerView);
//        if (contactRecyclerView != null) {
//            contactRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//            String website = "https://iboweii.netlify.app/";
//            // Create a SpannableString from the original string
//            SpannableString spannableString = new SpannableString(website);
//            // Use Linkify to convert URLs into clickable links within the SpannableString
//            Linkify.addLinks(spannableString, Linkify.WEB_URLS);
//
//            List<ContactItem> contactDetails = new ArrayList<>();
//            contactDetails.add(new ContactItem(R.drawable.icons8_email_24, "email@example.com"));
//            contactDetails.add(new ContactItem(R.drawable.icons8_phone_24, "+1234567890"));
//            contactDetails.add(new ContactItem(R.drawable.baseline_location_on_24, "1234 Street, City, Country"));
//            contactDetails.add(new ContactItem(R.drawable.icons8_website_24, website));
//            contactDetails.add(new ContactItem(R.drawable.icons8_github_24, "github.com/username"));
//            contactDetails.add(new ContactItem(R.drawable.icons8_linkedin_30, "linkedin.com/in/username"));
//            contactDetails.add(new ContactItem(R.drawable.icons8_dribble_24, "dribbble.com/username"));
//
//            contactAdapter = new ContactAdapter(contactDetails);
//            contactRecyclerView.setAdapter(contactAdapter);
//
//        }
//        return view;
//    }
//}

