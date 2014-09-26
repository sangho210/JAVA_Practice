package com.score3;

public class ScoreVO {

    private String hak;
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int tot;

//    public ScoreVO(){}
//
//    public ScoreVO(String hak, String name, int kor, int eng, int mat) {
//        this.hak = hak;
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//        this.mat = mat;
//    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public void setHak(String hak) {
        this.hak = hak;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getTot() {
        return kor+eng+mat;
    }

    public String getHak() {
        return hak;
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMat() {
        return mat;
    }

    @Override
    public String toString() {
        String str = String.format("%4s %4s %4d %4d %4d %4d %4.1f",
                hak, name, kor, eng, mat, getTot(), ((double)getTot()/3));
        return str;
    }

}
