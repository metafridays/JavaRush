package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("RU", "Russia");
        countries.put("UA", "Ukraine");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Contact, Customer {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder phoneNumber = new StringBuilder();
            phoneNumber.append(data.getPhoneNumber());
            stringBuilder.append("+");
            stringBuilder.append(data.getCountryPhoneCode());
            stringBuilder.append("(");
            int strLength = phoneNumber.toString().length();
            if (strLength < 10) {
                for (int i = 0; i < 10 - strLength; i++) {
                    phoneNumber.insert(0, '0');
                }
            }
            stringBuilder.append(phoneNumber.toString().substring(0, 3));
            stringBuilder.append(")");
            stringBuilder.append(phoneNumber.toString().substring(3, 6));
            stringBuilder.append("-");
            stringBuilder.append(phoneNumber.toString().substring(6, 8));
            stringBuilder.append("-");
            stringBuilder.append(phoneNumber.toString().substring(8, 10));
            return stringBuilder.toString();
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}