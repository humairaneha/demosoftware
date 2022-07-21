package com.app.cardiolog.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.cardiolog.Models.Cardiolog;
import com.app.cardiolog.Models.DialogFragment;
import com.app.cardiolog.Models.Updatefragment;
import com.app.cardiolog.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CardiologAdapter extends RecyclerView.Adapter<CardiologAdapter.viewHolder>{


    Context context;
    Updatefragment updatefragment;
    ArrayList log_id,sys,dia,bpm,date,time,comment;
    public AdapterView.OnItemClickListener listener;

    public CardiologAdapter(Context context,
                     ArrayList log_id,
                     ArrayList sys,
                     ArrayList dia,
                     ArrayList bpm,
                     ArrayList date,
                     ArrayList time,
                     ArrayList comment){
        this.context=context;
        this.log_id=log_id;
        this.dia=dia;
        this.time=time;
        this.bpm=bpm;
        this.sys=sys;
        this.comment=comment;
        this.date=date;
    }





    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_log,parent,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {


        //this.position=position;
        holder.mdate.setText(String.valueOf(date.get(position))+" "+String.valueOf(time.get(position)));

        int sysval=Integer.parseInt(String.valueOf(sys.get(position)));
        int diaval=Integer.parseInt(String.valueOf(dia.get(position)));
        holder.msys.setText(String.valueOf(sys.get(position)));
        holder.mdia.setText(String.valueOf(dia.get(position)));
        holder.mbpm.setText(String.valueOf(bpm.get(position)));
        holder.mcomment.setText(String.valueOf(comment.get(position)));
        if((sysval>=90 && sysval<140) && (diaval>=60 && diaval<=90 )){
            holder.mcomment.setBackgroundResource(R.drawable.greenbg);

        }
        else if((sysval>=140 && sysval<180) || (diaval>90 && diaval<120 )){
            // com="High Blood Pressure";
            holder.mcomment.setBackgroundResource(R.drawable.yellowbg);

        }
        else if(sysval>=180 || diaval>=120 ){
            //com="Hypertensive Crisis,Consult Doctor";
            holder.mcomment.setBackgroundResource(R.drawable.red_bg);


        }
        else if(sysval<90 || diaval<60){
            //com="Low Blood Pressure";
            holder.mcomment.setBackgroundResource(R.drawable.yellowbg);
        }



    }



    @Override
    public int getItemCount() {
        return log_id.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView mdate,msys,mdia,mbpm,mcomment,mtime;
        ImageButton medit,mdelete;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            mdate= itemView.findViewById(R.id.date);
            msys= itemView.findViewById(R.id.sys_m);
            mdia= itemView.findViewById(R.id.dia_m);
            mbpm= itemView.findViewById(R.id.bpm_m);
            mcomment= itemView.findViewById(R.id.comment_m);


        }
    }




}
