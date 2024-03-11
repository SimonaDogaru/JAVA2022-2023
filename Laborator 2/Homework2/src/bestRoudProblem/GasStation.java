package bestRoudProblem;

import java.util.Objects;

public class GasStation extends Location{
    private float gasPrice;

    /**
     *
     * @param name
     * @param x
     * @param y
     * @param gasPrice
     */
    public GasStation(String name, double x, double y, float gasPrice) {
        super(name, x, y);
        this.gasPrice=gasPrice;
    }

    /**
     *
     * @param gasPrice
     */
    public void setGasPrice(float gasPrice) {
        this.gasPrice = gasPrice;
    }

    /**
     *
     * @return the price of the Gas
     */
    public float getGasPrice() {
        return gasPrice;
    }

    /**
     *
     * @return an string representing the GasStations object
     */
    @Override
    public String toString() {
        return "GasStation{" +
                "gasPrice=" + gasPrice +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GasStation station = (GasStation) o;
        return Float.compare(station.getGasPrice(), getGasPrice()) == 0;
    }

}

