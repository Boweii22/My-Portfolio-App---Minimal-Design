package com.example.myportfolioapp.contact;

public class ContactItem {
        private int icon;
        private String detail;

        public ContactItem(int icon, String detail) {
            this.icon = icon;
            this.detail = detail;
        }

        public int getIcon() {
            return icon;
        }

        public String getDetail() {
            return detail;
        }
    }

