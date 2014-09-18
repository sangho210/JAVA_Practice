class Test6 {

    public static void main(String[] args) {//main method

        float f = 0;
        double d = 0;
        for(int i=1;i<=100000;i++){   //i=i+1
            f += 100000;
            d += 100000;
        }

        System.out.println("float: " + f);
        System.out.println("double: " + d);
    }
}