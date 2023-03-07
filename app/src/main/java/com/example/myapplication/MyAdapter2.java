package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private Context context;
    private ArrayList tree_name, tree_height, user_name, trunk_color, trunk_diameter,
    leaf_color,leaf_shape,env_nation, env_region, hs_has_seeds_bool;

    public MyAdapter2(Context context, ArrayList tree_name, ArrayList tree_height, ArrayList user_name,
                      ArrayList trunk_color, ArrayList trunk_diameter, ArrayList leaf_color, ArrayList leaf_shape,
                      ArrayList env_nation, ArrayList env_region, ArrayList hs_has_seeds_bool) {
        this.context = context;
        this.tree_name = tree_name;
        this.tree_height = tree_height;
        this.user_name = user_name;
        this.trunk_color = trunk_color;
        this.trunk_diameter = trunk_diameter;
        this.leaf_color = leaf_color;
        this.leaf_shape = leaf_shape;
        this.env_nation = env_nation;
        this.env_region = env_region;
        this.hs_has_seeds_bool = hs_has_seeds_bool;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ///////////////////////////////////////////
        View v = LayoutInflater.from(context).inflate(R.layout.tree_entry,parent,false);
        ///////////////////////////////////////////
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tree_name.setText(String.valueOf(tree_name.get(position)));
        holder.tree_height.setText(String.valueOf(tree_height.get(position)));
        holder.user_name.setText(String.valueOf(user_name.get(position)));
        holder.trunk_color.setText(String.valueOf(trunk_color.get(position)));
        holder.trunk_diameter.setText(String.valueOf(trunk_diameter.get(position)));

        holder.leaf_color.setText(String.valueOf(leaf_color.get(position)));
        holder.leaf_shape.setText(String.valueOf(leaf_shape.get(position)));
        holder.env_nation.setText(String.valueOf(env_nation.get(position)));
        holder.env_region.setText(String.valueOf(env_region.get(position)));
        holder.hs_has_seeds_bool.setText(String.valueOf(hs_has_seeds_bool.get(position)));
    }

    @Override
    public int getItemCount() {
        return tree_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tree_name, tree_height, user_name, trunk_color,trunk_diameter,
                leaf_color,leaf_shape,env_nation, env_region, hs_has_seeds_bool;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tree_name = itemView.findViewById(R.id.text_tree_name);
            tree_height = itemView.findViewById(R.id.text_tree_height);
            user_name = itemView.findViewById(R.id.text_user);
            trunk_color = itemView.findViewById(R.id.text_trunk_color);
            trunk_diameter = itemView.findViewById(R.id.text_trunk_diameter);

            leaf_color = itemView.findViewById(R.id.text_leaf_color);
            leaf_shape = itemView.findViewById(R.id.text_leaf_shape);
            env_nation = itemView.findViewById(R.id.text_env_nation);
            env_region = itemView.findViewById(R.id.text_env_region);
            hs_has_seeds_bool = itemView.findViewById(R.id.text_hs_has_seeds_bool);
        }
    }
}
