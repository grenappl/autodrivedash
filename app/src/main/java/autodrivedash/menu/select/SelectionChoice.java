package autodrivedash.menu.select;

public class SelectionChoice {
    private String vehicleName, vehicleDesc;

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public SelectionChoice(String vehicleName, String vehicleDesc) {
        this.vehicleName = vehicleName;
        this.vehicleDesc = vehicleDesc;
    }
}
