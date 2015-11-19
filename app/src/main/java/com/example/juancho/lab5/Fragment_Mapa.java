package com.example.juancho.lab5;


import android.*;
import android.content.Context;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Mapa extends android.support.v4.app.Fragment{// android.support.v4.app.Fragment

    MapView mMapView;
    private GoogleMap googleMap;



    LatLng Dir_ini=new LatLng(6.2432169,-75.5797098);
    //coordenadas cines
    private static final LatLng Dir_Cine1= new LatLng(6.2300436,-75.5705263);//royal
    private static final LatLng Dir_Cine2 = new LatLng(6.2706695,-75.579648);//procinal
    private static final LatLng Dir_Cine3 = new LatLng(6.2331753,-75.6063687);//cinecol
    //coordenadas restaurantes
    private static final LatLng Dir_food1 = new LatLng(6.2039997,-75.5808666);//la provincia
    private static final LatLng Dir_food2 = new LatLng(6.269091,-75.5655581);// bosque plaza
    private static final LatLng Dir_food3 = new LatLng(6.2464283,-75.5999661);//Tacuate
    //coordenadas bares
    private static final LatLng Dir_teatro1 = new LatLng(6.2475317,-75.5616541);//Teatro pablo tobon uribe
    private static final LatLng Dir_teatro2 = new LatLng(6.2432169,-75.5797098);// Teatro Metropolitano
    private static final LatLng Dir_teatro3 = new LatLng(6.2546883,-75.5628707);//Teatro Prado el Aguila Descalza
    //coordenadas teatros
    private static final LatLng Dir_bar1 = new LatLng(6.2393905,-75.5857378);//Fonda la vecindad del chavo
    private static final LatLng Dir_bar2 = new LatLng(6.2515759,-75.5881851);// Discoteca A pico de Botella
    private static final LatLng Dir_bar3 = new LatLng(6.2169314,-75.5937679);//Discoteca Barlovento
    //coordenadas teatros
    private static final LatLng Dir_lugar1 = new LatLng(6.2362646,-75.5825887);//Pueblito Paisa
    private static final LatLng Dir_lugar2 = new LatLng(6.2567578,-75.5923263);// Unidad Deportiva Atanasio Girardot
    private static final LatLng Dir_lugar3 = new LatLng(6.2520025,-75.5706418);//Plaza Botero


    MarkerOptions marker_cine1,marker_cine2,marker_cine3;
    MarkerOptions marker_food1,marker_food2,marker_food3;
    MarkerOptions marker_teatro1,marker_teatro2,marker_teatro3;
    MarkerOptions marker_bar1,marker_bar2,marker_bar3;
    MarkerOptions marker_lugar1,marker_lugar2,marker_lugar3;



    CheckBox Bt_cine,Bt_teatro,Bt_bare,Bt_restaurante,Bt_ambiente;

    /* private static final LatLng MELBOURNE = new LatLng(-37.813, 144.962);
  private Marker melbourne = mMap.addMarker(new MarkerOptions()
                            .position(MELBOURNE)
                            .title("Melbourne")
                            .snippet("Population: 4,137,400")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow)));*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View v = inflater.inflate(R.layout.fragment_mapa, container,false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();//visualizar mapa
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionCheck2 = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION);

        if(googleMap!=null){googleMap.setMyLocationEnabled(true);
       // double latitude=googleMap.getMyLocation().getLatitude();
       // double longitude=googleMap.getMyLocation().getLongitude();
        //Dir_ini = new LatLng(latitude, longitude);//mi ubicacion
    }
       //Seteamos el tipo de mapa
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.getUiSettings().setZoomControlsEnabled(false); // habilitar boton de zoom
        googleMap.getUiSettings().setCompassEnabled(true);       //habilitar boton de inclinacion
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);// habilitar boton de localizacion
       /* MAP_TYPE_HYBRID : Mapa satelital con una capa transparente de las principales calles.
          MAP_TYPE_NONE : Mapa sin capas.
          MAP_TYPE_NORMAL : Mapa Normal o básico.
          MAP_TYPE_SATELLITE : Mapa satelital sin etiquetas ni capas adicionales.
          MAP_TYPE_TERRAIN : Mapa de terreno.*/

         //Activamos la capa o layer MyLocation
         //centrar la camara
        CameraPosition cameraPosition = new CameraPosition.Builder().target(Dir_ini).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        //---------------------------------------
        // Enabling MyLocation Layer of Google Map
    /*    googleMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            Context.onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
       */
      //--------------------------------------

        //establecer marcas en el mapa
        Ini_marker();

        //Referencias a los checkbutton
         Bt_cine=(CheckBox)v.findViewById(R.id.Chkcine);
         Bt_teatro=(CheckBox)v.findViewById(R.id.Chkteatro);
         Bt_bare=(CheckBox)v.findViewById(R.id.Chkbares);
         Bt_restaurante=(CheckBox)v.findViewById(R.id.Chkrestaurantes);
         Bt_ambiente=(CheckBox)v.findViewById(R.id.Chkambiente);
        //deteccion de los checkbutton
        Sel_checkedMARK();

     // Agregar un circulo en una coordenada
     /*   CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(latitude, longitude))   //set center
                .radius(100)   //set radius in meters
                .fillColor(Color.RED)
                .fillColor(0x40ff0000)  //semi-transparent
                .strokeColor(Color.BLACK)
                .strokeWidth(5);

        googleMap.addCircle(circleOptions);*/
        // Perform any camera updates here
        return v;
    }

    //-----------------
    // funciones personalizacion
   // addMarker(map, 40.748963847316034, -73.96807193756104,R.string.un, R.string.united_nations);
