package leetcode.leetcode17;

public class Leetcode1603 {
    /*Description
    * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
    * 请你实现ParkingSystem类：
    * ParkingSystem(int big, int medium, int small)初始化ParkingSystem类，三个参数分别对应每种停车位的数目。
    * bool addCar(int carType)检查是否有carType对应的停车位。carType有三种类型：大，中，小，
    * 分别用数字1，2和3表示。一辆车只能停在carType对应尺寸的停车位中。
    * 如果没有空车位，请返回false，否则将该车停入车位并返回true。
    * */

    class ParkingSystem {
        int big;
        int medium;
        int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big=big;
            this.medium=medium;
            this.small=small;
        }

        public boolean addCar(int carType) {
            switch(carType){
                case 3:
                    if(big==0)
                        return false;
                    big--;
                    return true;
                case 2:
                    if(medium==0)
                        return false;
                    medium--;
                    return true;
                default:
                    if(small==0)
                        return false;
                    small--;
                    return true;
            }
        }
    }

}
