package com.example.passwordmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    ArrayList<PasswordModel> arrayList;
    MainActivity mainActivity;

    public Adapter(ArrayList<PasswordModel> arrayList, MainActivity mainActivity) {
        this.arrayList = arrayList;
        this.mainActivity = mainActivity;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView pass,name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.pass=itemView.findViewById(R.id.item_pass);
            this.name=itemView.findViewById(R.id.item_name);


        }
    }


    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {

        PasswordModel passwordModel = arrayList.get(position);
        holder.name.setText(passwordModel.getName());
        holder.pass.setText(passwordModel.getPass());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
