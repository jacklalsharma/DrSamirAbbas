package com.dr.SamirAbbas.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.dr.SamirAbbas.activities.BaseActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Anurag on 4/13/2018.
 */
public class Doctors implements Parcelable {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("data")
    @Expose
    private Data data;
    public final static Parcelable.Creator<Doctors> CREATOR = new Creator<Doctors>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Doctors createFromParcel(Parcel in) {
            return new Doctors(in);
        }

        public Doctors[] newArray(int size) {
            return (new Doctors[size]);
        }

    }
            ;

    protected Doctors(Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public Doctors() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(type);
        dest.writeValue(text);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

    public static class Data implements Parcelable
    {

        @SerializedName("doctors")
        @Expose
        private List<Doctor> doctors = null;
        @SerializedName("paging")
        @Expose
        private Paging paging;
        public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            public Data[] newArray(int size) {
                return (new Data[size]);
            }

        }
                ;

        protected Data(Parcel in) {
            in.readList(this.doctors, (com.dr.SamirAbbas.models.Doctors.Doctor.class.getClassLoader()));
            this.paging = ((Paging) in.readValue((Paging.class.getClassLoader())));
        }

        public Data() {
        }

        public List<Doctor> getDoctors() {
            return doctors;
        }

        public void setDoctors(List<Doctor> doctors) {
            this.doctors = doctors;
        }

        public Paging getPaging() {
            return paging;
        }

        public void setPaging(Paging paging) {
            this.paging = paging;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(doctors);
            dest.writeValue(paging);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Doctor implements Parcelable
    {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("spe_id")
        @Expose
        private String speId;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("name_ar")
        @Expose
        private String name_ar;


        @SerializedName("degree")
        @Expose
        private String degree;
        @SerializedName("experience")
        @Expose
        private String experience;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("is_available_today")
        @Expose
        private Boolean isAvailableToday;
        @SerializedName("profile_picture_url")
        @Expose
        private String profilePictureUrl;
        public final static Parcelable.Creator<Doctor> CREATOR = new Creator<Doctor>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Doctor createFromParcel(Parcel in) {
                return new Doctor(in);
            }

            public Doctor[] newArray(int size) {
                return (new Doctor[size]);
            }

        }
                ;

        protected Doctor(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.speId = ((String) in.readValue((String.class.getClassLoader())));
            this.name = ((String) in.readValue((String.class.getClassLoader())));
            this.degree = ((String) in.readValue((String.class.getClassLoader())));
            this.experience = ((String) in.readValue((String.class.getClassLoader())));
            this.image = ((String) in.readValue((String.class.getClassLoader())));
            this.date = ((String) in.readValue((String.class.getClassLoader())));
            this.isAvailableToday = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            this.profilePictureUrl = ((String) in.readValue((String.class.getClassLoader())));
            this.name_ar = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Doctor() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSpeId() {
            return speId;
        }

        public void setSpeId(String speId) {
            this.speId = speId;
        }

        public String getName() {
            if(BaseActivity.IsEnglish == false && name_ar != null && name_ar.length() > 0){
                return name_ar;
            }
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getExperience() {
            return experience;
        }

        public void setExperience(String experience) {
            this.experience = experience;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Boolean getIsAvailableToday() {
            return isAvailableToday;
        }

        public void setIsAvailableToday(Boolean isAvailableToday) {
            this.isAvailableToday = isAvailableToday;
        }

        public String getProfilePictureUrl() {
            return profilePictureUrl;
        }

        public void setProfilePictureUrl(String profilePictureUrl) {
            this.profilePictureUrl = profilePictureUrl;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(speId);
            dest.writeValue(name);
            dest.writeValue(degree);
            dest.writeValue(experience);
            dest.writeValue(image);
            dest.writeValue(date);
            dest.writeValue(isAvailableToday);
            dest.writeValue(profilePictureUrl);
            dest.writeValue(name_ar);
        }

        public int describeContents() {
            return 0;
        }

        public String getName_ar() {
            return name_ar;
        }

        public void setName_ar(String name_ar) {
            this.name_ar = name_ar;
        }
    }

    public static class Paging implements Parcelable
    {

        @SerializedName("next_page_url")
        @Expose
        private String nextPageUrl;
        public final static Parcelable.Creator<Paging> CREATOR = new Creator<Paging>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Paging createFromParcel(Parcel in) {
                return new Paging(in);
            }

            public Paging[] newArray(int size) {
                return (new Paging[size]);
            }

        }
                ;

        protected Paging(Parcel in) {
            this.nextPageUrl = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Paging() {
        }

        public String getNextPageUrl() {
            return nextPageUrl;
        }

        public void setNextPageUrl(String nextPageUrl) {
            this.nextPageUrl = nextPageUrl;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(nextPageUrl);
        }

        public int describeContents() {
            return 0;
        }

    }

}