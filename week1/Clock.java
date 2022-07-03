public class Clock {
    private int minute;
    private int hour;

    public Clock() {
        minute=0;
        hour=0;
    }

    public void setHour(int h) {
        if(h>=0&&h<24) {
            this.hour = h;
        }else{
            System.out.println("重新输入");
        }
    }
    public void setMinute(int m){
        if(m>=0&&m<60) {
            this.minute = m;
        }else{
            System.out.println("重新输入");
        }
    }

    Clock(int minute, int hour) {
        this.minute = minute;
        this.hour = hour;
    }

    public void tikTok() {
        while(true){
            minute++;
            if(minute ==60){
                minute=0;
                hour++;
                if(hour==24){
                    hour=0;
                }
            }
            System.out.println(toString(hour)+":"+toString(minute));
        }
    }

    private String toString(int n){
        String s="";
        if(n<10){
            s="0"+n;
        }else{
            s= String.valueOf(n);
        }
        return s;
    }



}
