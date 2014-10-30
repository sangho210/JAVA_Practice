package com.score6;

/**
 * Created by Administrator on 2014-10-30.
 */
public class Data {
    private String hak, name;
    private int kor, eng, mat, tot, ave;

    public String getHak() {
        return hak;
    }

    public void setHak(String hak) {
        this.hak = hak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getAve() {
        return ave;
    }

    public void setAve(int ave) {
        this.ave = ave;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    @Override
    public String toString() {
        return String.format("%5s %5s %5d %5d %5d %5d %5d", hak, name, kor, eng, mat, tot, ave);
    }
}
