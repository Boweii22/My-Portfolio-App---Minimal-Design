package com.example.myportfolioapp.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myportfolioapp.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<ContactItem> contactDetails;

    public ContactAdapter(List<ContactItem> contactDetails) {
        this.contactDetails = contactDetails;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ContactItem contactDetail = contactDetails.get(position);
        holder.contactIcon.setImageResource(contactDetail.getIcon());
        holder.contactText.setText(contactDetail.getDetail());
    }

    @Override
    public int getItemCount() {
        return contactDetails.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView contactIcon;
        TextView contactText;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            contactIcon = itemView.findViewById(R.id.contactIcon);
            contactText = itemView.findViewById(R.id.contactText);
        }
    }
}

