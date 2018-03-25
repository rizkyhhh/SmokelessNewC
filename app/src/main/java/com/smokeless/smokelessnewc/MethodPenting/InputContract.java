package com.smokeless.smokelessnewc.MethodPenting;

import android.provider.BaseColumns;

/**
 * Created by Asus A455L on 3/22/2018.
 */

public final class InputContract {

    private InputContract() {
    }

    public static final class inputEntry implements BaseColumns {

        public final static String TABLE_NAME = "input_harian";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_JUMLAH_ROKOK = "jumlah";

    }
}
