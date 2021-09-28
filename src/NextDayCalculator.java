public class NextDayCalculator {
    public static final String CONCATENATION = "/";

    public static String getNextDay(int day, int month, int year) {
        int lastOfMonth = getLastOfMonth(month);
        int lastOfYear = getLastOfYear(year, month);
        int startOfMonth = 1;
        int startOfYear = 1;
        boolean LASTOFMONT = day == lastOfMonth;
        boolean LASTOFYEAR = day == lastOfYear;
        boolean LASTDAYYEAR = (day == 31 && month == 12);
        if (LASTOFMONT) {
            day = startOfMonth;
            month++;
        } else if (LASTOFYEAR) {
                day = startOfMonth;
                month++;
            }  else {
                    day++;
                }
            if (LASTDAYYEAR){
            day = startOfMonth;
            month = startOfYear;
            year++;
        }
        return day + CONCATENATION + month + CONCATENATION + year;
    }

    private static int getLastOfMonth(int month) {
        int lastOfMonth = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                lastOfMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                lastOfMonth = 30;
                break;

        }
        return lastOfMonth;

    }

    private static boolean checkLeap(int year) {
        boolean isLeap = false;
        boolean year4 = year % 4 == 0;
        boolean year100 = year % 100 == 0;
        boolean year400 = year % 400 == 0;
        if (year4) {
            if (year100) {
                if (year400) {
                    isLeap = true;
                } else isLeap = false;
            } else isLeap = true;
        } else isLeap = false;
        return isLeap;
    }

    private static int getLastOfYear(int year, int month) {
        int lastOfYear = 0;
        if (checkLeap(year)) {
            switch (month) {
                case 2:
                    lastOfYear = 29;
            }
        } else {
            switch (month) {
                case 2:
                    lastOfYear = 28;
            }
        }
        return lastOfYear;
    }


}