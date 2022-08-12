package ru.otus;

public enum Denoms {
    DENOM_50(500),
    DENOM_100(100),
    DENOM_200(200),
    DENOM_500(500),
    DENOM_1000(1000),
    DENOM_2000(2000),
    DENOM_5000(5000);

    private final int denom;

    Denoms(int denom){
        this.denom = denom;
    }

    public int getDenom(){
        return denom;
    }
}
