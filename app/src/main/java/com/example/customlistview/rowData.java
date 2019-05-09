package com.example.customlistview;

import android.os.Parcel;
import android.os.Parcelable;

public class rowData implements Parcelable {
    String title = "";
    Integer image = 0;
    String name = "";
    String phone = "";
    Integer cost = 0;
    String year = "", fuelEconomy = "", color = "", transmission = "", displacement = "", mileage = "", fuel = "", hasAccident = "";


    public rowData(String title,Integer image, String name, String phone, Integer cost, String year, String fuelEconomy, String color, String transmission, String displacement, String mileage, String fuel, String hasAccident){
        this.title = title;
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.cost = cost;
        this.year = year;
        this.fuelEconomy = fuelEconomy;
        this.color = color;
        this.transmission = transmission;
        this.displacement = displacement;
        this.mileage = mileage;
        this.fuel = fuel;
        this.hasAccident = hasAccident;
    }

    // Parcelling part
    public rowData(Parcel in){
        this.title = in.readString();
        this.image = in.readInt();
        this.name = in.readString();
        this.phone = in.readString();
        this.cost = in.readInt();
        this.year = in.readString();
        this.fuelEconomy = in.readString();
        this.color = in.readString();
        this.transmission = in.readString();
        this.displacement = in.readString();
        this.mileage = in.readString();
        this.fuel = in.readString();
        this.hasAccident = in.readString();
    }

    public static final Creator<rowData> CREATOR = new Creator<rowData>() {
        @Override
        public rowData createFromParcel(Parcel in) {
            return new rowData(in);
        }

        @Override
        public rowData[] newArray(int size) {
            return new rowData[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(title);
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeInt(cost);
        dest.writeString(year);
        dest.writeString(fuelEconomy);
        dest.writeString(color);
        dest.writeString(transmission);
        dest.writeString(displacement);
        dest.writeString(mileage);
        dest.writeString(fuel);
        dest.writeString(hasAccident);
    }

}
