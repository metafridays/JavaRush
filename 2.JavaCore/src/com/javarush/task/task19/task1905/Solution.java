package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("RU", "Russia");
        countries.put("UA", "Ukraine");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String countryCode = null;
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                if (customer.getCountryName().equals(entry.getValue())) countryCode = entry.getKey();
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            StringBuilder name = new StringBuilder();
            char[] chars = contact.getName().toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i-1] != ',' && chars[i] != ' ') name.insert(0, chars[i]);
                else break;
            }
            return name.toString();
        }

        @Override
        public String getContactLastName() {
            StringBuilder lastname = new StringBuilder();
            char[] chars = contact.getName().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ',' && chars[i+1] != ' ') lastname.append(chars[i]);
                else break;
            }
            return lastname.toString();
        }

        @Override
        public String getDialString() {
            StringBuilder callString = new StringBuilder();
            char[] chars = contact.getPhoneNumber().toCharArray();
            callString.append("callto://");
            for (char c : chars) {
                if (c != '-' && c != '(' && c != ')') callString.append(c);
            }
            return callString.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}