package Indexer.Utility;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    private List<Data> data = new ArrayList<>();

    public List<Data> getData() {

        return data;
    }

    public class Data{
        private String post_code;
        private String street;
        private String number;
        private String city;

        @Override
        public String toString() {
            return  city+ " " + street +" "+ number +" - "+ post_code ;
        }
    }
}
