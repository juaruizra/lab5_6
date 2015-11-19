package com.example.juancho.lab5;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.ListFragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/*//donde dialogo personalizado era la clase dialogfragment
            //   new DialogoPersonalizado().show(getFragmentManager(), "DialogoPersonalizado");
                    Toast toast2 = new Toast(getActivity());
                    LayoutInflater inflater = LayoutInflater.from(getActivity());
                    View layout = inflater.inflate(R.layout.teatro1_toast,(ViewGroup) view.findViewById(R.id.lytLayout));

                    toast2.setDuration(Toast.LENGTH_SHORT);
                    toast2.setView(layout);
                    toast2.show();*/

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_teatro extends ListFragment  {


    public Fragment_teatro() {
        // Required empty public constructor
    }
View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.fragment_teatro, container, false);

        return view;
    }

    // Array de String que contiene nuestros queridos Sistemas Operativos
    private String[] sistemas = { "Pablo Tobon Uribe", "Metropolitano", "Prado el Aguila Descalza " };

  /*  Teatro pablo tobon uribe    CL52 Al #51-24        6.2475317,-75.5616541
    Teatro Metropolitano         Calle 41#57 - 30     6.2432169,-75.5797098
    Teatro Prado el Aguila Descalza  Cra. 45d#59-1    6.2546883,-75.5628707
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // Establecemos el Adapter a la Lista del Fragment
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, sistemas));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);


        if(position==0){
             AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.dialog_teatro1, null))
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
             builder.create();
                 builder.show();
            }
        if(position==1){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.dialog_teatro2, null))
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            builder.create();
            builder.show();
        }

        if(position==2){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.dialog_teatro3, null))
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            builder.create();
            builder.show();

                }

         }



    }

