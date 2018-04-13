package com.dr.SamirAbbas.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppointmentSlot implements Parcelable
{

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
    public final static Parcelable.Creator<AppointmentSlot> CREATOR = new Creator<AppointmentSlot>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AppointmentSlot createFromParcel(Parcel in) {
            return new AppointmentSlot(in);
        }

        public AppointmentSlot[] newArray(int size) {
            return (new AppointmentSlot[size]);
        }

    }
            ;

    protected AppointmentSlot(Parcel in) {
        this.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    public AppointmentSlot() {
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

        @SerializedName("slots")
        @Expose
        private Slots slots;
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
            this.slots = ((Slots) in.readValue((Slots.class.getClassLoader())));
        }

        public Data() {
        }

        public Slots getSlots() {
            return slots;
        }

        public void setSlots(Slots slots) {
            this.slots = slots;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(slots);
        }

        public int describeContents() {
            return 0;
        }

    }




    public static class Morning implements Parcelable
    {
        private boolean isSelected;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("schedule_id")
        @Expose
        private String scheduleId;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("intervals")
        @Expose
        private String intervals;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("book")
        @Expose
        private String book;
        public final static Parcelable.Creator<Morning> CREATOR = new Creator<Morning>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Morning createFromParcel(Parcel in) {
                return new Morning(in);
            }

            public Morning[] newArray(int size) {
                return (new Morning[size]);
            }

        }
                ;

        protected Morning(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.scheduleId = ((String) in.readValue((String.class.getClassLoader())));
            this.startTime = ((String) in.readValue((String.class.getClassLoader())));
            this.endTime = ((String) in.readValue((String.class.getClassLoader())));
            this.intervals = ((String) in.readValue((String.class.getClassLoader())));
            this.status = ((String) in.readValue((String.class.getClassLoader())));
            this.book = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Morning() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getScheduleId() {
            return scheduleId;
        }

        public void setScheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
        }

        public String getStartTime() {
            String[] ls = startTime.split(":");
            return ls[0] + ":" + ls[1];
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getIntervals() {
            return intervals;
        }

        public void setIntervals(String intervals) {
            this.intervals = intervals;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(scheduleId);
            dest.writeValue(startTime);
            dest.writeValue(endTime);
            dest.writeValue(intervals);
            dest.writeValue(status);
            dest.writeValue(book);
        }

        public int describeContents() {
            return 0;
        }

    }






    public static class Afternoon implements Parcelable
    {

        private boolean isSelected;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("schedule_id")
        @Expose
        private String scheduleId;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("intervals")
        @Expose
        private String intervals;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("book")
        @Expose
        private String book;
        public final static Parcelable.Creator<Afternoon> CREATOR = new Creator<Afternoon>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Afternoon createFromParcel(Parcel in) {
                return new Afternoon(in);
            }

            public Afternoon[] newArray(int size) {
                return (new Afternoon[size]);
            }

        }
                ;

        protected Afternoon(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.scheduleId = ((String) in.readValue((String.class.getClassLoader())));
            this.startTime = ((String) in.readValue((String.class.getClassLoader())));
            this.endTime = ((String) in.readValue((String.class.getClassLoader())));
            this.intervals = ((String) in.readValue((String.class.getClassLoader())));
            this.status = ((String) in.readValue((String.class.getClassLoader())));
            this.book = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Afternoon() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getScheduleId() {
            return scheduleId;
        }

        public void setScheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getIntervals() {
            return intervals;
        }

        public void setIntervals(String intervals) {
            this.intervals = intervals;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(scheduleId);
            dest.writeValue(startTime);
            dest.writeValue(endTime);
            dest.writeValue(intervals);
            dest.writeValue(status);
            dest.writeValue(book);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Evening implements Parcelable
    {

        private boolean isSelected;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }


        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("schedule_id")
        @Expose
        private String scheduleId;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("intervals")
        @Expose
        private String intervals;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("book")
        @Expose
        private String book;
        public final static Parcelable.Creator<Evening> CREATOR = new Creator<Evening>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Evening createFromParcel(Parcel in) {
                return new Evening(in);
            }

            public Evening[] newArray(int size) {
                return (new Evening[size]);
            }

        }
                ;

        protected Evening(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.scheduleId = ((String) in.readValue((String.class.getClassLoader())));
            this.startTime = ((String) in.readValue((String.class.getClassLoader())));
            this.endTime = ((String) in.readValue((String.class.getClassLoader())));
            this.intervals = ((String) in.readValue((String.class.getClassLoader())));
            this.status = ((String) in.readValue((String.class.getClassLoader())));
            this.book = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Evening() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getScheduleId() {
            return scheduleId;
        }

        public void setScheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getIntervals() {
            return intervals;
        }

        public void setIntervals(String intervals) {
            this.intervals = intervals;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(scheduleId);
            dest.writeValue(startTime);
            dest.writeValue(endTime);
            dest.writeValue(intervals);
            dest.writeValue(status);
            dest.writeValue(book);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Night implements Parcelable
    {

        private boolean isSelected;

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }


        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("schedule_id")
        @Expose
        private String scheduleId;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("intervals")
        @Expose
        private String intervals;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("book")
        @Expose
        private String book;
        public final static Parcelable.Creator<Night> CREATOR = new Creator<Night>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Night createFromParcel(Parcel in) {
                return new Night(in);
            }

            public Night[] newArray(int size) {
                return (new Night[size]);
            }

        }
                ;

        protected Night(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.scheduleId = ((String) in.readValue((String.class.getClassLoader())));
            this.startTime = ((String) in.readValue((String.class.getClassLoader())));
            this.endTime = ((String) in.readValue((String.class.getClassLoader())));
            this.intervals = ((String) in.readValue((String.class.getClassLoader())));
            this.status = ((String) in.readValue((String.class.getClassLoader())));
            this.book = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Night() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getScheduleId() {
            return scheduleId;
        }

        public void setScheduleId(String scheduleId) {
            this.scheduleId = scheduleId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getIntervals() {
            return intervals;
        }

        public void setIntervals(String intervals) {
            this.intervals = intervals;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(scheduleId);
            dest.writeValue(startTime);
            dest.writeValue(endTime);
            dest.writeValue(intervals);
            dest.writeValue(status);
            dest.writeValue(book);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Slots implements Parcelable
    {

        @SerializedName("Afternoon")
        @Expose
        private List<Morning> afternoon = null;
        @SerializedName("Evening")
        @Expose
        private List<Morning> evening = null;
        @SerializedName("Night")
        @Expose
        private List<Morning> night = null;


        @SerializedName("Morning")
        @Expose
        private List<Morning> morning = null;

        public final static Parcelable.Creator<Slots> CREATOR = new Creator<Slots>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Slots createFromParcel(Parcel in) {
                return new Slots(in);
            }

            public Slots[] newArray(int size) {
                return (new Slots[size]);
            }

        }
                ;

        protected Slots(Parcel in) {
            in.readList(this.afternoon, (com.dr.SamirAbbas.models.AppointmentSlot.Morning.class.getClassLoader()));
            in.readList(this.evening, (com.dr.SamirAbbas.models.AppointmentSlot.Morning.class.getClassLoader()));
            in.readList(this.night, (com.dr.SamirAbbas.models.AppointmentSlot.Morning.class.getClassLoader()));
            in.readList(this.night, (com.dr.SamirAbbas.models.AppointmentSlot.Morning.class.getClassLoader()));

        }

        public Slots() {
        }

        public List<Morning> getAfternoon() {
            return afternoon;
        }

        public void setAfternoon(List<Morning> afternoon) {
            this.afternoon = afternoon;
        }

        public List<Morning> getEvening() {
            return evening;
        }

        public void setEvening(List<Morning> evening) {
            this.evening = evening;
        }

        public List<Morning> getNight() {
            return night;
        }

        public void setNight(List<Morning> night) {
            this.night = night;
        }

        public List<Morning> getMorning() {
            return morning;
        }

        public void setMorning(List<Morning> morning) {
            this.morning = morning;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(afternoon);
            dest.writeList(evening);
            dest.writeList(night);
            dest.writeList(morning);
        }

        public int describeContents() {
            return 0;
        }

    }

}