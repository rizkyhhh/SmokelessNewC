package com.smokeless.smokelessnewc;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.smokeless.smokelessnewc.MethodPenting.DatabaseHelper;
import com.smokeless.smokelessnewc.MethodPenting.InputContract;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatFragment extends Fragment {

    private ListView listview;
    private TextView txt_tanggal;
    private String isiTable[] = new String[2];

    DatabaseHelper mDbHelper;

    public RiwayatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_riwayat, container, false);

        listview = (ListView)rootView.findViewById(R.id.riwayat_fragment);

        mDbHelper = new DatabaseHelper(getActivity());
        ArrayList<Riwayat> arrayWords = new ArrayList<>();



        return rootView;
    }
    private void displayDatabaseInfo(TextView txt) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                InputContract.inputEntry._ID,
                InputContract.inputEntry.COLUMN_JUMLAH_ROKOK
        };

        Cursor cursor = db.query(
                InputContract.inputEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        try {
            txt.setText("Rokok yang anda hisap" + cursor.getCount() + "\n\n");
            txt.append(
                    InputContract.inputEntry._ID + "-" +
                            InputContract.inputEntry.COLUMN_JUMLAH_ROKOK + "\n"
            );
            int idColumnIndex = cursor.getColumnIndex(InputContract.inputEntry._ID);
            int jumlahColumnIndex = cursor.getColumnIndex(InputContract.inputEntry.COLUMN_JUMLAH_ROKOK);
            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentJumlah = cursor.getString(jumlahColumnIndex);

                txt.append(("\n " + currentID + "-" +
                        currentJumlah
                ));
            }
        }finally{
                cursor.close();
            }
        }
    }


