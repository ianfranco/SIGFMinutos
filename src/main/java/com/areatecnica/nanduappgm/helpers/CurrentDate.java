/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.nanduappgm.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ianfr
 */
public class CurrentDate {

    private Calendar calendar;
    private static SimpleDateFormat sdf;
    private Date date;
    private int month;
    private int year;
    private int day;
    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public CurrentDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

        this.calendar = Calendar.getInstance();

        String from = day + "/" + month + "/" + year;
        try {
            this.date = format.parse(from);
            this.calendar.setTime(date);

        } catch (ParseException p) {
        }
    }

    public CurrentDate() {
        this.calendar = Calendar.getInstance();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date date() {
        return date;
    }

    public Date getMaxDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date maxDate;
        String from = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + "/" + month + "/" + year;
        try {
            maxDate = format.parse(from);
            this.calendar.setTime(date);
            return maxDate;
        } catch (ParseException p) {

        }
        return null;
    }

    public int day() {
        return calendar.get(Calendar.DATE);
    }

    public int month() {
        return calendar.get(Calendar.MONTH);
    }

    public int year() {
        return calendar.get(Calendar.YEAR);
    }

    public String format(Date toFormat) {
        return sdf.format(toFormat);
    }

    public String getStringMonthYear() {
        switch (this.month) {
            case 1:
                return "Enero " + this.year;
            case 2:
                return "Febrero " + this.year;
            case 3:
                return "Marzo " + this.year;
            case 4:
                return "Abril " + this.year;
            case 5:
                return "Mayo " + this.year;
            case 6:
                return "Junio " + this.year;
            case 7:
                return "Julio " + this.year;
            case 8:
                return "Agosto " + this.year;
            case 9:
                return "Septiembre " + this.year;
            case 10:
                return "Octubre " + this.year;
            case 11:
                return "Noviembre " + this.year;
            case 12:
                return "Diciembre " + this.year;

        }

        return "SIN VALOR FECHA REGISTRADO";
    }

    @Override
    public String toString() {
        return format.format(date);
    }

}
