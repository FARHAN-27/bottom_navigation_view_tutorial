package com.example.bottom_navigation_view_tutorial;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessageRecyclerViewAdapter extends RecyclerView.Adapter<MessageRecyclerViewAdapter.ViewHolder> {

    String current_user ;

    List<Messege> messageList = new ArrayList<>() ;
    Context context  ;

    public MessageRecyclerViewAdapter(Context context , List<Messege> messageList, String current_user) {
        this.messageList = messageList ;
        this.context = context;
        this.current_user = current_user ;
    }

    @NonNull
    @Override
    public MessageRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message, parent , false ) ;
        ViewHolder viewHolder = new ViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageRecyclerViewAdapter.ViewHolder holder, int position) {
        Messege messege = messageList.get(position) ;

        holder.senderOrReceiverNameTxtView.setText(messege.getSender()) ;
        holder.messageTxtView.setText(messege.getMessage());
        holder.messegeBoxId.setBackgroundColor( Color.rgb(0, 200, 100));

        if(messege.getSender().equals(current_user))
        {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMarginStart(600);

            holder.messegeBoxId.setLayoutParams(layoutParams);
            holder.messegeBoxId.setBackgroundColor( Color.rgb(148, 0, 211));
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  senderOrReceiverNameTxtView , messageTxtView ;
        LinearLayout messegeBoxId ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            senderOrReceiverNameTxtView = itemView.findViewById(R.id.senderOrReceiverNameTxtView) ;
            messageTxtView = itemView.findViewById(R.id.messageTxtView) ;
            messegeBoxId = itemView.findViewById(R.id.messegeBoxId) ;

        }
    }
}
