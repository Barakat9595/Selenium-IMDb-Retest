package DDTClasses;

import org.testng.annotations.DataProvider;

import java.util.List;

public class MovieNameDataProvider {
    @DataProvider(name = "MovieData")
    public Object[][] testData() {
        List<String[]> data = CSVDataReader.getCSVData("path");
        Object[][] dataArray = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = data.get(i);
        }
        return dataArray;
    }
}


