package neir.gleip.drinkmakerv3;


public class Drink {
    private String name, main_alcohol, percentage;

    public Drink() {
    }

    public Drink(String name, String main_alcohol, String percentage) {
        this.name = name;
        this.main_alcohol = main_alcohol;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String year) {
        this.percentage = percentage;
    }

    public String getMain_alcohol() {
        return main_alcohol;
    }

    public void setMain_alcohol(String Main_alcohol) {
        this.main_alcohol = main_alcohol;
    }
}