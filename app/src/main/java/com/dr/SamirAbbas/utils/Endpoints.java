package com.dr.SamirAbbas.utils;

/**
 * Created by Anurag on 4/13/2018.
 */

public class Endpoints {
    public static final String BaseURL = "https://hospoital.000webhostapp.com/booking-apis/apis";

    public static final String SpecialityList = BaseURL + "/get_specializations";

    public static final String GetDoctors = BaseURL + "/get_doctors?specialization_id=%s&available_on=%s";

    public static final String AvailableSlot = BaseURL + "/get_doctor_schedule_slots?doctor_id=%s&date=%s";
}
