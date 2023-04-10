package peaksoft.city;

public class App {
    public static void main(String[] args) {
        CityService cityService = new CityService();
        City city = new City("Bishkek", 1002000L);
        City city2 = new City("Moscow", 12365000L);
        City city3 = new City("Osh", 992325L);
        City city4 = new City("New York", 21002987L);
//
//        System.out.println(cityService.create(city));
//        System.out.println(cityService.create(city2));
//        System.out.println(cityService.create(city3));
//        System.out.println(cityService.create(city4));

//        for (City city1 : cityService.getAll()) {
//            System.out.println(city1);
//        }
//        cityService.update(3l,"London", 6254789l);
//        cityService.delete(2l);
//        cityService.getAll();
    }
}
