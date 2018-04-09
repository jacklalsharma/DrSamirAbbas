package com.dr.SamirAbbas.activities;

import android.content.Context;
import android.content.Intent;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import com.dr.SamirAbbas.R;

import java.util.ArrayList;

/**
 * Created by Anurag on 4/9/2018.
 */

public class FindAndBookAdapter extends RecyclerView.Adapter<FindAndBookAdapter.BookViewHolder>{

    private ArrayList<FindAndBook> list;
    private Context mContext;

    public FindAndBookAdapter(ArrayList<FindAndBook> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.find_and_book_list_item_layout, parent, false);
        BookViewHolder bookViewHolder = new BookViewHolder(view);

        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(final BookViewHolder holder, int position) {
        holder.docNameTextView.setText(list.get(position).getDocNameTextView());

            String firstWord = String.valueOf(holder.docNameTextView.getText().toString().charAt(0));

            holder.indexTextView.setText(firstWord);

        holder.forwardImageView.setImageResource(R.drawable.arrow_next);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView indexTextView, docNameTextView;
        private ImageView forwardImageView;

        public BookViewHolder(View itemView) {
            super(itemView);
            indexTextView = itemView.findViewById(R.id.indexTextView);
            docNameTextView = itemView.findViewById(R.id.docNameTextView);
            forwardImageView = itemView.findViewById(R.id.forwardImageView);

        }

        @Override
        public void onClick(View view) {
            if(view.getId() ==  R.id.forwardImageView) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AvailableDoctorsListActivity.class);
                intent.putExtra("category", String.valueOf(docNameTextView));
                context.startActivity(intent);
            }
        }
    }
}