/*
    private void addMarker(GoogleMap map, double lat, double lon,int title, int snippet) {
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon))
                .title(getString(title))
                .snippet(getString(snippet)));}*/
private void Sel_checkedMARK(){
    Bt_cine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {  //Toast.makeText(getActivity(),"chequado",Toast.LENGTH_SHORT).show();
                marker_cine1.visible(true);
                marker_cine2.visible(true);
                marker_cine3.visible(true);
                //   Bt_cine.setBackgroundColor(Color.GRAY );
            } else {
                //Toast.makeText(getActivity(),"no cheuqeado",Toast.LENGTH_SHORT).show();
                marker_cine1.visible(false);
                marker_cine2.visible(false);
                marker_cine3.visible(false);
                Bt_cine.setBackgroundColor(Color.WHITE);
                googleMap.clear();
            }
            addmarker();
        }
    });

    Bt_restaurante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {  //Toast.makeText(getActivity(),"chequado",Toast.LENGTH_SHORT).show();
                marker_food1.visible(true);
                marker_food2.visible(true);
                marker_food3.visible(true);
                //   Bt_restaurante.setBackgroundColor(Color.MAGENTA);
            }
            else{
                //Toast.makeText(getActivity(),"no cheuqeado",Toast.LENGTH_SHORT).show();
                marker_food1.visible(false);
                marker_food2.visible(false);
                marker_food3.visible(false);
                Bt_restaurante.setBackgroundColor(Color.WHITE);
                googleMap.clear();
            }
            addmarker();
        }
    });
    Bt_teatro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {  //Toast.makeText(getActivity(),"chequado",Toast.LENGTH_SHORT).show();
                marker_teatro1.visible(true);
                marker_teatro2.visible(true);
                marker_teatro3.visible(true);
                //    Bt_teatro.setBackgroundColor(Color.parseColor("#ffa500") );//naranja
            }
            else{
                //Toast.makeText(getActivity(),"no cheuqeado",Toast.LENGTH_SHORT).show();
                marker_teatro1.visible(false);
                marker_teatro2.visible(false);
                marker_teatro3.visible(false);
                Bt_teatro.setBackgroundColor(Color.WHITE);
                googleMap.clear();
            }
            addmarker();
        }
    });
    Bt_bare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {  //Toast.makeText(getActivity(),"chequado",Toast.LENGTH_SHORT).show();
                marker_bar1.visible(true);
                marker_bar2.visible(true);
                marker_bar3.visible(true);
               // Bt_bare.setBackgroundColor(Color.YELLOW);
            }
            else{
                //Toast.makeText(getActivity(),"no cheuqeado",Toast.LENGTH_SHORT).show();
                marker_bar1.visible(false);
                marker_bar2.visible(false);
                marker_bar3.visible(false);
                Bt_bare.setBackgroundColor(Color.WHITE);
                googleMap.clear();
            }
            addmarker();
        }
    });
    Bt_ambiente.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {  //Toast.makeText(getActivity(),"chequado",Toast.LENGTH_SHORT).show();
                marker_lugar1.visible(true);
                marker_lugar2.visible(true);
                marker_lugar3.visible(true);
               // Bt_ambiente.setBackgroundColor(Color.GREEN);//naranja
            }
            else{
                //Toast.makeText(getActivity(),"no cheuqeado",Toast.LENGTH_SHORT).show();
                marker_lugar1.visible(false);
                marker_lugar2.visible(false);
                marker_lugar3.visible(false);
                Bt_ambiente.setBackgroundColor(Color.TRANSPARENT);
                googleMap.clear();
            }
            addmarker();
        }
    });

}

  private  void addmarker(){

      googleMap.addMarker(marker_cine1);
      googleMap.addMarker(marker_cine2);
      googleMap.addMarker(marker_cine3);
      googleMap.addMarker(marker_food1);
      googleMap.addMarker(marker_food2);
      googleMap.addMarker(marker_food3);
      googleMap.addMarker(marker_teatro1);
      googleMap.addMarker(marker_teatro2);
      googleMap.addMarker(marker_teatro3);
      googleMap.addMarker(marker_bar1);
      googleMap.addMarker(marker_bar2);
      googleMap.addMarker(marker_bar3);
      googleMap.addMarker(marker_lugar1);
      googleMap.addMarker(marker_lugar2);
      googleMap.addMarker(marker_lugar3);



}

    private void Ini_marker(){
        // MARKERS CINE
        marker_cine1 = new MarkerOptions().position(Dir_Cine1).title("Royal Films").snippet("Av.43A con calle 30").flat(false).alpha(0.9f);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
       // marker_cine1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        marker_cine1.icon(BitmapDescriptorFactory.fromResource(R.drawable.cine));
        marker_cine1.visible(false);
        googleMap.addMarker(marker_cine1);

        marker_cine2 = new MarkerOptions().position(Dir_Cine2).title("Cinemas Procinal").snippet("Cl.71#65-150").flat(false).alpha(0.9f);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        // marker_cine1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        marker_cine2.icon(BitmapDescriptorFactory.fromResource(R.drawable.cine));
        marker_cine2.visible(false);
        googleMap.addMarker(marker_cine2);

        marker_cine3 = new MarkerOptions().position(Dir_Cine3).title("Cine Colombia").snippet("K.82#30A-24").flat(false).alpha(0.9f);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        // marker_cine1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        marker_cine3.icon(BitmapDescriptorFactory.fromResource(R.drawable.cine));
        marker_cine3.visible(false);
        googleMap.addMarker(marker_cine3);

        // MARKERS RESTAURANTES
        marker_food1 = new MarkerOptions().position(Dir_food1).title("Restaurante La Provincia").snippet("Cl.4sur#43A-179").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        //marker_food1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        marker_food1.icon(BitmapDescriptorFactory.fromResource(R.drawable.food));
        marker_food1.visible(false);
        googleMap.addMarker(marker_food1);

        marker_food2 = new MarkerOptions().position(Dir_food2).title("Comidas El Corral").snippet("Cl.73#51-71").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        //marker_food1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        marker_food2.icon(BitmapDescriptorFactory.fromResource(R.drawable.food));
        marker_food2.visible(false);
        googleMap.addMarker(marker_food2);

        marker_food3 = new MarkerOptions().position(Dir_food3).title("Restaurante Tacuate").snippet("Transversal 39N°76-52").flat(false).alpha(0.9f);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        //marker_food1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        marker_food3.icon(BitmapDescriptorFactory.fromResource(R.drawable.food));
        marker_food3.visible(false);
        googleMap.addMarker(marker_food3);

        // MARKERS TEATROS
        marker_teatro1 = new MarkerOptions().position(Dir_teatro1).title("Teatro pablo tobon uribe ").snippet("CL52 Al #51-24").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
       // marker_teatro1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        marker_teatro1.icon(BitmapDescriptorFactory.fromResource(R.drawable.teatro2));
        marker_teatro1.visible(false);
        googleMap.addMarker(marker_teatro1);

        marker_teatro2 = new MarkerOptions().position(Dir_teatro2).title("Teatro Metropolitano").snippet("CL.41#57-30").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        // marker_teatro1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        marker_teatro2.icon(BitmapDescriptorFactory.fromResource(R.drawable.teatro2));
        marker_teatro2.visible(false);
        googleMap.addMarker(marker_teatro2);

        marker_teatro3 = new MarkerOptions().position(Dir_teatro3).title("Teatro Prado el Aguila Descalza").snippet("Cra.45d#59-1").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        // marker_teatro1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        marker_teatro3.icon(BitmapDescriptorFactory.fromResource(R.drawable.teatro2));
        marker_teatro3.visible(false);
        googleMap.addMarker(marker_teatro3);

        // MARKERS BARES
        marker_bar1 = new MarkerOptions().position(Dir_bar1).title("Fonda la Vecindad del Chavo").snippet("Av.33#65C-60").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        //marker_bar1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        marker_bar1.icon(BitmapDescriptorFactory.fromResource(R.drawable.beergarden));

        marker_bar1.visible(false);
        googleMap.addMarker(marker_bar1);

        marker_bar2 = new MarkerOptions().position(Dir_bar2).title("Discoteca A pico de Botella").snippet("Cra.70#45-77").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        //marker_bar1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        marker_bar2.icon(BitmapDescriptorFactory.fromResource(R.drawable.beergarden));
        marker_bar2.visible(false);
        googleMap.addMarker(marker_bar2);

        marker_bar3 = new MarkerOptions().position(Dir_bar3).title("Discoteca Barlovento").snippet("Cra.42 #9-59").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        //marker_bar1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        marker_bar3.icon(BitmapDescriptorFactory.fromResource(R.drawable.beergarden));
        marker_bar3.visible(false);
        googleMap.addMarker(marker_bar3);

        // MARKERS Lugares
        marker_lugar1 = new MarkerOptions().position(Dir_lugar1).title("Pueblito Paisa").snippet("Cl.30A#55-64").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        //marker_lugar1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        marker_lugar1.icon(BitmapDescriptorFactory.fromResource(R.drawable.ambiente));
        marker_lugar1.visible(false);
        googleMap.addMarker(marker_lugar1);

        marker_lugar2 = new MarkerOptions().position(Dir_lugar2).title("Unidad Deportiva Atanasio Girardot").snippet("Cl.48#73–10").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        //marker_lugar1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        marker_lugar2.icon(BitmapDescriptorFactory.fromResource(R.drawable.ambiente));
        marker_lugar2.visible(false);
        googleMap.addMarker(marker_lugar2);

        marker_lugar3 = new MarkerOptions().position(Dir_lugar3).title("Plaza Botero").snippet("Cra.52 con Cl.52").alpha(0.9f).flat(false);//.alpha(0.7f) es para la opacidad entre 0 y 1, 0 es transparente
        marker_lugar3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        //marker_lugar1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        marker_lugar3.icon(BitmapDescriptorFactory.fromResource(R.drawable.ambiente));
        marker_lugar3.visible(false);
        googleMap.addMarker(marker_lugar3);



    }


}



