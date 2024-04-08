package kr.excel.example;

public class Member{
    private String name, birthdate, phone, adress;
    private int age;
    private boolean isMarried;

    public Member(String name, String birthdate, String phone, String adress, int age, boolean isMarried) {
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
        this.adress = adress;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return isMarried;
    }
}
