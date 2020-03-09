package lab6.facade;

public class TeaFacade {
    TeaCup teaCup;
    Water water;
    TeaInfuser teaInfuser;

    public TeaFacade(TeaCup teaCup, Water water, TeaInfuser teaInfuser) {
        this.teaCup = teaCup;
        this.water = water;
        this.teaInfuser = teaInfuser;
    }

    public void makeTea(String teaType){
        this.teaInfuser.addTea(new Tea(teaType));
        water.boilWater();
        teaCup.addWater(water);
        teaCup.setSteepTime(15);
        teaCup.steep();
    }
}
