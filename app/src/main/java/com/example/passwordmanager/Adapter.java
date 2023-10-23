package com.example.passwordmanager;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        ImageButton show;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.pass=itemView.findViewById(R.id.item_pass);
            this.name=itemView.findViewById(R.id.item_name);
            this.show=itemView.findViewById(R.id.see_password);


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
        holder.name.setText("Name :- "+passwordModel.getName());
        holder.pass.setText("Password :- "+"*********");
        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(mainActivity);
                dialog.setContentView(R.layout.dialog_box);
                EditText check_pass= dialog.findViewById(R.id.equal_pass);
                Button button = dialog.findViewById(R.id.submit);
                Button button1 = dialog.findViewById(R.id.cancel);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String given_pass=check_pass.getText().toString();
                        if(given_pass.equals(PasswordModel.getPas()))
                        {
                            holder.pass.setText("Password :- "+passwordModel.getPass());

                        }
                        else
                        {
                            Toast.makeText(mainActivity, "  wrong password", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();


                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
