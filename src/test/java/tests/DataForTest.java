package tests;
import org.testng.annotations.DataProvider;
public class DataForTest {
     @DataProvider(name = "DataForPost")
	 public Object[][] dataForPost() {
	// 	// Object[][] data =  new Object[3][4];

	// 	// data[0][0] = "Albert";
	// 	// data[0][1] = "Einsten";
	// 	// data[0][2] = 44;
	// 	// data[0][3] = 4;

	// 	// data[1][0] = "Thomas";
	// 	// data[1][1] = "Edision";
	// 	// data[1][2] = 42;
	// 	// data[1][3] = 5;

	// 	// data[2][0] = "Ukraina";
	// 	// data[2][1] = "Nga";
	// 	// data[2][2] = 44;
	// 	// data[2][3] = 1;

	// 	//return data;

	 	return new Object[][] {
            {"Graham", "Bell", 41, 3, 16},
            {"Henry", "Ford", 40, 1, 17},
            {"Mercedes", "Benz", 39, 4, 18}
        };
	 }
}
